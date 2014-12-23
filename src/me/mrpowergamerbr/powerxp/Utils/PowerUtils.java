package me.mrpowergamerbr.powerxp.Utils;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

public class PowerUtils {
	
	public static Server getServer()
	  {
	    return Bukkit.getServer();
	  }
	  
	  public static FileConfiguration getConfig()
	  {
	    return getPlugin().getConfig();
	  }
	  
	  public static Plugin getPlugin()
	  {
	    return Bukkit.getPluginManager().getPlugin("PowerInstantXP");
	  }
	  
	  public static Logger getLogger()
	  {
		  return Bukkit.getLogger();
	  }
	  
	  public static void saveConfig()
	  {
		  getPlugin().saveConfig();
		  return;
	  }
	  
	  public static void reloadConfig()
	  {
		  getPlugin().reloadConfig();
		  return;
	  }
	  
	  public static File getDataFolder()
	  {
		  return getPlugin().getDataFolder();
	  }
	  
	  public static void removeInventoryItems(PlayerInventory inv, Material type, int amount) {
		  for (ItemStack is : inv.getContents()) {
			  if (is != null && is.getType() == type) {
				  int newamount = is.getAmount() - amount;
				  if (newamount > 0) {
					  is.setAmount(newamount);
					  break;
				  } else {
					  inv.remove(is);
					  amount = -newamount;
					  if (amount == 0) break;
				  }
			  }
		  }
	  }
}