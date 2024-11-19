package net.acoyt.trinketry.init;

import net.acoyt.trinketry.Trinketry;
import net.acoyt.trinketry.item.CleaverItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public interface ModItems {
    ArrayList<ItemStack> TRINKETRY_ITEMS = new ArrayList();
    ItemGroup TRINKETRY_GROUP = FabricItemGroupBuilder.create(Trinketry.id("trinketry_group")).icon(Trinketry::getRecipeKindIcon).build();
    Map<Item, Identifier> ITEMS = new LinkedHashMap();
    Item CLEAVER = createItem("cleaver", new CleaverItem(new FabricItemSettings().group(TRINKETRY_GROUP)));


    static void init() {
        ITEMS.keySet().forEach((item) -> {
            Registry.register(Registry.ITEM, (Identifier)ITEMS.get(item), item);
        });
    }

    static <T extends Item> T createItem(String name, T item, ItemStack... stacks) {
        ITEMS.put(item, Trinketry.id(name));
        if (stacks.length > 0) {
            ItemStack[] var3 = stacks;
            int var4 = stacks.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                ItemStack stack = var3[var5];
                if (!stack.isEmpty()) {
                    TRINKETRY_ITEMS.add(stack);
                }
            }
        } else {
            TRINKETRY_ITEMS.add(item.getDefaultStack());
        }

        return item;
    }
}
