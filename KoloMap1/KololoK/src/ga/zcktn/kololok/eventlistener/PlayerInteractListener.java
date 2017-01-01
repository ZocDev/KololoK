package ga.zcktn.kololok.eventlistener;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import ga.zcktn.kololok.main.KololoK;

public class PlayerInteractListener implements Listener {

	List<Player> canshoot = new LinkedList<>();
	private KololoK plugin;

	public PlayerInteractListener(KololoK plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent ev) {
		Player p = ev.getPlayer();
		try {
			if (p.getWorld().getName().equals("KololoK")) {
				if (p.getItemInHand().getType() == Material.STONE_SPADE) {
					switch (ev.getAction()) {
					case LEFT_CLICK_AIR:
						reloadGun(p);
						break;
					case LEFT_CLICK_BLOCK:
						reloadGun(p);
						break;
					case RIGHT_CLICK_AIR:
						shoot(p, p.getItemInHand());
						break;
					case RIGHT_CLICK_BLOCK:
						shoot(p, p.getItemInHand());
						break;
					case PHYSICAL:
						break;
					default:
						break;
					}
				}
				if (ev.getClickedBlock().getType() == Material.OBSIDIAN) {
					if (ev.getClickedBlock().getLocation().getWorld()
							.getBlockAt(ev.getClickedBlock().getLocation().getBlockX(), 205,
									ev.getClickedBlock().getLocation().getBlockZ())
							.getType() == Material.COAL_BLOCK) {
						if (ev.getClickedBlock().getLocation().getWorld()
								.getBlockAt(ev.getClickedBlock().getLocation().getBlockX(), 206,
										ev.getClickedBlock().getLocation().getBlockZ())
								.getType() == Material.SIGN_POST) {
							Block b = Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(
									ev.getClickedBlock().getLocation().getBlockX(), 206,
									ev.getClickedBlock().getLocation().getBlockZ());
							Sign s = (Sign) b.getState();
							if (s.getLine(0).equalsIgnoreCase("[kololok]")) {
								switch (s.getLine(1).toUpperCase(Locale.GERMANY)) {
								default:
									break;
								case "CLICK1":
									p.teleport(new Location(Bukkit.getWorld("KololoK"), 20, 36, -146));
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}

	private void reloadGun(Player p) {
		if (p.getInventory().contains(Material.SNOW_BALL)) {
			ItemMeta imWaffe = p.getItemInHand().getItemMeta();
			imWaffe.setDisplayName("§cRevolver §6[§425§6]");
			canshoot.add(p);
			final Player player = p;
			BukkitRunnable r = new BukkitRunnable() {

				@Override
				public void run() {
					canshoot.remove(player);
				}
			};
			r.runTaskLater(plugin, 20);
		}
	}

	@SuppressWarnings("deprecation")
	private void shoot(final Player p, ItemStack inHand) {
		if (!canshoot.contains(p)) {
			p.sendMessage("msg");
			int Schuss = -1;
			String SchussString = inHand.getItemMeta().getDisplayName().split("[")[1];
			SchussString = SchussString.replaceAll("§4", "");
			SchussString = SchussString.replaceAll("§6", "");
			SchussString = SchussString.replaceAll(" ", "");
			SchussString = SchussString.replaceAll("]", "");
			try {
				Schuss = Integer.parseInt(SchussString);
			} catch (Exception ex) {
				p.sendMessage("Error!");
			}
			p.sendMessage(Schuss + "");
			if (Schuss != 0) {
				canshoot.add(p);
				p.shootArrow();
				p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1, 1);
				BukkitRunnable r = new BukkitRunnable() {

					@Override
					public void run() {
						canshoot.remove(p);
					}
				};
				r.runTaskLater(plugin, 4);
			} else {
				p.sendMessage("§3[§4KololoK§3] §2Du musst nachladen!");
			}
		}
	}

}
