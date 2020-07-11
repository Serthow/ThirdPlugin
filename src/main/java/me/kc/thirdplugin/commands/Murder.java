package me.kc.thirdplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Murder implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            System.out.println("Run This Command As A Player");
            return false;
        }
        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage("You Killed Yourself");
            player.setHealth(0);
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null){
            target.sendMessage(ChatColor.DARK_RED + "Player Could Not be Found");
            return false;
        }
        target.sendMessage(player.getDisplayName() + " Murdered you");
        target.setHealth(0);

        return true;
    }
}
