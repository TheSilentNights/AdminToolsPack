package com.thesilentnights.admintoolspack.utils.messageSender;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

abstract public class Message {
    protected CommandSender targetPlayer;
    protected Target target;
    protected String body;

    abstract protected void send();
}

