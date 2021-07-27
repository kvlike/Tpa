package me.kvlike.tpa;

import me.kvlike.tpa.commands.tpaCommand;
import me.kvlike.tpa.commands.tpacceptCommand;
import me.kvlike.tpa.commands.tpdenyCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Tpa extends JavaPlugin {

    public static Map<Player, Player> received;

    @Override
    public void onEnable() {

        received = new HashMap<>();

        getCommand("tpa").setExecutor(new tpaCommand());
        getCommand("tpaccept").setExecutor(new tpacceptCommand());
        getCommand("tpdeny").setExecutor(new tpdenyCommand());

        Bukkit.setWhitelist(false);
    }

}
