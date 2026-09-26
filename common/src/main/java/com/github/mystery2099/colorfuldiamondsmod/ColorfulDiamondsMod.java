package com.github.mystery2099.colorfuldiamondsmod;

import com.github.mystery2099.colorfuldiamondsmod.item.ModItems;

public class ColorfulDiamondsMod {
    public static final String MOD_ID = "colorfuldiamondsmod";

    public static void init(ModRegistrar registrar) {
        ModItems.init(registrar);
        ModBlocks.init(registrar);
    }
}
