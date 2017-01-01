package ga.zcktn.kololok.exe.challenges;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import ga.zcktn.kololok.eventlistener.StartChallengeListener;
import ga.zcktn.kololok.resource.enums.EnumChallenge;

@SuppressWarnings("deprecation")
public class ChallengeHandler implements Listener {

	@EventHandler
	public void onChat(PlayerChatEvent ev) {
		Player p = ev.getPlayer();
		if (StartChallengeListener.istchallenged.contains(p)) {
			EnumChallenge c = StartChallengeListener.challenges.get(p);
			switch (c) {
			case Desperado:
				break;
			case Freedom1:
				break;
			case Heilanstalt:
				break;
			case Insel:
				break;
			case Leben:
				break;
			case LebenzuInsel:
				break;
			case RealLabor1:
				if (ev.getMessage().equals("Real")) {
					p.setWalkSpeed(1f);
					StartChallengeListener.istchallenged.remove(p);
				} else {
					Bukkit.broadcastMessage("ß3[ß4KololoKß3] ß4Falsch!ß2 Achte auf Groﬂ-Klein-Schreibung.");
				}
				break;
			case RealLabor2:
				break;
			case RealLabor3:
				break;
			case Varo3:
				break;
			default:
				break;
			}
		}
	}

}
