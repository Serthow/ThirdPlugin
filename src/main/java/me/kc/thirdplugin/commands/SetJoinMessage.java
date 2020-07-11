package me.kc.thirdplugin.commands;

import me.kc.thirdplugin.ThirdPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetJoinMessage implements CommandExecutor {

    Plugin main = ThirdPlugin.getPlugin(ThirdPlugin.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage("You Used The Command");
        if (args.length == 0){
            player.sendMessage(ChatColor.DARK_RED + "Missing Required arguments <field> <value>");
        }
        else if (args.length == 1){
            player.sendMessage(ChatColor.DARK_RED + "Missing Required argument <value>");
        }
        else{
            if(!main.getConfig().contains(args[0])){
                player.sendMessage(ChatColor.DARK_RED +"Invalid Config Field");
                return false;
            }
            String newMessage = args[1];
            for(int i = 2; i < args.length; i++){
                newMessage += args[i];
            }
            main.getConfig().set(args[0], newMessage);
            player.sendMessage("Join Message Set To:" + ChatColor.GREEN + newMessage);
            return true;
        }



        return false;
    }
}
