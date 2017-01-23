package ga.zcktn.kololok.eventlistener;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import ga.zcktn.kololok.events.StartChallengeEvent;
import ga.zcktn.kololok.resource.enums.EnumChallenge;

public class StartChallengeListener implements Listener {

	public static List<Player> istchallenged = new LinkedList<Player>();
	public static HashMap<Player, EnumChallenge> challenges = new HashMap<Player, EnumChallenge>();

	@EventHandler
	public void onStart(StartChallengeEvent ev) {
		EnumChallenge c = ev.getEnumChallenge();
		String kuerzel = c.getKuerzel();
		Player p = ev.getPlayer();
		if(kuerzel.toUpperCase().equals("LAB1") ||
				kuerzel.toUpperCase().equals("SM") ||
				kuerzel.toUpperCase().equals("INSEL") ||
				kuerzel.toUpperCase().equals("VARO") ||
				kuerzel.toUpperCase().equals("ZUG") ||
				kuerzel.toUpperCase().equals("GUCK") ||
				kuerzel.toUpperCase().equals("RODEO")) {
			istchallenged.add(p);
			challenges.put(p, c);
			p.setWalkSpeed(0);
			return;
		}
	}

}
