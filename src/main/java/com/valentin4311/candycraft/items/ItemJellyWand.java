package valentin4311.candycraft.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import valentin4311.candycraft.entity.EntityGummyBall;

public class ItemJellyWand extends ItemWand
{
	public ItemJellyWand()
	{
		super();
		setMaxStackSize(1);
		setMaxDamage(14);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack item, World world, EntityLivingBase entity, int timeLeft)
	{
		if (item.getItemDamage() == 1)
		{
			for (int i = 0; i < 8; i++)
			{
				world.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				EntityGummyBall ball = new EntityGummyBall(world, entity, 1);
				world.spawnEntity(ball);
				item.setItemDamage(0);
			}
			item.setItemDamage(0);
		}
	}
}
