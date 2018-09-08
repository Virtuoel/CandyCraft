package valentin4311.candycraft.misc;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import valentin4311.candycraft.items.CCItems;

public class EnchantmentDevourer extends Enchantment
{
	public EnchantmentDevourer()
	{
		super(Rarity.UNCOMMON, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
		setName("devourer");
	}

	@Override
	public int getMinEnchantability(int par1)
	{
		return 0;
	}

	@Override
	public boolean canApply(ItemStack par1ItemStack)
	{
		return par1ItemStack.getItem() == CCItems.fork;
	}

	@Override
	public int getMaxEnchantability(int par1)
	{
		return 20;
	}

	@Override
	public int getMaxLevel()
	{
		return 1;
	}
}
