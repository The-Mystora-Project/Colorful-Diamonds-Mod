package com.github.mystery2099.colorfuldiamondsmod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements Tier {

    WHITE_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(0).get(), Items.DIAMOND)),
    ORANGE_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(1).get(), Items.DIAMOND)),
    MAGENTA_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(2).get(), Items.DIAMOND)),
    LIGHT_BLUE_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(3).get(), Items.DIAMOND)),
    YELLOW_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(4).get(), Items.DIAMOND)),
    LIME_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(5).get(), Items.DIAMOND)),
    PINK_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(6).get(), Items.DIAMOND)),
    GRAY_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(7).get(), Items.DIAMOND)),
    LIGHT_GRAY_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(8).get(), Items.DIAMOND)),
    CYAN_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(9).get(), Items.DIAMOND)),
    PURPLE_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(10).get(), Items.DIAMOND)),
    BLUE_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(11).get(), Items.DIAMOND)),
    BROWN_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(12).get(), Items.DIAMOND)),
    GREEN_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(13).get(), Items.DIAMOND)),
    RED_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(14).get(), Items.DIAMOND)),
    BLACK_DIAMOND(() -> Ingredient.of(ModItems.GEMS.get(15).get(), Items.DIAMOND));
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(Supplier<Ingredient> repairIngredient) {
        this.repairIngredient = repairIngredient;
    }

    public int getUses() {
        return 1561;
    }

    public float getSpeed() {
        return 8.0F;
    }

    public float getAttackDamageBonus() {
        return 3.0F;
    }

    public int getLevel() {
        return 3;
    }

    public int getEnchantmentValue() {
        return 10;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
