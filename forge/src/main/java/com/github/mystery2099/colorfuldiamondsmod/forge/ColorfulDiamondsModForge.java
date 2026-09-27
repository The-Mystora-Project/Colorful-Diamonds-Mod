package com.github.mystery2099.colorfuldiamondsmod.forge;

import com.github.mystery2099.colorfuldiamondsmod.ColorfulDiamondsMod;
import com.github.mystery2099.colorfuldiamondsmod.ModBlocks;
import com.github.mystery2099.colorfuldiamondsmod.ModRegistrar;
import com.github.mystery2099.colorfuldiamondsmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Supplier;

@Mod(ColorfulDiamondsMod.MOD_ID)
public class ColorfulDiamondsModForge {
    public ColorfulDiamondsModForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ForgeRegistrar registrar = new ForgeRegistrar();
        ColorfulDiamondsMod.init(registrar);
        registrar.register(bus);
        bus.addListener(this::registerTabs);
    }

    private void registerTabs(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(ColorfulDiamondsMod.MOD_ID, "default"), builder -> builder
                .title(Component.translatable("itemGroup.colorfuldiamondsmod.default"))
                .icon(() -> new ItemStack(ModItems.gem(DyeColor.RED)))
                .displayItems((params, output) -> {
                    ModItems.GEMS.forEach(item -> output.accept(item.get()));
                    ModBlocks.DIAMOND_BLOCK_ITEMS.forEach(item -> output.accept(item.get()));
                }));
        event.registerCreativeModeTab(new ResourceLocation(ColorfulDiamondsMod.MOD_ID, "tools"), builder -> builder
                .title(Component.translatable("itemGroup.colorfuldiamondsmod.tools"))
                .icon(() -> new ItemStack(ModItems.pickaxe(DyeColor.RED)))
                .displayItems((params, output) -> ModItems.TOOLS.forEach(item -> output.accept(item.get()))));
        event.registerCreativeModeTab(new ResourceLocation(ColorfulDiamondsMod.MOD_ID, "combat"), builder -> builder
                .title(Component.translatable("itemGroup.colorfuldiamondsmod.combat"))
                .icon(() -> new ItemStack(ModItems.sword(DyeColor.RED)))
                .displayItems((params, output) -> {
                    ModItems.WEAPONS.forEach(item -> output.accept(item.get()));
                    ModItems.ARMOR.forEach(item -> output.accept(item.get()));
                    ModItems.HORSE_ARMOR.forEach(item -> output.accept(item.get()));
                }));
    }

    private static class ForgeRegistrar implements ModRegistrar {
        private final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, ColorfulDiamondsMod.MOD_ID);
        private final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, ColorfulDiamondsMod.MOD_ID);

        @Override
        public Supplier<Block> registerBlock(String id, Supplier<Block> factory) {
            return blocks.register(id, factory);
        }

        @Override
        public Supplier<Item> registerItem(String id, Supplier<Item> factory) {
            return items.register(id, factory);
        }

        private void register(IEventBus bus) {
            blocks.register(bus);
            items.register(bus);
        }
    }
}
