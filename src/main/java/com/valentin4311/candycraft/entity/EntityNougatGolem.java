package com.valentin4311.candycraft.entity;

import javax.annotation.Nullable;

import com.valentin4311.candycraft.entity.ai.EntityAIExplode;
import com.valentin4311.candycraft.entity.boss.EntityBossBeetle;

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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityNougatGolem extends EntityGolem
{
	private static final DataParameter<Float> HEIGHT = EntityDataManager.<Float>createKey(EntityNougatGolem.class, DataSerializers.FLOAT);
	
	public EntityNougatGolem(World par1World)
	{
		super(par1World);
		setSize(0.65F, getHeight());
		setHealth(20);
		tasks.addTask(1, new EntityAIExplode(this, 1.0D, false));
		tasks.addTask(6, new EntityAIWander(this, 0.6D));
		tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.MOB_SELECTOR));
	}

	public float getHeight()
	{
		return dataManager.get(HEIGHT);
	}

	public void setHeight(float par1)
	{
		setSize(getHeight(), getHeight());
		dataManager.set(HEIGHT, par1);
	}

	public boolean isTop()
	{
		return getControllingPassenger() == null;
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
	protected SoundEvent getHurtSound(DamageSource damageSource)
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
		if (isTop() && getHeight() != 0.8F)
		{
			setHeight(0.8F);
			setSize(0.65F, getHeight());
		}
		if (isBase())
		{
			EntityNougatGolem last = this;
			float height = 0.8F;

			while (!last.isTop())
			{
				height += last.getHeight();
				if (last.getControllingPassenger() instanceof EntityNougatGolem)
				{
					last = (EntityNougatGolem) last.getControllingPassenger();
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
		dataManager.register(HEIGHT, rand.nextFloat() / 10.0F + 0.65F);
	}
	
	@Override
	@Nullable
	public Entity getControllingPassenger()
	{
		return this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
	}
	
	@Override
	public double getMountedYOffset()
	{
		return getHeight();
	}

	@Override
	public boolean shouldDismountInWater(Entity rider)
	{
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (!world.isRemote && par1DamageSource.isExplosion())
		{
			return false;
		}
		if (!world.isRemote && getHealth() - par2 <= 0)
		{
			Entity riddenByEntity = getControllingPassenger();
			if (getRidingEntity() != null && riddenByEntity != null)
			{
				riddenByEntity.dismountRidingEntity();
				riddenByEntity.setPosition(posX, posY + 2.0D, posZ);
				riddenByEntity = null;
				return super.attackEntityFrom(par1DamageSource, par2);
			}
			if (isBase() && riddenByEntity != null)
			{
				riddenByEntity.dismountRidingEntity();
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
		par1NBTTagCompound.setFloat("lenght", getHeight());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		setHeight(par1NBTTagCompound.getFloat("lenght"));
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance instance, IEntityLivingData par1EntityLivingData)
	{
		super.onInitialSpawn(instance, par1EntityLivingData);
		setHeight(rand.nextFloat() / 10 + 0.65F);
		return par1EntityLivingData;
	}
}
