package ga.zcktn.kololok.eventlistener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeaveListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent ev){
		ev.setJoinMessage("");
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent ev){
		ev.setQuitMessage("");
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent ev){
		ev.setLeaveMessage("");
	}
	
}
