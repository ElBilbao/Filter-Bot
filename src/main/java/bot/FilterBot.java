package bot;

import commands.Interface;
import events.Identifier;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 * @author Rodrigo Bilbao
 * @version 1.0
 * @API https://ci.dv8tion.net/job/JDA/javadoc/overview-summary.html
 * @since 2/June/2019
 */
public class FilterBot {

    public static boolean online = true;  // to store the status of the Bot

    public static void main(String args[]) throws Exception {

        // Variables
        Blacklist blacklist = new Blacklist();      // to load blacklist from txt file

        // Create JDA with bot token
        JDA jda = new JDABuilder("INSERT TOKEN HERE").build();

        // Add events to JDA
        jda.addEventListener(new Interface());
        jda.addEventListener(new Identifier());
    }

    /**
     * Method to get the online status of the Bot
     * @return a <code>boolean</code> with true if it's online or false if it's offline
     */
    public static boolean isOnline() {
        return online;
    }

    /**
     * Method to change the status of the Bot
     * @param online a <code>boolean</code> with the new status
     */
    public static void setOnline(boolean online) {
        FilterBot.online = online;
    }
}
