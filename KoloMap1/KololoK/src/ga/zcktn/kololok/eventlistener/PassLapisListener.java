package ga.zcktn.kololok.eventlistener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import ga.zcktn.kololok.events.PassLapisEvent;

public class PassLapisListener implements Listener {
	
	@EventHandler
	public void onPass(PassLapisEvent ev){
		try {
			Player p = Bukkit.getPlayer("FilipZocktanYT");
			p.sendMessage("§3[§4KololoK§3]§rDer Spieler §5" + ev.getPlayer().getName() + " §rpassierte §5" + ev.getEnumChallenge().toString());
		} catch (Exception e) {}
	
		try {
			Player p = Bukkit.getPlayer("TNT_Creepy");

			p.sendMessage("§3[§4KololoK§3]§rDer Spieler §5" + ev.getPlayer().getName() + " §rpassierte §5" + ev.getEnumChallenge().toString());
		} catch (Exception e) {}

	}

}
