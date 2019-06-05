package bot;

import java.io.*;
import java.util.ArrayList;

public class Blacklist {
    public static ArrayList<String> list = new ArrayList<String>();

    public Blacklist() {
        try {
            String word;
            FileReader fileReader = new FileReader("blacklist.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((word = bufferedReader.readLine()) != null) {
                list.add(word);
            }

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

    public static void removeWord(String word) {

    }

}