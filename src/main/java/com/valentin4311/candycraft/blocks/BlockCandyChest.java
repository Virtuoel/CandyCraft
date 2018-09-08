package valentin4311.candycraft.blocks;

import net.minecraft.block.BlockChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import valentin4311.candycraft.blocks.tileentity.TileEntityCandyChest;

public class BlockCandyChest extends BlockChest
{
	public BlockCandyChest(Type type)
	{
		super(type);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityCandyChest tileentitychest = new TileEntityCandyChest();
		return tileentitychest;
	}
}
