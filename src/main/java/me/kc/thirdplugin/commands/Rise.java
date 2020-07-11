package me.kc.thirdplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Rise implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("thirdplugin.teleport.rise")) {
                    Location destination = player.getLocation();
                    destination.add(0, 10, 0);
                    player.teleport(destination);
                    return true;
                }
                else{
                    player.sendMessage("You do not have permission to use this command");
                }
            }

        return false;
    }
}
