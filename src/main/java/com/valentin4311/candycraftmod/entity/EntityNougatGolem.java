package com.valentin4311.candycraftmod.entity;

import com.valentin4311.candycraftmod.entity.ai.EntityAIExplode;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityNougatGolem extends EntityGolem
{
	public EntityNougatGolem(World par1World)
	{
		super(par1World);
		setSize(0.65F, getLenght());
		setHealth(20);
		tasks.addTask(1, new EntityAIExplode(this, 1.0D, false));
		tasks.addTask(6, new EntityAIWander(this, 0.6D));
		tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
	}

	public float getLenght()
	{
		return dataWatcher.getWatchableObjectFloat(16);
	}

	public void setLenght(float par1)
	{
		setSize(getLenght(), getLenght());
		dataWatcher.updateObject(16, Float.valueOf((par1)));
	}

	public boolean isTop()
	{
		return riddenByEntity == null;
	}

	public boolean isBase()
	{
		return getRidingEntity() == null;
	}

	@Override
	public boolean canAttackClass(Class par1Class)
	{
		return EntityPlayer.class.isAssignableFrom(par1Class) ? false : true;
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return null;
	}

	@Override
	protected SoundEvent getHurtSound()
	{
		return null;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return null;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public void onLivingUpdate()
	{
		if (isTop() && getLenght() != 0.8F)
		{
			setLenght(0.8F);
			setSize(0.65F, getLenght());
		}
		if (isBase())
		{
			EntityNougatGolem last = this;
			float height = 0.8F;

			while (!last.isTop())
			{
				height += last.getLenght();
				if (last.riddenByEntity != null)
				{
					last = (EntityNougatGolem) last.riddenByEntity;
				}
				else
				{
					break;
				}
			}
			setSize(0.64F, height);
		}
		super.onLivingUpdate();
		if (getRidingEntity() != null)
		{
			rotationYaw = getRidingEntity().prevRotationYaw;
		}
		if (getRidingEntity() != null)
		{
			getRidingEntity().rotationYaw = getRidingEntity().rotationYaw;
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(16, new Float(rand.nextFloat() / 10 + 0.65F));
	}

	@Override
	public double getMountedYOffset()
	{
		return getLenght();
	}

	@Override
	public boolean shouldDismountInWater(Entity rider)
	{
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (!worldObj.isRemote && par1DamageSource.isExplosion())
		{
			return false;
		}
		if (!worldObj.isRemote && getHealth() - par2 <= 0)
		{
			if (getRidingEntity() != null && riddenByEntity != null)
			{
				riddenByEntity.getRidingEntity() = null;
				riddenByEntity.setPosition(posX, posY + 2.0D, posZ);
				riddenByEntity = null;
				return super.attackEntityFrom(par1DamageSource, par2);
			}
			if (isBase() && riddenByEntity != null)
			{
				riddenByEntity.getRidingEntity() = null;
				riddenByEntity.setPosition(posX, posY + 2.0D, posZ);
				return super.attackEntityFrom(par1DamageSource, par2);
			}
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setFloat("lenght", getLenght());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		setLenght(par1NBTTagCompound.getFloat("lenght"));
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance instance, IEntityLivingData par1EntityLivingData)
	{
		super.onInitialSpawn(instance, par1EntityLivingData);
		setLenght(rand.nextFloat() / 10 + 0.65F);
		return par1EntityLivingData;
	}
}
