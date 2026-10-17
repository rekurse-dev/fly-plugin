package com.rekurse.flyplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("flyplugin.fly")) {
            player.sendMessage("§cYou do not have permission to fly!");
            return true;
        }

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage("§cFlight disabled!");
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage("§aFlight enabled!");
        }

        return true;
    }
}
