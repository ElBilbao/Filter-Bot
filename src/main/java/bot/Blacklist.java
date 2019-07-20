package bot;

import java.io.*;
import java.util.ArrayList;

public class Blacklist {
    public static ArrayList<String> list = new ArrayList<String>();
    public static ArrayList<String> warnedList = new ArrayList<String>();

    public Blacklist() {
        try {
            String word;
            FileReader fileReader = new FileReader("blacklist.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((word = bufferedReader.readLine()) != null) {
                list.add(word);
            }

            fileReader.close();
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.print("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the list of blacklisted words
     *
     * @return a <code>ArrayList<String></code>
     */
    public static ArrayList<String> getList() {
        return list;
    }

    /**
     * Method to add a word to the array of blacklisted words
     *
     * @param word a <code>String</code>
     */
    public static void addWord(String word) {
        list.add(word);
        try {
            FileWriter fileWriter = new FileWriter("blacklist.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("\n" + word);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to remove a word from the blacklisted words
     *
     * @param word a <code>String</code>
     */
    public static void removeWord(String word) {

        // Remove from ArrayList
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(word))
                list.remove(i);
        }

        // Remove from txt file
        ArrayList<String> lines = new ArrayList<String>();
        String line = null;

        try {
            // Copy File
            FileReader fileReader = new FileReader("blacklist.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if (line.equalsIgnoreCase(word))
                    line.replace(word, "ignore");
                else
                    lines.add(line);
            }

            // Flush and close Buffer for memory efficiency
            bufferedReader.close();

            // Paste File - without selected word
            FileWriter fileWriter = new FileWriter("blacklist.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1)
                    bufferedWriter.write(lines.get(i) + "\n");
                else
                    bufferedWriter.write(lines.get(i));
            }

            // Flush and close Buffer for memory efficiency
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to add a user to the warned list
     * @param name a <code>String</code> with the name of the user
     */
    public static void addWarned(String name) {
        warnedList.add(name);
    }

    /**
     * Method used to verify if a user is in the warned list
     * @param name a <code>String</code> with the name of the user
     * @return a <code>boolean</code> whether it appears or it doesn't
     */
    public static boolean check(String name) {
        for (int i = 0; i < warnedList.size(); i++) {
            if(warnedList.get(i).equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}