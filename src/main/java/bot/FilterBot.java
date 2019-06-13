package bot;

import commands.Interface;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 * @author Rodrigo Bilbao
 */
public class FilterBot {

    public static void main(String args[]) throws Exception {

        // Create and load blacklist
        Blacklist blacklist = new Blacklist();

        // Create JDA with bot token
        JDA jda = new JDABuilder("NTg0MTM5MTEyOTk1NDg3Nzc0.XQGmjg.wCNZJ09HJhvhmtolXw3ZW5_-DG8").build();

        // Add events to JDA
        jda.addEventListener(new Interface());

        }
}
