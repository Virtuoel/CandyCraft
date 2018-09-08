package valentin4311.candycraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandyBase extends Block
{
	private Item droppedItem = null;
	private boolean shouldDropItself = true;
	private int minDroppedAmount = 1;
	private int randDroppedAmount = 0;
	private boolean canSilkHarvest = false;
	private boolean defaultSilkTouch = true;
	private int[] metadataList = { 0 };

	public BlockCandyBase(Material material)
	{
		super(material);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return shouldDropItself ? super.getItemDropped(state, rand, fortune) : droppedItem;
	}

	@Override
	public int quantityDropped(Random random)
	{
		return minDroppedAmount + (random.nextInt(randDroppedAmount + 1));
	}

	@Override
	protected boolean canSilkHarvest()
	{
		return defaultSilkTouch ? getDefaultState().isFullCube() : canSilkHarvest;
	}

	@Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for (int i : metadataList)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	/*
	 * Custom Methods
	 */
	public BlockCandyBase setDroppedItem(Item i)
	{
		droppedItem = i;
		shouldDropItself = false;
		return this;
	}

	public BlockCandyBase setSilkHarvest(boolean s)
	{
		canSilkHarvest = s;
		defaultSilkTouch = false;
		return this;
	}

	public BlockCandyBase addMetaToCreative(int... metas)
	{
		metadataList = metas;
		return this;
	}
}
