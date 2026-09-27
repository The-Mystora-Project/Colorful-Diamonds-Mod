package com.github.mystery2099.colorfuldiamondsmod.fabric;

import com.github.mystery2099.colorfuldiamondsmod.fabriclike.FabricLikeRegistration;
import net.fabricmc.api.ModInitializer;

public class ColorfulDiamondsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FabricLikeRegistration.init();
    }
}
