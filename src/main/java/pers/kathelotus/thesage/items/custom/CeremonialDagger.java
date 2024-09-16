package pers.kathelotus.thesage.items.custom;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import pers.kathelotus.thesage.items.ModItems;

public class CeremonialDagger extends SwordItem {
    private static Tier tier = new Tier() {

        @Override
        public int getUses() {
            return 128;
        }
        @Override
        public float getSpeed() {
            return 4;
        }

        @Override
        public float getAttackDamageBonus() {
            return 2;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return null;
        }


        @Override
        public int getEnchantmentValue() {
            return 20;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ModItems.ENTROPIUM_INGOT.get());
        }
    };
    public CeremonialDagger() {
        super(tier,new Properties().attributes(SwordItem.createAttributes(tier, 3, -2.4F)));
    }

}
