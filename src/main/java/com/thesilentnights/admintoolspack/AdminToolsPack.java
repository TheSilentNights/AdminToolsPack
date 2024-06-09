package com.thesilentnights.admintoolspack;

import com.thesilentnights.admintoolspack.commands.CommandImp.Distance;
import com.thesilentnights.admintoolspack.commands.CommandImp.Entity;
import com.thesilentnights.admintoolspack.commands.ICommand;
import com.thesilentnights.admintoolspack.events.IPlayerChat;
import com.thesilentnights.admintoolspack.events.IPlayerJoin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class AdminToolsPack extends JavaPlugin {
    private static AdminToolsPack instance;
    private static FileConfiguration defaultConfig;
    public static final String COMMAND_HEAD = "ToolsPack-";

    @Override
    public void onEnable() {
        //init config
        if (!getDataFolder().exists()) {
            saveDefaultConfig();
        }
        instance = this;
        defaultConfig = getConfig();

        //reg command
        Objects.requireNonNull(getCommand(Distance.COMMAND_NAME)).setExecutor(new Distance());
        Objects.requireNonNull(getCommand(Entity.COMMAND_NAME)).setExecutor(new Entity());

        //reg eventsListener
        getServer().getPluginManager().registerEvents(new IPlayerChat(), this);
        getServer().getPluginManager().registerEvents(new IPlayerJoin(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AdminToolsPack getInstance() {
        return instance;
    }

    public static FileConfiguration getDefaultConfig() {
        return defaultConfig;
    }
}
