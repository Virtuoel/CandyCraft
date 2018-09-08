package com.crypticmushroom.candycraft.entity;

import com.crypticmushroom.candycraft.blocks.CCBlocks;
import com.crypticmushroom.candycraft.entity.boss.EntityBossBeetle;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityKingBeetle extends EntityGolem implements IEntityPowerMount
{
	private static final DataParameter<Integer> POWER = EntityDataManager.<Integer>createKey(EntityKingBeetle.class, DataSerializers.VARINT);
	
	public int explosionCount = 0;

	public EntityKingBeetle(World world)
	{
		super(world);
		setSize(3.0F, 2.0F);
		float var2 = 0.5F;
		tasks.taskEntries.clear();
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAITempt(this, 0.5F, Item.getItemFromBlock(CCBlocks.sugarEssenceFlower), false));
		tasks.addTask(2, new EntityAIWander(this, var2));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(4, new EntityAILookIdle(this));
		setPathPriority(PathNodeType.WATER, -1.0F);
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		if (super.processInteract(player, hand))
		{
			return true;
		}
		else if (!world.isRemote && (getControllingPassenger() == null))
		{
			player.startRiding(this);
			explosionCount = 0;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int powerUsed()
	{
		return 1200;
	}

	@Override
	public int maxPower()
	{
		return 1200;
	}

	@Override
	public void unleashPower()
	{
		setPower(0);
		explosionCount = 8 + rand.nextInt(8);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		Entity controller = getControllingPassenger();

		if (!world.isRemote && explosionCount > 0 && ticksExisted % 5 == 0 && controller != null)
		{
			double d1 = posX + rand.nextInt(6) - 3;
			double d2 = posY + rand.nextInt(5) - 2;
			double d3 = posZ + rand.nextInt(6) - 3;
			world.createExplosion(controller, d1, d2, d3, 2, false);
			for (int x = -3; x < 4; x++)
			{
				for (int z = -3; z < 4; z++)
				{
					if (rand.nextBoolean() && CCBlocks.chewingGumPuddle.canPlaceBlockAt(world, new BlockPos((int) posX + x, (int) posY, (int) posZ + z)))
					{
						world.setBlockState(new BlockPos((int) posX + x, (int) posY, (int) posZ + z), CCBlocks.chewingGumPuddle.getDefaultState());
					}
				}
			}
			explosionCount--;
		}
		if (!world.isRemote && getPower() < maxPower())
		{
			setPower(getPower() + 1);
		}
		if (!inWater && isJumping && controller != null)
		{
			isJumping = false;
			motionY *= 4;
		}
		if (!onGround)
		{
			motionX /= 1.5;
			motionZ /= 1.5;
		}
		if (!world.isRemote && controller != null && controller instanceof EntityLivingBase)
		{
			rotationYaw = ((EntityLivingBase) controller).rotationYawHead;
			prevRotationYaw = ((EntityLivingBase) controller).rotationYawHead;
			EntityLivingBase entitylivingbase = (EntityLivingBase) controller;
			entitylivingbase.moveStrafing = 0;
			float f = controller.rotationYaw + -entitylivingbase.moveStrafing * 90.0F;

			motionX += -Math.sin(f * (float) Math.PI / 180.0F) * 4 * entitylivingbase.moveForward * 0.05000000074505806D;
			motionZ += Math.cos(f * (float) Math.PI / 180.0F) * 4 * entitylivingbase.moveForward * 0.05000000074505806D;

			if (entitylivingbase.moveForward < 0.98)
			{
				motionX = 0;
				motionZ = 0;
				moveForward = 0;
				moveStrafing = 0;
				getNavigator().clearPath();
			}
		}
	}

	@Override
	public void setPower(int i)
	{
		dataManager.set(POWER, i);
	}

	@Override
	public int getPower()
	{
		return dataManager.get(POWER);
	}

	@Override
	public boolean canRiderInteract()
	{
		return false;
	}

	@Override
	public double getMountedYOffset()
	{
		return height - 0.05D;
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (!world.isRemote && par1DamageSource.isExplosion())
		{
			return false;
		}
		Entity entity = par1DamageSource.getImmediateSource();
		return getControllingPassenger() != null && getControllingPassenger().equals(entity) ? false : super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		dataManager.register(POWER, 0);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Power", getPower());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		setPower((par1NBTTagCompound.getInteger("Power")));
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource)
	{
		return null;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return null;
	}
}
