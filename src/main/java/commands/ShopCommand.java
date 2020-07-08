package commands;

import gui.StoreView;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ShopCommand implements CommandExecutor {
    public Plugin pulgin;
    public ShopCommand(Plugin plugin){
        this.pulgin=plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.equalsIgnoreCase("store_opened")){
            commandSender.sendMessage("打开商店");
            Player player = (Player) commandSender;
            if (StoreView.store==null)
                StoreView.setStore();
            player.openInventory(StoreView.store);
        }
        return true;
    }
}
