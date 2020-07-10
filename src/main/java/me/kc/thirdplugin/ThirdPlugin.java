package me.kc.thirdplugin;

import me.kc.thirdplugin.events.JoinOrLeave;
import me.kc.thirdplugin.events.OnDeath;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public final class ThirdPlugin extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("IT STARTED!!!");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
        getServer().getPluginManager().registerEvents(new JoinOrLeave(), this);
    }

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent e){
        Player player = e.getPlayer();
        player.setHealth(player.getMaxHealth());
        player.sendMessage("Health Refilled!");
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent e){
        //runs when leave bed
        Player player = e.getPlayer();
    }
}
