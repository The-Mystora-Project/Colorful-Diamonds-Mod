package com.github.mystery2099.colorfuldiamondsmod.item;

import com.github.mystery2099.colorfuldiamondsmod.ModRegistrar;
import net.minecraft.world.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {
    public static final List<Supplier<Item>> GEMS = new ArrayList<>();
    public static final List<Supplier<Item>> TOOLS = new ArrayList<>();
    public static final List<Supplier<Item>> WEAPONS = new ArrayList<>();
    public static final List<Supplier<Item>> ARMOR = new ArrayList<>();

    public static void init(ModRegistrar registrar) {
        for (var color : DyeColor.values()) {
            GEMS.add(gem(registrar, color));
        }
        for (var material : ModToolMaterials.values()) {
            registerToolSet(registrar, material);
        }
        for (var material : ModArmorMaterials.values()) {
            ARMOR.addAll(registerArmorSet(registrar, material));
        }
    }

    private static Supplier<Item> gem(ModRegistrar registrar, DyeColor color) {
        return register(registrar, color.toString().toLowerCase() + "_diamond", () -> new Item(new Item.Properties()));
    }

    private static List<Supplier<Item>> registerArmorSet(ModRegistrar registrar, ArmorMaterial material) {
        var materialName = material.getName();
        var settings = new Item.Properties();
        return List.of(
            register(registrar, materialName+"_helmet", () -> new ArmorItem(material, ArmorItem.Type.HELMET, settings)),
            register(registrar, materialName+"_chestplate", () -> new ArmorItem(material, ArmorItem.Type.CHESTPLATE, settings)),
            register(registrar, materialName+"_leggings", () -> new ArmorItem(material, ArmorItem.Type.LEGGINGS, settings)),
            register(registrar, materialName+"_boots", () -> new ArmorItem(material, ArmorItem.Type.BOOTS, settings))
        );
    }

    private static void registerToolSet(ModRegistrar registrar, Tier material) {
        var materialName = material.toString().toLowerCase();

        WEAPONS.add(register(registrar, materialName+"_sword", () -> new SwordItem(material, 3, -2.4F, new Item.Properties())));

        var toolSettings = new Item.Properties();
        var tools = List.of(
                register(registrar, materialName+"_shovel", () -> new ShovelItem(material, 1.5F, -3.0F, toolSettings)),
                register(registrar, materialName+"_pickaxe", () -> new PickaxeItem(material, 1, -2.8F, toolSettings) {}),
                register(registrar, materialName+"_axe", () -> new AxeItem(material, 5.0F, -3.0F, toolSettings) {}),
                register(registrar, materialName+"_hoe", () -> new HoeItem(material, -3, 0.0F, toolSettings) {})
        );
        TOOLS.addAll(tools);
    }

    private static Supplier<Item> register(ModRegistrar registrar, String id, Supplier<Item> item) {
        return registrar.registerItem(id, item);
    }
}
