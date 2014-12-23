package me.mrpowergamerbr.powerxp;

import java.util.logging.Level;

import me.mrpowergamerbr.powerxp.Listeners.InteractListener;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		getLogger().log(Level.INFO, "PowerInstantXP Ativado!");
		getServer().getPluginManager().registerEvents(new InteractListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}