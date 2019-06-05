package events;

import bot.Blacklist;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class HelloEvent extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String message[] = event.getMessage().getContentRaw().split(" ");
        ArrayList<String> wordList = Blacklist.list;

        if (message[0].equalsIgnoreCase("!filter")) {
            if (message[1].equalsIgnoreCase("list")) {
                for (int i = 0; i < wordList.size(); i++) {
                    event.getChannel().sendMessage(wordList.get(i)).queue();
                }
            }
        }

    }
}
