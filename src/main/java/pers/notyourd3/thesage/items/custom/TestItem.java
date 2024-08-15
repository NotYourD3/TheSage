package pers.notyourd3.thesage.items.custom;

import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import pers.notyourd3.thesage.util.Rainbow;

import java.awt.*;

public class TestItem extends Item {
    public TestItem() {
        super(new Properties());
    }
    @Override
    public net.minecraft.network.chat.Component getName(ItemStack stack) {
        return net.minecraft.network.chat.Component.literal(Rainbow.makeColour("66666"));
    }
}
