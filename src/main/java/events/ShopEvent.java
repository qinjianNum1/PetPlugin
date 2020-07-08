package events;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import utils.VaultUtil;

import java.util.Hashtable;

public class ShopEvent implements Listener {
    @EventHandler
    public void clickOnInventory(InventoryClickEvent event){
        Inventory inventory = event.getClickedInventory();
        inventory.getViewers();
        int slot = event.getSlot();
        if (inventory.getTitle()=="Store"){
            //处理买卖
            HumanEntity whoClicked = event.getWhoClicked();
            if(VaultUtil.seemoney(whoClicked.getUniqueId())<0)
                return;
            whoClicked.getInventory().addItem(inventory.getItem(slot));
            ((Player) whoClicked).updateInventory();
            event.setCancelled(true);
        }
    }
}
