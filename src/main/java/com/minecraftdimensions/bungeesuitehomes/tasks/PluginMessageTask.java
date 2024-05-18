package com.minecraftdimensions.bungeesuitehomes.tasks;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.minecraftdimensions.bungeesuitehomes.BungeeSuiteHomes;

public class PluginMessageTask extends BukkitRunnable {

	private final ByteArrayOutputStream bytes;

	public PluginMessageTask(ByteArrayOutputStream bytes) {
		this.bytes = bytes;
	}
	
	public void run() {
		getOnlinePlayers().get(0).sendPluginMessage(
				BungeeSuiteHomes.instance,
				BungeeSuiteHomes.OUTGOING_PLUGIN_CHANNEL,
				bytes.toByteArray());
		
	}
	
	public static List<Player> getOnlinePlayers() {
		List<Player> players = new ArrayList<>();
		for (Player all : Bukkit.getOnlinePlayers()) {
			players.add(all);
		}
		return players;
	}
		
}