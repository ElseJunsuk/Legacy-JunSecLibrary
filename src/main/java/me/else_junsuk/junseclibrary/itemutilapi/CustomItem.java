package me.else_junsuk.junseclibrary.itemutilapi;

import lombok.NonNull;
import me.else_junsuk.junseclibrary.JunSecLibrary;
import me.else_junsuk.junseclibrary.stringsapi.Format;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomItem {

    private JavaPlugin plugin;
    private static Format format;

    public CustomItem(JavaPlugin plugin) {
        this.plugin = plugin;
        this.format = new JunSecLibrary(plugin).getFormat();
    }

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
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("아이템 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
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
     * 커스텀 아이템의 모델을 변경합니다.
     * @param type
     * @param amount
     * @param glow
     * @param unbreaking
     * @param flaghide
     * @param custommodeldata
     * @param displayname
     * @param lore
     * @return
     */
    public static ItemStack customItem(@NonNull Material type, @NonNull int amount, @NonNull boolean glow, @NonNull boolean unbreaking, @NonNull boolean flaghide, @NonNull int custommodeldata, @NonNull String displayname, @Nullable String... lore) {
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("아이템 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
            meta.setLore(list);
        }
        if (glow){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unbreaking)
            meta.setUnbreakable(true);
        if (flaghide) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        meta.setCustomModelData(custommodeldata);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * 커스텀 아이템의 이름과 로어을 설정하지 않습니다.
     * @param type
     * @param amount
     * @param glow
     * @param unbreaking
     * @param enchant
     * @param level
     * @return
     */
    public static ItemStack customItem(@NonNull Material type, @NonNull int amount, @NonNull boolean glow, @NonNull boolean unbreaking, @NonNull Enchantment enchant, @NonNull int level) {
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        if (enchant == null) throw new NullPointerException("아이템의 인첸트(Enchant)를 제대로 기입하셨나요? 인첸트는 null일 수 없습니다.");
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (glow){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unbreaking)
            meta.setUnbreakable(true);
        item.addUnsafeEnchantment(enchant, level);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * 커스텀 아이템에 인첸트를 추가할 수 있습니다.
     * @param type
     * @param amount
     * @param glow
     * @param unbreaking
     * @param enchant
     * @param level
     * @param displayname
     * @param lore
     * @return
     */
    public static ItemStack customItem(@NonNull Material type, @NonNull int amount, @NonNull boolean glow, @NonNull boolean unbreaking, @NonNull Enchantment enchant, @NonNull int level, @NonNull String displayname, @Nullable String... lore) {
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        if (enchant == null) throw new NullPointerException("아이템의 인첸트(Enchant)를 제대로 기입하셨나요? 인첸트는 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("아이템 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
            meta.setLore(list);
        }
        if (glow){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unbreaking)
            meta.setUnbreakable(true);
        item.addUnsafeEnchantment(enchant, level);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * @param type Material - 아이템의 타입(Material)을 설정.
     * @param amount int - 아이템의 갯수를 설정.
     * @param glow boolean - 아이템에 인첸트 효과(글로잉)가 적용되는지. (true-적용)
     * @param flaghide boolean - 아이템에 flag를 삭제할건지 (true-삭제)
     * @param unbreaking boolean - 아이템에 내구도 무한 효과가 적용되는지. (true-적용)
     * @param displayname String - 아이템의 커스텀 이름 설정.
     * @param lore String... - 아이템의 커스텀 로어 설정. 콤마(',')로 로어 줄 변경 가능.
     * @return ItemStack
     */
    public static ItemStack customItem(@NonNull Material type, @NonNull int amount, @NonNull boolean glow, @NonNull boolean unbreaking, @NonNull boolean flaghide, @NonNull String displayname, @Nullable String... lore) {
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("아이템 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
            meta.setLore(list);
        }
        if (glow){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unbreaking)
            meta.setUnbreakable(true);
        if (flaghide) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        item.setItemMeta(meta);
        return item;
    }

    /**
     * @param type Material - 아이템의 타입(Material)을 설정.
     * @param amount int - 아이템의 갯수를 설정.
     * @param glow boolean - 아이템에 인첸트 효과(글로잉)가 적용되는지. (true-적용)
     * @param flaghide boolean - 아이템에 flag를 삭제할건지 (true-삭제)
     * @param unbreaking boolean - 아이템에 내구도 무한 효과가 적용되는지. (true-적용)
     * @param displayname String - 아이템의 커스텀 이름 설정.
     * @param lore List - 아이템의 커스텀 로어 설정. asList메소드를 사용해 추가 가능.
     * @return ItemStack
     */
    public static ItemStack customItem(@NonNull Material type, @NonNull int amount, @NonNull boolean glow, @NonNull boolean unbreaking, @NonNull boolean flaghide, @NonNull String displayname, @Nullable List<String> lore) {
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("아이템 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
            meta.setLore(list);
        }
        if (glow){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unbreaking)
            meta.setUnbreakable(true);
        if (flaghide) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack customSkull(@NonNull String playername, @NonNull int amount, @NonNull boolean glow, @NonNull String displayname, @Nullable List<String> lore) {
        if (playername == null) throw new NullPointerException("머리 데이터를 가져올 플레이어의 이름(형태: String)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("머리의 새로운 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");

        ItemStack skull = getPlayerSkull(playername);

        ItemMeta meta = skull.getItemMeta();

        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
            meta.setLore(list);
        }
        if (glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }

        skull.setAmount(amount);
        skull.setItemMeta(meta);
        return skull;
    }

    /**
     * ItemStack형태의 커스텀 아이템 생성을 도와주는 메서드.
     * 자바 엘립스(Ellipsis) 시스템을 사용하지 않은 메서드로,
     * 로어에 문자 배열(String[])을 삽입할 수 있게 해줍니다.
     * @param type Material - 아이템의 타입(Material)을 설정.
     * @param amount int - 아이템의 갯수를 설정.
     * @param glow boolean - 아이템에 인첸트 효과(글로잉)가 적용되는지. (true-적용)
     * @param unbreaking boolean - 아이템에 내구도 무한 효과가 적용되는지. (true-적용)
     * @param displayname String - 아이템의 커스텀 이름 설정.
     * @param lore String[] - 아이템의 커스텀 로어 설정. 배열 형태.
     * @return ItemStack
     */
    public static ItemStack customItemListLore(@NonNull Material type, @NonNull int amount, @NonNull boolean glow, @NonNull boolean unbreaking, @NonNull String displayname, @Nullable String[] lore) {
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("아이템 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
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
        if (playername == null) throw new NullPointerException("머리 데이터를 가져올 플레이어의 이름(형태: String)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        if (displayname == null) throw new NullPointerException("머리의 새로운 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");

        ItemStack skull = getPlayerSkull(playername);

        ItemMeta meta = skull.getItemMeta();

        if (displayname != null)
            meta.setDisplayName(format.format(displayname));
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for (String string : lore)
                list.add(format.format(string));
            meta.setLore(list);
        }
        if (glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }

        skull.setAmount(amount);
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
    public static ItemStack[] equipArmor(@Nullable ItemStack helmet, @Nullable ItemStack chestplate, @Nullable ItemStack leggings, @Nullable ItemStack boots) {
        ItemStack[] armor = new ItemStack[4];
        armor[3] = helmet;
        armor[2] = chestplate;
        armor[1] = leggings;
        armor[0] = boots;
        return armor;
    }

    /**
     * 플레이어의 머리를 ItemStack형식으로 불러옴.
     * @param playername
     * @return ItemStack
     */
    public static ItemStack getPlayerSkull(@NonNull String playername) {
        if (playername == null) throw new NullPointerException("머리 데이터를 가져올 플레이어의 닉네임을 기입하세요. 플레이어의 이름은 null일 수 없습니다.");

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

    /**
     * WRITTEN_BOOK아이템에 내용을 적어 넣을 수 있습니다.
     * @param title - 책의 제목.
     * @param author - 책의 저자로 보일 이름.
     * @param content - 책의 내용. ("", "") 시, 2페이지까지 서술됨. ("1페이지", "2페이지", ...)
     * @return ItemStack
     */
    public static ItemStack createBook(@NonNull String title, @NonNull String author, @NonNull String... content) {
        if (title == null) throw new NullPointerException("책의 제목(title)을 제대로 기입하셨나요? 제목은 null일 수 없습니다.");
        if (author == null) throw new NullPointerException("책의 저자(author)을 제대로 기입하셨나요? 저자는 null일 수 없습니다.");
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

        BookMeta bookMeta = (BookMeta) book.getItemMeta();
        bookMeta.setAuthor(author);
        bookMeta.setTitle(format.format(title));

        if (content != null) {
            List<String> c = new ArrayList<>();
            for (String string : content)
                c.add(format.format(string));
            bookMeta.setPages(c);
        }

        book.setItemMeta(bookMeta);
        return book;
    }

    /**
     *
     * @param item - ItemStack. 이름을 바꿀 아이템
     * @param displayName - String. 변경할 이름
     * @return ItemStack
     */
    public static ItemStack setCustomName(@NonNull ItemStack item, @NonNull String displayName) {
        if (displayName == null) throw new NullPointerException("아이템 이름(DisplayName)을 제대로 기입하셨나요? 이름은 null일 수 없습니다.");
        if (item == null) throw new NullPointerException("베이스 아이템(Item)을 제대로 기입하셨나요? 베이스가 될(이름을 바꿀)아이템은 null일 수 없습니다.");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);
        return item;
    }

    /**
     *
     * @param item - ItemStack. 타입을 바꿀 아이템
     * @param type - Material. 변경할 타입
     * @return ItemStack
     */
    public static ItemStack setItemType(@NonNull ItemStack item, @NonNull Material type) {
        if (item == null) throw new NullPointerException("베이스 아이템(Item)을 제대로 기입하셨나요? 베이스가 될(이름을 바꿀)아이템은 null일 수 없습니다.");
        if (type == null) throw new NullPointerException("아이템 타입(Material)을 제대로 기입하셨나요? 타입은 null일 수 없습니다.");
        item.setType(type);
        return item;
    }

    /**
     * 아이템의 로어를 리플레이스 합니다.
     * @param item
     * @param psffix - 사용할 플레이스 홀더 ex) % -> %test%
     * @param before - 타겟 문자열
     * @param after - 리플레이스
     * @return ItemStack
     */
    public static ItemStack replaceItemLore(@NonNull ItemStack item, String psffix, String before, String after) {
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        ArrayList<String> newLore = (ArrayList<String>) lore.stream().map(s -> s.replace(psffix + before + psffix, after)).collect(Collectors.toList());
        meta.setLore(newLore);
        item.setItemMeta(meta);

        return item;
    }
}
