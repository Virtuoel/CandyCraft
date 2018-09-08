package com.valentin4311.candycraft.entity;

import com.valentin4311.candycraft.blocks.CCBlocks;
import com.valentin4311.candycraft.entity.boss.EntityBossBeetle;
import com.valentin4311.candycraft.items.CCItems;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityPingouin extends EntityAnimal
{
	private static final DataParameter<Boolean> SUPER = EntityDataManager.<Boolean> createKey(EntityPingouin.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> COLOR = EntityDataManager.<Integer>createKey(EntityPingouin.class, DataSerializers.VARINT);

	public EntityPingouin(World par1World)
	{
		super(par1World);
		setSize(0.6F, 1.0F);
		float var2 = 0.5F;
		tasks.taskEntries.clear();
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIPanic(this, 0.38F));
		tasks.addTask(2, new EntityAIMate(this, var2));
		tasks.addTask(3, new EntityAITempt(this, 0.5F, CCItems.cranberryFish, false));
		tasks.addTask(3, new EntityAITempt(this, 0.5F, CCItems.marshmallowFlower, false));
		tasks.addTask(4, new EntityAIFollowParent(this, 0.28F));
		tasks.addTask(5, new EntityAIWander(this, var2));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(7, new EntityAILookIdle(this));
	}

	public void setColor(int i)
	{
		dataManager.set(COLOR, i);
	}

	public int getColor()
	{
		return dataManager.get(COLOR) & 3;
	}

	public void setSuper(boolean i)
	{
		dataManager.set(SUPER, i);
	}

	public boolean isSuper()
	{
		return dataManager.get(SUPER);
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		if (!onGround && motionY < 0.0D)
		{
			motionY *= 0.6D;
		}
	}

	@Override
	public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand)
	{
		ItemStack stackInHand = par1EntityPlayer.getHeldItem(hand);
		if (!world.isRemote && stackInHand != null && stackInHand.getItem() == CCItems.marshmallowFlower)
		{
			entityDropItem(new ItemStack(CCBlocks.iceCream, rand.nextInt(6) + 5, getColor()), 0.5F);
			stackInHand.shrink(1);
		}
		return super.processInteract(par1EntityPlayer, hand);
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	}

	@Override
	public boolean isBreedingItem(ItemStack par1ItemStack)
	{
		return par1ItemStack != null && par1ItemStack.getItem() == CCItems.cranberryFish;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		dataManager.register(SUPER, false);
		dataManager.register(COLOR, 0);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Super", isSuper());
		par1NBTTagCompound.setInteger("Color", getColor());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		setSuper((par1NBTTagCompound.getBoolean("Super")));
		setColor((par1NBTTagCompound.getInteger("Color")));
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance instance, IEntityLivingData par1EntityLivingData)
	{
		super.onInitialSpawn(instance, par1EntityLivingData);
		setColor(rand.nextInt(3));
		if (rand.nextInt(30) == 0)
		{
			setSuper(true);
		}
		return par1EntityLivingData;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	{
		return new EntityPingouin(world);
	}
}
