package ga.zcktn.kololok.eventlistener;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ga.zcktn.kololok.exe.managers.TitleManager;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class PlayerJoinLeaveListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent ev) {
		ev.setJoinMessage("");
		TitleManager.sendTitle("§4Hallo!", "§6Herzlich Willkommen auf dem Roflcopterserver!", 5, 5, 1, (CraftPlayer) ev.getPlayer());
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent ev) {
		ev.setQuitMessage("");
		CraftPlayer p = (CraftPlayer) ev.getPlayer();
		p.getHandle().playerConnection.sendPacket(new PacketPlayOutTitle(EnumTitleAction.RESET, null));
	}

	@EventHandler
	public void onKick(PlayerKickEvent ev) {
		ev.setLeaveMessage("");
	}

}
