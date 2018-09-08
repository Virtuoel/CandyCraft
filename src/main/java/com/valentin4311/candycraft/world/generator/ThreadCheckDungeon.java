package valentin4311.candycraft.world.generator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import valentin4311.candycraft.CandyCraft;
import valentin4311.candycraft.blocks.tileentity.TileEntityTeleporter;

public class ThreadCheckDungeon extends Thread
{
	public EntityPlayer player = null;
	public TileEntityTeleporter teleport = null;
	public int px, py, pz, dim = 0;
	private int keyId;

	public ThreadCheckDungeon(int id)
	{
		keyId = id;
	}

	@Override
	public void run()
	{
		World world = player.world.getMinecraftServer().getWorld(CandyCraft.getDungeonDimensionID());

		int x = 0;
		int id = 0;
		while (!world.isAirBlock(new BlockPos(x, 64, keyId * 10000)))
		{
			x += 1000;
			id++;
		}
		teleport.x = x;
		teleport.y = 65;
		teleport.z = keyId * 10000;
		teleport.oX = px;
		teleport.oY = py;
		teleport.oZ = pz;
		teleport.dim = dim;
		teleport.player = player;
		teleport.dungeonID = id;
		teleport.keyId = keyId;
	}
}
