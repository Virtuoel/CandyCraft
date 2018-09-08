package com.valentin4311.candycraftmod.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityAIWaterMate extends EntityAIBase
{
	private EntityAnimal theAnimal;
	World theWorld;
	private EntityAnimal targetMate;
	int spawnBabyDelay;
	double moveSpeed;

	public EntityAIWaterMate(EntityAnimal p_i1619_1_, double p_i1619_2_)
	{
		theAnimal = p_i1619_1_;
		theWorld = p_i1619_1_.world;
		moveSpeed = p_i1619_2_;
		setMutexBits(3);
	}

	private EntityAnimal getNearbyMate()
	{
		float f = 8.0F;
		List list = theWorld.getEntitiesWithinAABB(theAnimal.getClass(), theAnimal.getEntityBoundingBox().expand(f, f, f));
		double d0 = Double.MAX_VALUE;
		EntityAnimal entityanimal = null;
		Iterator iterator = list.iterator();

		while (iterator.hasNext())
		{
			EntityAnimal entityanimal1 = (EntityAnimal) iterator.next();

			if (theAnimal.canMateWith(entityanimal1) && theAnimal.getDistanceSq(entityanimal1) < d0)
			{
				entityanimal = entityanimal1;
				d0 = theAnimal.getDistanceSq(entityanimal1);
			}
		}

		return entityanimal;
	}

	private void spawnBaby()
	{
		EntityAgeable entityageable = theAnimal.createChild(targetMate);

		if (entityageable != null)
		{
			EntityPlayer entityplayer = theAnimal.getLoveCause();

			if (entityplayer == null && targetMate.getLoveCause() != null)
			{
				entityplayer = targetMate.getLoveCause();
			}

			if (entityplayer != null)
			{
				entityplayer.addStat(StatList.ANIMALS_BRED);
			}

			theAnimal.setGrowingAge(6000);
			targetMate.setGrowingAge(6000);
			theAnimal.resetInLove();
			targetMate.resetInLove();
			entityageable.setGrowingAge(-24000);
			entityageable.setLocationAndAngles(theAnimal.posX, theAnimal.posY, theAnimal.posZ, 0.0F, 0.0F);
			theWorld.spawnEntity(entityageable);
			Random random = theAnimal.getRNG();

			for (int i = 0; i < 7; ++i)
			{
				double d0 = random.nextGaussian() * 0.02D;
				double d1 = random.nextGaussian() * 0.02D;
				double d2 = random.nextGaussian() * 0.02D;
				theWorld.spawnParticle(EnumParticleTypes.HEART, theAnimal.posX + random.nextFloat() * theAnimal.width * 2.0F - theAnimal.width, theAnimal.posY + 0.5D + random.nextFloat() * theAnimal.height, theAnimal.posZ + random.nextFloat() * theAnimal.width * 2.0F - theAnimal.width, d0, d1, d2, new int[0]);
			}

			if (theWorld.getGameRules().getBoolean("doMobLoot"))
			{
				theWorld.spawnEntity(new EntityXPOrb(theWorld, theAnimal.posX, theAnimal.posY, theAnimal.posZ, random.nextInt(7) + 1));
			}
		}
	}

	@Override
	public void resetTask()
	{
		targetMate = null;
		spawnBabyDelay = 0;
	}

	@Override
	public void updateTask()
	{
		++spawnBabyDelay;

		if (spawnBabyDelay >= 60 && theAnimal.getDistanceSq(targetMate) < 9.0D)
		{
			spawnBaby();
		}
	}

	@Override
	public boolean shouldExecute()
	{
		if (!theAnimal.isInLove())
		{
			return false;
		}
		else
		{
			targetMate = getNearbyMate();
			return targetMate != null && isInWater(theAnimal) && isInWater(targetMate);
		}
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		return targetMate.isEntityAlive() && targetMate.isInLove() && spawnBabyDelay < 60 && isInWater(theAnimal) && isInWater(targetMate);
	}

	public boolean isInWater(Entity entity)
	{
		return entity.world.handleMaterialAcceleration(entity.getEntityBoundingBox().expand(0.0D, -0.4000000238418579D, 0.0D), Material.WATER, entity);
	}
}
