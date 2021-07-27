package me.kvlike.tpa.commands;

import me.kvlike.tpa.Tpa;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpdenyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(Tpa.received.containsKey(player) && Tpa.received.get(player).isOnline()){
                player.sendMessage(ChatColor.GREEN + "Prosba o teleportacje odrzucona.");
                Tpa.received.remove(player);
            }
            else{
                player.sendMessage(ChatColor.RED + "Nie masz oczekujacych prosb!");
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "Ta komenda moze byc uzyta tylko przez gracza!");
        }

        return true;
    }
}
