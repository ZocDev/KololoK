package ga.zcktn.kololok.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.zcktn.kololok.skinchanger.HerrBergmannWerden;

public class ToBergmannCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			HerrBergmannWerden tbh = new HerrBergmannWerden((Player)sender);
			Boolean geschafft = tbh.setSkin();
			System.out.println(geschafft);
			sender.sendMessage(geschafft.toString());
			sender.sendMessage("§3Du bist nun Herr Bergmann!");
		}
		return false;
	}

}
