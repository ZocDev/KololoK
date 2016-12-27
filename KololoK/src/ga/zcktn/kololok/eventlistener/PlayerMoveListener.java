package ga.zcktn.kololok.eventlistener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent ev) {
		Player p = ev.getPlayer();
		if (p.getWorld().getName() == "KololoK") {
			Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), 200, p.getLocation().getBlockZ());
			Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX(), 201, p.getLocation().getBlockZ());
			try {
				if (Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(loc).getType() == Material.LAPIS_BLOCK) {
					if(Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(loc2).getType() == Material.SIGN){
						@SuppressWarnings("unused")
						Block b = Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(loc2);
						//TODO: Add Read Lines
						
					}
				}
			} catch (NullPointerException ex) {}
		}
	}
}
