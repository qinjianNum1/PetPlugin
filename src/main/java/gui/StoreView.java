package gui;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;

public class StoreView<HashtableMap> {
    public static Inventory  store;
    public static ArrayList<ItemStack> getMaterials(){
        ArrayList<ItemStack> m_materials=new ArrayList<>();
        m_materials.add(new ItemStack(Material.DIAMOND_SWORD));
        m_materials.add(new ItemStack(Material.APPLE));
        m_materials.add(new ItemStack(Material.STONE));
        //数据先空着
        return m_materials;
    }
    public static void setStore(){
        ArrayList<ItemStack> m_materials=getMaterials();
        store = Bukkit.createInventory(null, 54, "Store");
        for (ItemStack stack:m_materials)
            store.addItem(stack);
    }
}
