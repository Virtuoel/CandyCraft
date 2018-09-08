package valentin4311.candycraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import valentin4311.candycraft.blocks.CCBlocks;

public class ItemCandyBow extends ItemBow
{
	public ItemCandyBow()
	{
		setMaxDamage(100);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return par2ItemStack.getItem() == Item.getItemFromBlock(CCBlocks.caramelBlock);
	}
	
	@Override
	protected boolean isArrow(ItemStack stack)
	{
		return stack.getItem() == CCItems.honeyArrow;
	}
	
	@Override
	public int getItemEnchantability()
	{
		return 1;
	}
}
