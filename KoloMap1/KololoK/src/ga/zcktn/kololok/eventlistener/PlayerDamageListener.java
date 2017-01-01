package ga.zcktn.kololok.eventlistener;

import java.util.Random;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent ev){
		if(ev.getDamager() instanceof Arrow){
		Random r = new Random();
		ev.setDamage(r.nextInt(4)+8);
	}}

}
