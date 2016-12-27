package ga.zcktn.kololok.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ga.zcktn.kololok.eventlistener.PlayerJoinLeaveListener;
import ga.zcktn.kololok.eventlistener.PlayerMoveListener;

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

	}

	private void registerEvents() {

		PluginManager pm = Bukkit.getServer().getPluginManager();

		pm.registerEvents(new PlayerJoinLeaveListener(), this);
		pm.registerEvents(new PlayerMoveListener(), this);
	
	}

}
