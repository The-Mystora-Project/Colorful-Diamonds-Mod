package com.github.mystery2099.colorfuldiamondsmod.fabriclike;

import com.github.mystery2099.colorfuldiamondsmod.ColorfulDiamondsMod;
import com.github.mystery2099.colorfuldiamondsmod.ModBlocks;
import com.github.mystery2099.colorfuldiamondsmod.ModRegistrar;
import com.github.mystery2099.colorfuldiamondsmod.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public final class FabricLikeRegistration {
    private FabricLikeRegistration() {
    }

    public static void init() {
        ColorfulDiamondsMod.init(new ModRegistrar() {
            @Override
            public Supplier<Block> registerBlock(String id, Supplier<Block> factory) {
                Block block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ColorfulDiamondsMod.MOD_ID, id), factory.get());
                return () -> block;
            }

            @Override
            public Supplier<Item> registerItem(String id, Supplier<Item> factory) {
                Item item = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ColorfulDiamondsMod.MOD_ID, id), factory.get());
                return () -> item;
            }
        });

        FabricItemGroup.builder(new ResourceLocation(ColorfulDiamondsMod.MOD_ID, "default"))
                .title(Component.translatable("itemGroup.colorfuldiamondsmod.default"))
                .icon(() -> new ItemStack(ModItems.GEMS.get(0).get()))
                .displayItems((context, entries) -> {
                    ModItems.GEMS.forEach(item -> entries.accept(item.get()));
                    ModBlocks.DIAMOND_BLOCK_ITEMS.forEach(item -> entries.accept(item.get()));
                }).build();
        FabricItemGroup.builder(new ResourceLocation(ColorfulDiamondsMod.MOD_ID, "tools"))
                .title(Component.translatable("itemGroup.colorfuldiamondsmod.tools"))
                .icon(() -> new ItemStack(ModItems.TOOLS.get(0).get()))
                .displayItems((context, entries) -> ModItems.TOOLS.forEach(item -> entries.accept(item.get()))).build();
        FabricItemGroup.builder(new ResourceLocation(ColorfulDiamondsMod.MOD_ID, "combat"))
                .title(Component.translatable("itemGroup.colorfuldiamondsmod.combat"))
                .icon(() -> new ItemStack(ModItems.WEAPONS.get(0).get()))
                .displayItems((context, entries) -> {
                    ModItems.WEAPONS.forEach(item -> entries.accept(item.get()));
                    ModItems.ARMOR.forEach(item -> entries.accept(item.get()));
                }).build();
    }
}
