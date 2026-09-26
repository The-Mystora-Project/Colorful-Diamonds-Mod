package com.github.mystery2099.colorfuldiamondsmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface ModRegistrar {
    Supplier<Block> registerBlock(String id, Supplier<Block> factory);

    Supplier<Item> registerItem(String id, Supplier<Item> factory);
}
