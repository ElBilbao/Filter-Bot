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
                String list = new String();

                // Display list of words inside the blacklist
                for (int i = 0; i < wordList.size(); i++) {
                    if (i < wordList.size() - 1)
                        list += wordList.get(i) + ", ";
                    else
                        list += wordList.get(i);
                }
                event.getChannel().sendMessage(list).queue();

            }

            // Add word
            else if (message[1].equalsIgnoreCase("add") && message.length > 2) {
                for (int i = 2; i < message.length; i++) {
                    Blacklist.addWord(message[i].toLowerCase());
                }

                // Inform user
                if (message.length == 3)
                    event.getChannel().sendMessage("Word was successfully added to the BLACKLIST!").queue();
                else
                    event.getChannel().sendMessage("Words were successfully added to the BLACKLIST!").queue();
            }

            // Remove word
            else if (message[1].equalsIgnoreCase("remove") && message.length > 2) {
                Blacklist.removeWord(message[2]);

                // Inform user
                event.getChannel().sendMessage("Word was successfully removed to the BLACKLIST!").queue();
            }

        }
    }
}
