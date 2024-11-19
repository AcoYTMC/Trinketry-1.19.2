package net.acoyt.trinketry;

import net.acoyt.trinketry.init.ModItems;
import net.acoyt.trinketry.util.CleaverLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Trinketry implements ModInitializer {
	public static final String MOD_ID = "trinketry";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		ModItems.init();

		CleaverLootTableModifiers.modifyLootTables();
	}

	public static ItemStack getRecipeKindIcon() {
		return ModItems.CLEAVER.getDefaultStack();
	}

	public static Identifier id(String name) {
		return new Identifier("trinketry", name);
	}
}