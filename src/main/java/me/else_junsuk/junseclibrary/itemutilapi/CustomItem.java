package me.else_junsuk.junseclibrary.itemutilapi;

import lombok.NonNull;
import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomItem {

    /**
     * ItemStack형태의 커스텀 아이템 생성을 도와주는 메서드.
     * @param type Material - 아이템의 타입(Material)을 설정.
     * @param amount int - 아이템의 갯수를 설정.
     * @param glow boolean - 아이템에 인첸트 효과(글로잉)가 적용되는지. (true-적용)
     * @param unbreaking boolean - 아이템에 내구도 무한 효과가 적용되는지. (true-적용)
     * @param displayname String - 아이템의 커스텀 이름 설정.
     * @param lore String... - 아이템의 커스텀 로어 설정. 콤마(',')로 로어 줄 변경 가능.
     * @return ItemStack
     */
    public static ItemStack customItem(@NonNull Material type, @NonNull int amount, @NonNull boolean glow, @NonNull boolean unbreaking, @NonNull String displayname, @Nullable String... lore) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (displayname != null)
            meta.setDisplayName(F.format(displayname));
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
     * 플레이어의 머리를 가져오고 Meta값을 편집할 수 있음.
     * @param playername - 플레이어의 이름을 가져와야 합니다.
     * @param amount
     * @param glow
     * @param displayname
     * @param lore
     * @return ItemStack
     */
    public static ItemStack customSkull(@NonNull String playername, @NonNull int amount, @NonNull boolean glow, @NonNull String displayname, @Nullable String... lore) {

        ItemStack skull = getPlayerSkull(playername);

        ItemMeta meta = skull.getItemMeta();

        if (displayname != null)
            meta.setDisplayName(F.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(F.format(string));
            meta.setLore(list);
        }
        if (glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }

        skull.setItemMeta(meta);
        return skull;
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
    public static ItemStack[] equipArmor(@NonNull ItemStack helmet, @NonNull ItemStack chestplate, @NonNull ItemStack leggings, @NonNull ItemStack boots) {
        ItemStack[] armor = new ItemStack[4];
        armor[3] = helmet;
        armor[2] = chestplate;
        armor[1] = leggings;
        armor[0] = boots;
        return armor;
    }

    /**
     * 플레이어의 머리를 ItemStack형식으로 불러옴.
     * @param string
     * @return ItemStack
     */
    public static ItemStack getPlayerSkull(@NonNull String playername) {
        boolean isNetVersion = Arrays.stream(Material.values())
                .map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");

        Material type = Material.matchMaterial(isNetVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
        ItemStack item = new ItemStack(type, 1);

        if (!isNetVersion)
            item.setDurability((short) 3);

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(playername);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack createBook(@NonNull String title, String author, String... content) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

        BookMeta bookMeta = (BookMeta) book.getItemMeta();
        bookMeta.setAuthor(author);
        bookMeta.setTitle(F.format(title));

        if (content != null) {
            List<String> c = new ArrayList<>();
            for (String string : content)
                c.add(F.format(string));
            bookMeta.setPages(c);
        }

        book.setItemMeta(bookMeta);
        return book;
    }
}
