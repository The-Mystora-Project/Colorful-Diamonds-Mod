package com.github.mystery2099.colorfuldiamondsmod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final List<Supplier<Block>> DIAMOND_BLOCKS = new ArrayList<>();
    public static final List<Supplier<Item>> DIAMOND_BLOCK_ITEMS = new ArrayList<>();

    public static void init(ModRegistrar registrar) {
        for (var color : DyeColor.values()) {
            register(registrar, color);
        }
    }

    private static void register(ModRegistrar registrar, DyeColor color) {
        var id = color.toString().toLowerCase() + "_diamond_block";
        var block = registrar.registerBlock(id, () -> new Block(BlockBehaviour.Properties.of(Material.METAL, color).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
        DIAMOND_BLOCKS.add(block);
        DIAMOND_BLOCK_ITEMS.add(registrar.registerItem(id, () -> new BlockItem(block.get(), new Item.Properties())));
    }
}
