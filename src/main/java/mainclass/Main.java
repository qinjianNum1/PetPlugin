package mainclass;

import commands.ShopCommand;
import events.ShopEvent;
import gui.StoreView;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import utils.VaultUtil;

public class Main extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        if (VaultUtil.setupEconomy()) {
            getLogger().info("Vault插件加载成功！");
        } else {
            getLogger().info("Vault插件加载失败！");
        }
        Bukkit.getPluginCommand("store_opened").setExecutor(new ShopCommand(this));
        Bukkit.getPluginManager().registerEvents((Listener)new ShopEvent(),this);
        super.onEnable();
    }
}
