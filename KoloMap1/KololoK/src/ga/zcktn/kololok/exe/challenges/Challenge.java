package ga.zcktn.kololok.exe.challenges;

import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import ga.zcktn.kololok.events.StartChallengeEvent;
import ga.zcktn.kololok.exe.managers.TitleManager;
import ga.zcktn.kololok.resource.enums.EnumChallenge;

public class Challenge {

	private String signText = "";
	CraftPlayer p;

	public Challenge(String signText, Player p) {
		this.signText = signText;
		this.p = (CraftPlayer) p;
	}

	public void checkChallenge() {
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		switch (signText.toUpperCase(Locale.GERMAN)) {
		default:
			break;
		case "LAB1":
			TitleManager.sendTitle("§2Wo sind wir?", "§3Antwort in den Chat!", 1, 3, 1, p);
			pm.callEvent(new StartChallengeEvent(p, EnumChallenge.RealLabor1));
			break;
		case "SPY":
			TitleManager.sendTitle("§3Schau dich gut um!", "§4Du wirst es brauchen...", 1, 3, 1, p);
			break;
		case "SPYREADY":
			TitleManager.sendTitle("", "§4Hast du dich fertig umgeschaut?", 1, 3, 1, p);
			pm.callEvent(new StartChallengeEvent(p, EnumChallenge.RealLabor3));
			break;
		case "SM":
			TitleManager.sendTitle("§2Wo sind wir nun?", "§3Antwort in den Chat!", 1, 3, 1, p);
			pm.callEvent(new StartChallengeEvent(p, EnumChallenge.Leben));
			break;
		case "SWIMM":
			TitleManager.sendTitle("§4SCHWIMM!!", "", 1, 3, 1, p);
			break;
		case "INSEL":
			TitleManager.sendTitle("§2Welches Projekt ist das hier?", "§3Antwort in den Chat!", 1, 3, 3, p);
			pm.callEvent(new StartChallengeEvent(p, EnumChallenge.Insel));
			break;
		case "VARO":
			TitleManager.sendTitle("Wasn das hier?", "Antwort in den Chat", 1, 3, 1, p);
			pm.callEvent(new StartChallengeEvent(p,EnumChallenge.Varo3));
		case "ZUG":
			TitleManager.sendTitle("§2Wo sind wir denn hier gelandet?", "§3Antwort in den Chat!", 1, 3, 1, p);
			pm.callEvent(new StartChallengeEvent(p, EnumChallenge.Heilanstalt));
			break;
		case "GUCK":
			TitleManager.sendTitle("§3Guck mal was passiert!", "", 1, 3, 1, p);
			pm.callEvent(new StartChallengeEvent(p, EnumChallenge.Freedom1));
			break;
		case "RODEO":
			TitleManager.sendTitle("§2Wo waren wir denn da?", "§3Antwort in den Chat!", 1, 3, 1, p);
			pm.callEvent(new StartChallengeEvent(p, EnumChallenge.Desperado));
			break;
		}
		
	}

}
