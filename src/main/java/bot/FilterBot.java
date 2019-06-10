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
        JDA jda = new JDABuilder("Insert Token Here").build();

        // Add events to JDA
        jda.addEventListener(new Interface());

    }
}
