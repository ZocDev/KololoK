package ga.zcktn.kololok.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ga.zcktn.kololok.commands.ResetPlayerCommand;
import ga.zcktn.kololok.commands.ToBergmannCommand;
import ga.zcktn.kololok.eventlistener.PassLapisListener;
import ga.zcktn.kololok.eventlistener.PlayerDamageListener;
import ga.zcktn.kololok.eventlistener.PlayerInteractListener;
import ga.zcktn.kololok.eventlistener.PlayerJoinLeaveListener;
import ga.zcktn.kololok.eventlistener.PlayerMoveListener;
import ga.zcktn.kololok.eventlistener.StartChallengeListener;
import ga.zcktn.kololok.exe.challenges.ChallengeHandler;

public class KololoK extends JavaPlugin {

	@Override
	public void onEnable() {

		loadCommands();
		registerEvents();

	}

	@Override
	public void onDisable() {

	}

	private void loadCommands() {
		getCommand("tobergmann").setExecutor(new ToBergmannCommand());
		getCommand("koloreset").setExecutor(new ResetPlayerCommand());
	}

	private void registerEvents() {

		PluginManager pm = Bukkit.getServer().getPluginManager();

		pm.registerEvents(new PlayerJoinLeaveListener(), this);
		pm.registerEvents(new PlayerMoveListener(), this);
		pm.registerEvents(new StartChallengeListener(), this);
		pm.registerEvents(new PassLapisListener(), this);
		pm.registerEvents(new PlayerInteractListener(this), this);
		pm.registerEvents(new PlayerDamageListener(), this);
		pm.registerEvents(new ChallengeHandler(), this);
	
	}

}
