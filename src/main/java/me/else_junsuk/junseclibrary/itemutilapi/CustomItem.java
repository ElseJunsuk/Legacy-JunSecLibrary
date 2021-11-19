package me.else_junsuk.junseclibrary.itemutilapi;

import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItem {

    /**
     * ItemStack형태의 커스텀 아이템 생성을 도와주는 메서드.
     * @param type Material - 아이템의 타입(Material)을 설정.
     * @param amount int - 아이템의 갯수를 설정.
     * @param glow boolean - 아이템에 인첸트 효과(글로잉)가 적용되는지. (true-적용)
     * @param unbreaking boolean - 아이템에 내구도 무한 효과가 적용되는지. (true-적용)
     * @param name String - 아이템의 커스텀 이름 설정.
     * @param lore String... - 아이템의 커스텀 로어 설정. 콤마(',')로 로어 줄 변경 가능.
     * @return ItemStack
     */
    public static ItemStack customItem(Material type, int amount, boolean glow, boolean unbreaking, String name, String... lore) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (name != null)
            meta.setDisplayName(F.format(name));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(F.format(string));
            meta.setLore(list);
        }
        if (glow){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unbreaking)
            meta.setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * 갑옷 메타데이터를 ItemStack[] (배열)형태로 등록하는 메서드.
     * ex) public static final ItemStack[] ARMOR = equipArmor(ItemStack, ItemStack, ItemStack, ItemStack);
     * 사용할 땐 플레이어(Player) 클래스에 상속된 equip메서드를 사용하면 됨.
     * @param helmet ItemStack
     * @param chestplate ItemStack
     * @param leggings ItemStack
     * @param boots ItemStack
     * @return ItemStack[]
     */
    public static ItemStack[] equipArmor(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        ItemStack[] armor = new ItemStack[4];
        armor[3] = helmet;
        armor[2] = chestplate;
        armor[1] = leggings;
        armor[0] = boots;
        return armor;
    }
}
