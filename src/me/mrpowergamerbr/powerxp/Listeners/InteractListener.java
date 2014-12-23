package me.mrpowergamerbr.powerxp.Listeners;

import me.mrpowergamerbr.powerxp.Utils.PowerUtils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener extends PowerUtils implements Listener {
	
	@EventHandler(priority=EventPriority.NORMAL)
	private void onExpThrow(PlayerInteractEvent e)
	{
		// Só iremos fazer a ação se o player clicou com botão DIREITO
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			// Item que o Player está na mão é um Exp Bottle...
			if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() == Material.EXP_BOTTLE) {
				// Se ele tem a permissão desejada...
				if (e.getPlayer().hasPermission("PowerInstantXP.Instant")) {
					// Cancele o Evento
					e.setCancelled(true);
					// Se o Player está com Sneak Ativado, faça que todo o Pack seja jogado de uma vez
					if (e.getPlayer().isSneaking() == true) {
						int i = 0;
						int h = e.getPlayer().getItemInHand().getAmount();
						while (h > i) {
						    e.getPlayer().giveExp(7);
							PowerUtils.removeInventoryItems(e.getPlayer().getInventory(), Material.EXP_BOTTLE, 1);
							e.getPlayer().updateInventory();
							i++;
						}
					} else {
						// Aumente o XP do Player em 7
					    e.getPlayer().giveExp(7);
					    // Remova a Exp Bottle
						PowerUtils.removeInventoryItems(e.getPlayer().getInventory(), Material.EXP_BOTTLE, 1);
						// Atualize o Inventário do Player
						e.getPlayer().updateInventory();
					}
				}
			}
		}
	}
}
