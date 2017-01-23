package ga.zcktn.kololok.eventlistener;

import java.util.HashMap;

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

	HashMap<Player, BukkitRunnable> isReloading = new HashMap<Player, BukkitRunnable>();
	private KololoK plugin;
	String prefix = "§3[§4KololoK§3] ";
	boolean manuelReloading = false;
	int pistol_maxAmmu = 25;
	
	public PlayerInteractListener(KololoK plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent ev) {
		Player p = ev.getPlayer();
		try {
			if(p.getWorld().getName().equals("KololoK")) {
				if(p.getItemInHand().getType() == Material.STONE_SPADE) {
					switch (ev.getAction()) {
					case LEFT_CLICK_AIR:
						if(manuelReloading)
							if(getAmmu(p) != pistol_maxAmmu) {
								reloadGun(p);
							}
						break;
					case LEFT_CLICK_BLOCK:
						if(manuelReloading)
							if(getAmmu(p) != pistol_maxAmmu) {
								reloadGun(p);
							}
						break;
					case RIGHT_CLICK_AIR:
						if(!isReloading.containsKey(p)) {
							shoot(p, p.getItemInHand());
						} else {
							p.sendMessage(prefix+"§2Du lädst gerade nach");
						}
						break;
					case RIGHT_CLICK_BLOCK:
						if(!isReloading.containsKey(p)) {
							shoot(p, p.getItemInHand());
						} else {
							p.sendMessage(prefix+"§2Du lädst gerade nach");
						}
						break;
					case PHYSICAL:
						break;
					default:
						break;
					}
				}
				if(ev.getClickedBlock().getType() == Material.OBSIDIAN) {
					if(ev.getClickedBlock().getLocation().getWorld()
							.getBlockAt(ev.getClickedBlock().getLocation().getBlockX(), 205,
									ev.getClickedBlock().getLocation().getBlockZ())
							.getType() == Material.COAL_BLOCK) {
						if(ev.getClickedBlock().getLocation().getWorld()
								.getBlockAt(ev.getClickedBlock().getLocation().getBlockX(), 206,
										ev.getClickedBlock().getLocation().getBlockZ())
								.getType() == Material.SIGN_POST) {
							Block b = Bukkit.getServer().getWorld(p.getWorld().getName()).getBlockAt(
									ev.getClickedBlock().getLocation().getBlockX(), 206,
									ev.getClickedBlock().getLocation().getBlockZ());
							Sign s = (Sign) b.getState();
							if (s.getLine(0).equalsIgnoreCase("[kololok]")) {
								if(s.getLine(1).toUpperCase().equals("CLICK1")) {
									p.teleport(new Location(Bukkit.getWorld("KololoK"), 20, 36, -146));
								}else{
									return;
								}
							}
						}
					}
				}
			} else {
				
			}
		} catch (Exception e) {
		}
	}
	
	private int getAmmu(Player p) {
		int Schuss = -1;
		String name = p.getItemInHand().getItemMeta().getDisplayName();
		name = name.replace("§4", "");
		name = name.replace("§6", "");
		name = name.replace("§c", "");
		name = name.replace(" ", "");
		name = name.replace("]", "");
		name = name.replace("[", "");
		name = name.replace("Revolver", "");
		try {
			Schuss = Integer.parseInt(name);
		} catch (Exception ex) {
			p.sendMessage("Error!");
		}
		return Schuss;
	}
	
	private void reloadGun(final Player p) {
		if(isReloading.containsKey(p)) {
			return;
		}
		if(p.getInventory().contains(Material.SNOW_BALL)) {
			ItemStack[] magazines = p.getInventory().getContents();
			int slot = 0;
			for(ItemStack i : magazines) {
				if(i.getType() == Material.SNOW_BALL) {
					int amount = i.getAmount();
					amount--;
					if(amount != 0) {
						i.setAmount(amount);
						magazines[slot] = i;
					} else {
						magazines[slot] = new ItemStack(Material.AIR);
					}
					break;
				}
				slot++;
			}
			p.getInventory().setContents(magazines);
			p.getWorld().playSound(p.getLocation(), Sound.BLAZE_BREATH, 1, 1);
			
			isReloading.put(p, new BukkitRunnable() {

				@Override
				public void run() {
					ItemMeta imWaffe = p.getItemInHand().getItemMeta();
					imWaffe.setDisplayName("§cRevolver §6[§4"+pistol_maxAmmu+"§6]");
					ItemStack item = p.getItemInHand();
					item.setItemMeta(imWaffe);
					p.setItemInHand(item);
					isReloading.get(p).cancel();
					isReloading.remove(p);
				}
				
			});
			isReloading.get(p).runTaskLater(this.plugin, 44);
		} else {
			p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1, 1);
			p.sendMessage(prefix+"§2Du hast kein weiteres Magazin im Inventar");
		}
	}
	@SuppressWarnings("deprecation")
	private void shoot(final Player p, ItemStack inHand) {
		int Schuss = -1;
		String name = inHand.getItemMeta().getDisplayName();
		name = name.replace("§4", "");
		name = name.replace("§6", "");
		name = name.replace("§c", "");
		name = name.replace(" ", "");
		name = name.replace("]", "");
		name = name.replace("[", "");
		name = name.replace("Revolver", "");
		try {
			Schuss = Integer.parseInt(name);
		} catch (Exception ex) {
			p.sendMessage("Error!");
		}
		if(Schuss >= 1) {
			Schuss--;
			ItemMeta imWaffe = p.getItemInHand().getItemMeta();
			imWaffe.setDisplayName("§cRevolver §6[§4"+Schuss+"§6]");
			inHand.setItemMeta(imWaffe);
			p.setItemInHand(inHand);
			p.shootArrow();
			p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1, 1);
			if(manuelReloading == false) {
				if(Schuss == 0) {
					reloadGun(p);
				}
			}
		} else {
			p.sendMessage(prefix+"§2Du musst nachladen!");
		}
	}

}
