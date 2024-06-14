package com.thesilentnights.delicatex.feature.chat;

import com.thesilentnights.delicatex.config.Config;
import com.thesilentnights.delicatex.utils.messageSender.MessageSender;
import com.thesilentnights.delicatex.utils.messageSender.messageImp.MessageToALL;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;


public class PlayerChatListener implements Listener {
    private Boolean isEnabled;

    public PlayerChatListener() {
        this.isEnabled = Config.getConfig("config").getBoolean("if-enable-chat_color");
    }

    @EventHandler
    public void PlayerChat(PlayerChatEvent event) {
        event.setCancelled(true);
        if (isEnabled) {
            String content = event.getMessage().replace('&', ChatColor.COLOR_CHAR);
            MessageSender.sendMessage(new MessageToALL(content));
        }
    }
}