package com.github.michaljaz.manhunt;

import java.util.ArrayList;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import java.util.List;

public class Completer implements TabCompleter {

    @Override
    public List < String > onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List < String > list = new ArrayList < > ();
        List < String > possibilities = new ArrayList < > ();
        possibilities.add("hunter");
        possibilities.add("runner");
        possibilities.add("spectator");
        for (String type: possibilities) {
            if (!type.toLowerCase().startsWith(args[0].toLowerCase())) continue;
            list.add(type);
        }
        return list;
    }
}