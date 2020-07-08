package utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class VaultUtil {
    public static Economy economy = null;

    public static boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        return (economy != null);
    }

    public static boolean give(UUID PlayerUUid, double price) {
        OfflinePlayer offplayer = Bukkit.getOfflinePlayer(PlayerUUid);
        return economy.depositPlayer(offplayer, price).transactionSuccess();
    }

    public static double seemoney(UUID PlayerUUid) {
        OfflinePlayer offplayer = Bukkit.getOfflinePlayer(PlayerUUid);
        return economy.getBalance(offplayer);
    }

    public static boolean pay(UUID PlayerUUid, double price) {
        OfflinePlayer offplayer = Bukkit.getOfflinePlayer(PlayerUUid);
        return economy.has(offplayer, price) && economy.withdrawPlayer(offplayer, price).transactionSuccess();
    }
}