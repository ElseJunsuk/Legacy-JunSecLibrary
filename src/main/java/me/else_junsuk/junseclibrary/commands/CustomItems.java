package me.else_junsuk.junseclibrary.commands;

import me.else_junsuk.junseclibrary.JunSecLibrary;
import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItems extends Command {

    public CustomItems(JunSecLibrary main) { super(main, "customitem"); }

    @Override
    public void execute(Player p, String[] args) {
                if (args.length == 0) {
                    F.send(p, "&c사용법 : /customitem [name, addlore, changelore, dellore, reset] [이름, 로어, 라인] [인첸트 레벨]");;
                    return;
                }

                if (args.length > 1) {
                    String settingLore;
                    int i;
                    ItemStack mainHand;
                    ItemMeta mainHandMeta;
                    if (args[0].equalsIgnoreCase("name")) {
                        if (args.length < 2) {
                            F.send(p, "&c사용법 : /customitem name [아이템 이름]");
                            return;
                        }

                        settingLore = "";

                        for (i = 1; i < args.length; ++i) {
                            settingLore = settingLore + args[i];
                            settingLore = settingLore + " ";
                        }

                        mainHand = p.getInventory().getItemInMainHand();
                        mainHandMeta = mainHand.getItemMeta();
                        mainHandMeta.setDisplayName(F.format("&f" + settingLore));
                        mainHand.setItemMeta(mainHandMeta);
                        return;
                    }

                    if (args[0].equalsIgnoreCase("addlore")) {
                        if (args.length < 2) {
                            F.send(p, "&c사용법 : /customitem addlore [추가할 로어]");
                            return;
                        }

                        settingLore = "";

                        for (i = 1; i < args.length; ++i) {
                            settingLore = settingLore + args[i];
                            settingLore = settingLore + " ";
                        }

                        mainHand = p.getInventory().getItemInMainHand();
                        mainHandMeta = mainHand.getItemMeta();
                        List<String> lore = new ArrayList<String>();
                        if (mainHand.hasItemMeta() && mainHandMeta.hasLore()) {
                            lore = mainHandMeta.getLore();
                        }

                        lore.add(F.format("&f" + settingLore));
                        mainHandMeta.setLore(lore);
                        mainHand.setItemMeta(mainHandMeta);
                        return;
                    }

                    if (args[0].equalsIgnoreCase("changelore")) {
                        if (args.length < 3) {
                            F.send(p, "&c사용법 : /customitem changelore [라인] [아이템 설명(로어)]");
                            return;
                        }

                        settingLore = "";

                        for (i = 2; i < args.length; ++i) {
                            settingLore = settingLore + args[i];
                            settingLore = settingLore + " ";
                        }

                        mainHand = p.getInventory().getItemInMainHand();
                        mainHandMeta = mainHand.getItemMeta();
                        List<String> loreLine = mainHandMeta.getLore();
                        i = Integer.parseInt(args[1]);
                        loreLine.set(i, F.format("&f" + settingLore));
                        mainHandMeta.setLore(loreLine);
                        mainHand.setItemMeta(mainHandMeta);
                        return;
                    }


                    int sizeOfLore;
                    if (args[0].equalsIgnoreCase("dellore")) {
                        if (args.length == 2) {
                            mainHand = p.getInventory().getItemInMainHand();
                            mainHandMeta = mainHand.getItemMeta();
                            List<String> loreLine = mainHandMeta.getLore();
                            sizeOfLore = Integer.parseInt(args[1]);
                            loreLine.set(sizeOfLore, F.format("&f"));
                            mainHandMeta.setLore(loreLine);
                            mainHand.setItemMeta(mainHandMeta);
                            return;
                        }

                        F.send(p, "&c사용법 : /customitem dellore [로어 라인]");
                        return;
                    }

                    if (args[0].equalsIgnoreCase("reset")) {
                        if (args.length != 1) {
                            F.send(p, "&c사용법 : /customitem reset");
                            return;
                        }

                        mainHand = p.getInventory().getItemInMainHand();
                        mainHandMeta = mainHand.getItemMeta();
                        List<String> lore = new ArrayList<String>();
                        sizeOfLore = lore.size();

                        for (i = 0; i < sizeOfLore; ++i) {
                            lore.remove(i);
                        }

                        mainHandMeta.setLore(lore);
                        mainHand.setItemMeta(mainHandMeta);
                        return;
                    }

                    if (args[0].equalsIgnoreCase("enchant") && args.length == 3) {
                        mainHand = p.getInventory().getItemInMainHand();
                        mainHandMeta = mainHand.getItemMeta();
                        String enchantName = args[1];
                        sizeOfLore = Integer.parseInt(args[2]);
                        mainHandMeta.addEnchant(
                                Enchantment.getByKey(NamespacedKey.minecraft(enchantName.toLowerCase())), sizeOfLore,
                                true);
                        if (sizeOfLore <= 0) {
                            mainHandMeta.removeEnchant(
                                    Enchantment.getByKey(NamespacedKey.minecraft(enchantName.toLowerCase())));
                        }

                        mainHand.setItemMeta(mainHandMeta);
                        return;
                    }
                }
    }
}
