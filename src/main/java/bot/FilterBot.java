package bot;

import commands.Interface;
import events.Identifier;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 * @API https://ci.dv8tion.net/job/JDA/javadoc/overview-summary.html
 * @author Rodrigo Bilbao
 */
public class FilterBot {

    public static void main(String args[]) throws Exception {

        // Create and load blacklist
        Blacklist blacklist = new Blacklist();

        // Create JDA with bot token
        JDA jda = new JDABuilder("INSERT TOKEN HERE").build();

        // Add events to JDA
        jda.addEventListener(new Interface());
        jda.addEventListener(new Identifier());

    }
}
