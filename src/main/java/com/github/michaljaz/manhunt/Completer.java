package com.github.michaljaz.manhunt;

import java.util.ArrayList;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import java.util.List;
import org.bukkit.entity.Player;

public class Completer implements TabCompleter {

    @Override
    public List < String > onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List < String > list = new ArrayList < > ();
        List < String > posibilities = new ArrayList < > ();
        posibilities.add("hunter");
        posibilities.add("runner");
        posibilities.add("spectator");
        for (String type: posibilities) {
            if (!type.toLowerCase().startsWith(args[0].toLowerCase())) continue;
            list.add(type);
        }
        return list;
    }
}