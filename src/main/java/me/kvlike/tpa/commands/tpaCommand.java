package me.kvlike.tpa.commands;

import me.kvlike.tpa.Tpa;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if (args.length > 0) {
                Player player = (Player) sender;
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target instanceof Player){
                    Tpa.received.put(target, player);
                    player.sendMessage(ChatColor.GREEN + "Prosba o teleportacje wyslana do " + ChatColor.RED + target.getDisplayName());
                    target.sendMessage(ChatColor.GRAY + "Otrzymales prosbe o teleportacje od " + ChatColor.RED + player.getDisplayName());
                    target.sendMessage(ChatColor.GRAY + "Aby zaakceptowac uzyj komendy " + ChatColor.GREEN + "/tpaccept");
                    target.sendMessage(ChatColor.GRAY + "Aby odrzucic uzyj komendy " + ChatColor.GREEN + "/tpdeny");
                }
                else{
                    player.sendMessage(ChatColor.RED + "Ten gracz nie istnieje!");
                }
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "Ta komenda moze byc uzyta tylko przez gracza!");
        }

        return true;
    }
}
