package com.valentin4311.candycraft.entity;

import com.valentin4311.candycraft.blocks.CCBlocks;
import com.valentin4311.candycraft.entity.boss.EntityBossBeetle;

import net.minecraft.block.state.IBlockState;
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
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityDragon extends EntityGolem implements IEntityLockable, IEntityPowerMount
{
	public EntityDragon(World p_i1686_1_)
	{
		super(p_i1686_1_);
		setSize(3.0F, 2.2F);
		float var2 = 0.5F;
		tasks.taskEntries.clear();
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAITempt(this, 0.5F, Item.getItemFromBlock(CCBlocks.sugarEssenceFlower), false));
		tasks.addTask(2, new EntityAIWander(this, var2));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(4, new EntityAILookIdle(this));
		setPathPriority(PathNodeType.WATER, -1.0F);
	}

	public void setFalling(boolean i)
	{
		dataManager.set(FALLING, i);
	}

	public boolean isFalling()
	{
		return dataManager.get(FALLING);
	}

	public void setShoot(int i)
	{
		dataManager.set(SHOOT, i);
	}

	public int getShoot()
	{
		return dataManager.get(SHOOT);
	}

	@Override
	public void setPower(int i)
	{
		dataManager.set(POWER, i);
	}
	
	private static final DataParameter<Integer> POWER = EntityDataManager.<Integer>createKey(EntityDragon.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SHOOT = EntityDataManager.<Integer>createKey(EntityDragon.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> FALLING = EntityDataManager.<Boolean>createKey(EntityDragon.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOCKED = EntityDataManager.<Boolean>createKey(EntityDragon.class, DataSerializers.BOOLEAN);
	
	@Override
	public int getPower()
	{
		return dataManager.get(POWER);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		dataManager.register(POWER, 0);
		dataManager.register(FALLING, false);
		dataManager.register(LOCKED, false);
		dataManager.register(SHOOT, 0);
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
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		if (super.processInteract(player, hand))
		{
			return true;
		}
		else if (!world.isRemote && (getControllingPassenger() == null))
		{
			player.startRiding(this);
			setShoot(0);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int maxPower()
	{
		return 1500;
	}

	@Override
	public int powerUsed()
	{
		return 300;
	}

	@Override
	public void unleashPower()
	{
		setPower(getPower() - 300);
		setShoot(getShoot() + 10 + rand.nextInt(8));
	}
	
	/*// TODO dragon movement
	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (getControllingPassenger() != null && !isFalling())
		{
			if (isInWater())
			{
				this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
				moveEntity(motionX, motionY, motionZ);
				motionX *= 0.800000011920929D;
				motionY *= 0.800000011920929D;
				motionZ *= 0.800000011920929D;
			}
			else if (isNotColliding())
			{
				this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
				moveEntity(motionX, motionY, motionZ);
				motionX *= 0.5D;
				motionY *= 0.5D;
				motionZ *= 0.5D;
			}
			else
			{
				float f2 = 0.91F;

				if (onGround)
				{
					f2 = world.getBlockState(new BlockPos(MathHelper.floor(posX), MathHelper.floor(getEntityBoundingBox().minY) - 1, MathHelper.floor(posZ))).getBlock().slipperiness * 0.91F;
				}
				float f3 = 0.16277136F / (f2 * f2 * f2);
				this.moveFlying(p_70612_1_, p_70612_2_, onGround ? 0.1F * f3 : 0.02F);
				f2 = 0.91F;

				if (onGround)
				{
					f2 = world.getBlockState(new BlockPos(MathHelper.floor(posX), MathHelper.floor(getEntityBoundingBox().minY) - 1, MathHelper.floor(posZ))).getBlock().slipperiness * 0.91F;
				}

				moveEntity(motionX, motionY, motionZ);
				motionX *= f2;
				motionY *= f2;
				motionZ *= f2;
			}

			prevLimbSwingAmount = limbSwingAmount;
			double d1 = posX - prevPosX;
			double d0 = posZ - prevPosZ;
			float f4 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

			if (f4 > 1.0F)
			{
				f4 = 1.0F;
			}

			limbSwingAmount += (f4 - limbSwingAmount) * 0.4F;
			limbSwing += limbSwingAmount;
		}
		else
		{
			super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
		}
	}
*/
	@Override
	protected void updateFallState(double p_180433_1_, boolean p_180433_3_, IBlockState p_180433_4_, BlockPos p_180433_5_)
	{
		if (getControllingPassenger() == null || isFalling())
		{
			super.updateFallState(p_180433_1_, p_180433_3_, p_180433_4_, p_180433_5_);
		}
	}

	@Override
	public boolean isOnLadder()
	{
		return false;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		Entity controller = getControllingPassenger();

		if (!world.isRemote && getPower() < maxPower() && !isFalling())
		{
			setPower(getPower() + 1);
		}
		if (!onGround && world != null)
		{
			motionX /= 1.25;
			motionZ /= 1.25;
			IBlockState st = world.getBlockState(new BlockPos(MathHelper.floor(posX), MathHelper.floor(posY - 0.1D), MathHelper.floor(posZ)));
			if (!world.isAirBlock(new BlockPos(MathHelper.floor(posX), MathHelper.floor(posY - 0.1D), MathHelper.floor(posZ))) && st.getCollisionBoundingBox(world, new BlockPos(MathHelper.floor(posX), MathHelper.floor(posY - 0.1D), MathHelper.floor(posZ))) != null)
			{
				onGround = true;
			}
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

			float nextMotionY = 0.0F;

			if ((((EntityLivingBase) controller).rotationPitch < -10 || ((EntityLivingBase) controller).rotationPitch > 10))
			{
				nextMotionY = -((EntityLivingBase) controller).rotationPitch / 1000;
			}

			if (!isFalling() && !isLocked())
			{
				motionY += nextMotionY;
			}

			if (!world.isRemote && controller != null && !onGround)
			{
				setPower(getPower() - 2);
				if (getPower() < 0)
				{
					setPower(0);
					setFalling(true);
				}
			}
			if (!world.isRemote && isFalling() && onGround)
			{
				setFalling(false);
			}
		}
		if (getShoot() > 0 && ticksExisted % 2 == 0 && controller != null)
		{
			setPositionAndRotation(posX, posY, posZ, controller.rotationYaw, controller.rotationPitch);
			setPositionAndRotationDirect(posX, posY, posZ, controller.rotationYaw, controller.rotationPitch, 0, false);
			if (!world.isRemote)
			{
				EntityGummyBall ball = new EntityGummyBall(world, (EntityLivingBase) controller, 2);
				double d1 = MathHelper.sin(controller.rotationYaw / 180.0F * (float) Math.PI) * 3.5d;
				double d2 = -MathHelper.cos(controller.rotationYaw / 180.0F * (float) Math.PI) * 3.5d;
				ball.posX -= d1;
				ball.posZ -= d2;
				motionX = d1 / 3.4;
				motionZ = d2 / 3.4;
				ball.setPosition(ball.posX, ball.posY, ball.posZ);
				world.playSound(controller.posX, controller.posY, controller.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.HOSTILE, 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F), false);
				world.spawnEntity(ball);
				setShoot(getShoot() - 1);
			}
		}

	}

	@Override
	protected boolean isMovementBlocked()
	{
		return !inWater;
	}

	@Override
	public boolean canRiderInteract()
	{
		return false;
	}

	@Override
	public double getMountedYOffset()
	{
		return height - 1.2D - (Math.sin(ticksExisted * 0.05F) / 6.0);
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
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		Entity entity = par1DamageSource.getImmediateSource();
		return getControllingPassenger() != null && getControllingPassenger().equals(entity) ? false : super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public boolean isLocked()
	{
		return dataManager.get(LOCKED);
	}

	@Override
	public void setLocked(boolean i)
	{
		dataManager.set(LOCKED, i);
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
