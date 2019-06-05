package commands;

import bot.Blacklist;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class Interface extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String message[] = event.getMessage().getContentRaw().split(" ");

        // Filter main core command
        if (message[0].equalsIgnoreCase("!filter")) {

            // Base command
            if (message.length == 1) {
                event.getChannel().sendMessage("To see a list of possible commands use -> !filter help").queue();
            }

            // Help command
            else if (message[1].equalsIgnoreCase("help")) {
                // TODO
            }

            // List command
            else if (message[1].equalsIgnoreCase("list")) {
                ArrayList<String> wordList = Blacklist.list;

                // Display list of words inside the blacklist
                for (int i = 0; i < wordList.size(); i++) {
                    event.getChannel().sendMessage(wordList.get(i)).queue();
                }
            }

            // Add word
            else if (message[1].equalsIgnoreCase("add") && message.length > 2) {
                for (int i = 2; i < message.length; i++) {
                    Blacklist.addWord(message[i].toLowerCase());
                }
            }

        }
    }
}
