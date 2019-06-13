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
        JDA jda = new JDABuilder("NTg0MTM5MTEyOTk1NDg3Nzc0.XP6wNQ.P9SvPkxh35Ck_owa5-SRXSCI-mk").build();

        // Add events to JDA
        jda.addEventListener(new Interface());

        }
}
