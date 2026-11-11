package com.rekurse.flyplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class flyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            if (!sender.hasPermission("flyplugin.fly")) {
                sender.sendMessage("§cYou do not have permission!");
                return true;
            }

            Player target = Bukkit.getPlayerExact(args[0]);

            if (target == null) {
                sender.sendMessage("§cPlayer not found!");
                return true;
            }

            if (args[1].equalsIgnoreCase("enable")) {
                target.setAllowFlight(true);
                sender.sendMessage("§aFlight enabled for " + target.getName());
                target.sendMessage("§aFlight enabled!");
                return true;
            }

            if (args[1].equalsIgnoreCase("disable")) {
                target.setFlying(false);
                target.setAllowFlight(false);
                sender.sendMessage("§cFlight disabled for " + target.getName());
                target.sendMessage("§cFlight disabled!");
                return true;
            }

            sender.sendMessage("§cUsage: /fly <player> <enable|disable>");
            return true;
        }
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
