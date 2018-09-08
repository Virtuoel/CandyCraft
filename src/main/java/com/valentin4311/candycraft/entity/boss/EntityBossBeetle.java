package valentin4311.candycraft.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.CandyCraft;
import valentin4311.candycraft.client.gui.GuiBoss;
import valentin4311.candycraft.entity.EntityBeetle;
import valentin4311.candycraft.entity.EntityGummyBall;
import valentin4311.candycraft.entity.EntityUtil;
import valentin4311.candycraft.entity.ICandyBoss;
import valentin4311.candycraft.items.CCItems;

public class EntityBossBeetle extends EntityGolem implements IMob, ICandyBoss
{
	private static final DataParameter<Boolean> IS_AWAKE = EntityDataManager.<Boolean> createKey(EntityBossBeetle.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TURN = EntityDataManager.<Integer>createKey(EntityBossBeetle.class, DataSerializers.VARINT);

	// TODO Boss Bar
	
	private int coolDown = 100;
	private int shoot = 0;
	private int turn = 0;

	public EntityBossBeetle(World world)
	{
		super(world);
		setSize(2.0F, 1.6F);
		isImmuneToFire = true;
		experienceValue = 500;
	}

	public boolean getAwake()
	{
		return this.dataManager.get(IS_AWAKE).booleanValue();
	}

	public void setAwake(boolean p)
	{
		this.dataManager.set(IS_AWAKE, p);
	}

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, boolean par2)
	{
		int j2 = 1;
		for (int i2 = 0; i2 < j2; i2++)
		{
			EntityGummyBall entity = new EntityGummyBall(world, this, par2 ? 2 : 3);
			if (par2)
			{
				entity.airState = 3;
			}
			entity.beetle = this;
			playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
			world.spawnEntity(entity);
		}
	}

	@Override
	public boolean canBreatheUnderwater()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
	}

	@Override
	public void onLivingUpdate()
	{
		if (!getAwake())
		{
			getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		}
		else
		{
			getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
		}
		super.onLivingUpdate();
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		dataManager.register(IS_AWAKE, false);
		dataManager.register(TURN, 0);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Awake", getAwake());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		setAwake(par1NBTTagCompound.getBoolean("Awake"));
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	@Override
	public boolean isPushedByWater()
	{
		return false;
	}

	@Override
	protected void collideWithNearbyEntities()
	{}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	public void knockBack(Entity p_70653_1_, float p_70653_2_, double p, double q)
	{}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if (!getAwake() && !world.isRemote)
		{
			heal(5.0f);
		}
		if (dataManager.get(TURN) > 0 && world.isRemote)
		{
			for (int i = 0; i <= 16; i++)
			{
				double d1 = -MathHelper.sin((i * 11.25F + ticksExisted) / 90.0F * (float) Math.PI) * (MathHelper.cos(ticksExisted * 0.05F) * 2.5F) + posX;
				double d2 = MathHelper.cos((i * 11.25F + ticksExisted) / 90.0F * (float) Math.PI) * (MathHelper.cos(ticksExisted * 0.05F) * 2.5F) + posZ;
				double d3;
				if (i % 2 == 0)
				{
					d3 = (MathHelper.cos(ticksExisted * 0.05F)) + posY + 3.0D;
				}
				else
				{
					d3 = (MathHelper.cos((ticksExisted + 10) * 0.05F)) + posY + 3.0D;
				}
				world.spawnParticle(EnumParticleTypes.FLAME, d1, d3, d2, 0.0D, 0.0D, 0.0D);
			}
		}
		if (!world.isRemote)
		{
			EntityPlayer player = (world.getClosestPlayerToEntity(this, 10.0D));
			if (player != null)
			{
				setAwake(true);
			}
			if (!getAwake())
			{
				heal(5.0f);
				motionX = 0;
				motionZ = 0;
				rotationYaw = prevRotationYaw;
				rotationPitch = prevRotationPitch;
			}
			else
			{
				EntityPlayer player2 = EntityUtil.getClosestVulnerablePlayerToEntity(world, this, 48.0D);

				if (player2 != null)
				{
					setAttackTarget(player2);
					getLookHelper().setLookPosition(player2.posX, player2.posY + player2.getEyeHeight(), player2.posZ, 10.0F, getVerticalFaceSpeed());
					rotationYaw = rotationYawHead;
					if (shoot > 0 && ticksExisted % 2 == 0)
					{
						shoot--;
						EntityGummyBall ball = new EntityGummyBall(world);
						ball.setPosition(posX, posY + 2, posZ);
						ball.setPowerful(3);
						ball.airState = 1;
						ball.motionY = 1.5;
						ball.motionX = ((rand.nextBoolean() ? -1 : 1) * 3 + rand.nextDouble() * 6) / 40;
						ball.motionZ = ((rand.nextBoolean() ? -1 : 1) * 3 + rand.nextDouble() * 6) / 40;
						ball.target = player2;
						ball.beetle = this;
						world.spawnEntity(ball);
						playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
					}
					if (dataManager.get(TURN) <= 0)
					{
						coolDown--;
					}
					else
					{
						turn -= 1;
						dataManager.set(TURN, turn);
						if (turn < 100)
						{
							attackEntityWithRangedAttack(this, true);
						}
					}
					if (coolDown == 0)
					{
						coolDown = (int) (40 - (35 - ((double) getHealth() / getMaxHealth() * 35)));
						if ((double) getHealth() < 150 && rand.nextInt(6) == 0)
						{
							shoot = 50;
						}
						else if ((double) getHealth() < 250 && rand.nextInt(10) == 0)
						{
							turn = 200;
							dataManager.set(TURN, turn);
						}
						else
						{
							attackEntityWithRangedAttack(player, false);
						}
					}
				}
				else if (world.getClosestPlayerToEntity(this, 48.0D) == null)
				{
					setAwake(false);
					shoot = 0;
					turn = 0;
					dataManager.set(TURN, turn);
				}
			}
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (par1DamageSource.getImmediateSource() != null && par1DamageSource.getImmediateSource() instanceof EntityGummyBall && ((EntityGummyBall) par1DamageSource.getImmediateSource()).getPower() == 3)
		{
			par2 = 8;
			return super.attackEntityFrom(par1DamageSource, par2);
		}
		else
		{
			return false;
		}
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return null;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return null;
	}

	@Override
	public int bossStatue()
	{
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float lastDamage(float par1)
	{
		return ((GuiBoss) CandyCraft.getClientTicker().bossHealth).lastLife += par1;
	}

	@Override
	public double[] getBarColor()
	{
		return new double[] { 0.65F, 0.3F, 0.35F };
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		dropItem(getDropItem(), 1);
		dropItem(CCItems.purpleKey, 1);
	}

	@Override
	protected Item getDropItem()
	{
		return CCItems.CD4;
	}
}
