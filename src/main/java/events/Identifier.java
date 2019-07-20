package events;

import bot.Blacklist;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class Identifier extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        // Don't filter words from bots
        if (!event.getAuthor().isBot()) {
            String message[] = event.getMessage().getContentRaw().split(" ");
            ArrayList<String> list = Blacklist.list;


            // Check if any of the words in the message are blacklisted
            for (int i = 0; i < message.length; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (message[i].equalsIgnoreCase(list.get(j))) {
                        event.getMessage().delete().queue();
                        String author = event.getAuthor().getName();

                        // Check if it's the user's 1st or 2nd warning
                        if (Blacklist.check(event.getAuthor().getName())) {
                            Guild guild = event.getGuild();
                            guild.mute(event.getMember(), true).queue();
                            event.getChannel().sendMessage(author + " was muted for using profanity.\nContact an admin to be unmuted.").queue();
                        } else {
                            Blacklist.addWarned(event.getAuthor().getName());
                            event.getChannel().sendMessage(author + ", please avoid using blacklisted words.\nTo view the blacklisted words use -> !filter list").queue();
                        }
                    }
                }
            }
        }
    }

}
