package com.github.michaljaz.manhunt;

import java.util.ArrayList;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import java.util.List;
import org.bukkit.entity.Player;

public class Completer implements TabCompleter {

	@Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
	    List<String> factions = new ArrayList<>();
        factions.add("hunter");
        factions.add("runner");
        factions.add("spectator");
        for (String faction : factions) {
            if (!faction.toLowerCase().startsWith(args[0].toLowerCase())) continue;
            list.add(faction);
        }
	    return list;
    }
}