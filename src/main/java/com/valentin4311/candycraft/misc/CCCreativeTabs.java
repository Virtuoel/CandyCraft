package valentin4311.candycraft.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import valentin4311.candycraft.blocks.CCBlocks;

public class CCCreativeTabs extends CreativeTabs
{

	public CCCreativeTabs(String label)
	{
		super(label);
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(CCBlocks.marshmallowWorkbench);
	}
}
