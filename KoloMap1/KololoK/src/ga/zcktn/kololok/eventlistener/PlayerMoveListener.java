package ga.zcktn.kololok.eventlistener;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ga.zcktn.kololok.events.PassLapisEvent;
import ga.zcktn.kololok.exe.challenges.Challenge;
import ga.zcktn.kololok.resource.enums.EnumChallenge;

public class PlayerMoveListener implements Listener {

	public static List<String> wasbefore = new LinkedList<String>();
	EnumChallenge c = EnumChallenge.Desperado;

	@EventHandler
	public void onMove(PlayerMoveEvent ev) {
		Player p = ev.getPlayer();
		if (p.getWorld().getName().equals("KololoK")) {
			Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), 200, p.getLocation().getBlockZ());
			Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX(), 201, p.getLocation().getBlockZ());
			try {
				if (Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(loc)
						.getType() == Material.LAPIS_BLOCK) {
					if (Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(loc2)
							.getType() == Material.SIGN_POST) {
						Block b = Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(loc2);
						Sign s = (Sign) b.getState();
						if (s.getLine(0).equalsIgnoreCase("[kololok]")) {
							if (!wasbefore.contains(p.getName()+"|"+s.getLine(1))) {
								wasbefore.add(p.getName()+"|"+s.getLine(1));
								Challenge ch = new Challenge(s.getLine(1), p);
								Bukkit.getServer().getPluginManager().callEvent(new PassLapisEvent(p, c.getbyKuerzel(s.getLine(1))));
								ch.checkChallenge();
							}
						}
					} 
				} 
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}
	}
}
