package ga.zcktn.kololok.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.zcktn.kololok.eventlistener.PlayerMoveListener;

public class ResetPlayerCommand implements CommandExecutor {
	ArrayList<String> removeIds = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {

				for (String id : PlayerMoveListener.wasbefore) {
					if (id.contains(p.getName())) {
						p.sendMessage("Removed Checkpoint \"" + id.replaceAll(p.getName()+"|", "") + "\"for Player " + p.getName());
						this.removeIds.add(id);
					}
				}
				p.sendMessage("Alle Checkpoints resetet.");
			} else if (args.length == 1) {
				for (String id : PlayerMoveListener.wasbefore) {
					if (id.contains(args[0])) {
						p.sendMessage("Removed Checkpoint \"" + id.replaceAll(args[0]+"|", "") + "\"for Player " + args[0]);
						this.removeIds.add(id);
					}
				}
				p.sendMessage("Alle Checkpoints resetet.");

			} else {
				p.sendMessage("§3[§4KololoK§3]§rMögliche Syntaxe:");
				p.sendMessage("\"/koloreset\"");
				p.sendMessage("\"/koloreset <Player>\"");
			}
			for (String id : removeIds) {
				PlayerMoveListener.wasbefore.remove(id);
			}
		}
		return false;
	}

}
