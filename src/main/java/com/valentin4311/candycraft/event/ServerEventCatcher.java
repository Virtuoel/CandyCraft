package valentin4311.candycraft.event;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import valentin4311.candycraft.CandyCraft;
import valentin4311.candycraft.blocks.CCBlocks;
import valentin4311.candycraft.blocks.tileentity.TileEntityTeleporter;
import valentin4311.candycraft.entity.EntityCandyCreeper;
import valentin4311.candycraft.entity.EntitySuguard;
import valentin4311.candycraft.entity.IEntityLockable;
import valentin4311.candycraft.entity.IEntityPowerMount;
import valentin4311.candycraft.entity.boss.EntityBossSuguard;
import valentin4311.candycraft.entity.boss.EntityJellyQueen;
import valentin4311.candycraft.items.CCItems;
import valentin4311.candycraft.items.ItemBossKey;
import valentin4311.candycraft.misc.CCAchievements;

public class ServerEventCatcher
{
	@SubscribeEvent
	public void onChatReceive(ServerChatEvent event)
	{
		if (event.getMessage().equals("%CandyCraft-Jump-Mount%") && event.getPlayer() != null && event.getPlayer().getRidingEntity() != null && event.getPlayer().getRidingEntity() instanceof IEntityPowerMount)
		{
			IEntityPowerMount mount = (IEntityPowerMount) event.getPlayer().getRidingEntity();
			EntityLiving mount2 = (EntityLiving) event.getPlayer().getRidingEntity();
			if (mount.getPower() >= mount.maxPower() / 10 && mount2.onGround)
			{
				mount.setPower(mount.getPower() - mount.maxPower() / 10);
				mount2.getJumpHelper().setJumping();
			}
			event.setCanceled(true);
		}
		if (event.getMessage().equals("%CandyCraft-Lock-Mount%") && event.getPlayer() != null && event.getPlayer().getRidingEntity() != null && event.getPlayer().getRidingEntity() instanceof IEntityLockable)
		{
			IEntityLockable mount = (IEntityLockable) event.getPlayer().getRidingEntity();
			mount.setLocked(!mount.isLocked());
			event.setCanceled(true);
		}
		if (event.getMessage().equals("%CandyCraft-Power-Mount%") && event.getPlayer() != null && event.getPlayer().getRidingEntity() != null && event.getPlayer().getRidingEntity() instanceof IEntityPowerMount)
		{
			IEntityPowerMount mount = (IEntityPowerMount) event.getPlayer().getRidingEntity();
			if (mount.getPower() >= mount.powerUsed())
			{
				mount.unleashPower();
			}
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onWorldTick(WorldTickEvent event)
	{
		if (event.side == Side.SERVER && event.phase == Phase.START)
		{
			CandyCraft.getServerTicker().onWorldTick(event.world);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{
		if (event.side == Side.SERVER && event.phase == Phase.END)
		{
			CandyCraft.getServerTicker().onPlayerTick(event.player);
		}
	}

	@SubscribeEvent
	public void onCraft(ItemCraftedEvent event)
	{
		// TODO advancements
	//	CCAchievements.onCraft(event.crafting, event.player);
	}

	@SubscribeEvent
	public void onSmelt(ItemSmeltedEvent event)
	{
		// TODO advancements
	//	CCAchievements.onSmelt(event.smelting, event.player);
	}

	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event)
	{
		if (!event.getWorld().isRemote)
		{
			if (event.getEntity().getClass() == EntityItem.class)
			{
				EntityItem entityItem = (EntityItem) event.getEntity();
				if (entityItem.getItem() != null && entityItem.getItem().getItem() instanceof ItemBossKey)
				{
					((EntityItem) event.getEntity()).setNoDespawn();
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerPlaceEvent(PlaceEvent event)
	{
		if (event.getWorld().provider.getDimension() == CandyCraft.getDungeonDimensionID())
		{
			// event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onBreakSpeed(BreakSpeed event)
	{
		if (event.getEntity() != null && event.getEntity().world.provider.getDimension() == CandyCraft.getDungeonDimensionID())
		{
			if (!(event.getState().getBlock() instanceof BlockContainer))
			{
				// event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(RightClickBlock event)
	{
		// Dungeon TODO reverse
		if (event.getEntity() != null && event.getEntity().world.provider.getDimension() == CandyCraft.getDungeonDimensionID() && event.getEntity().world.getBlockState(event.getPos()).getBlock() != Blocks.LEVER && event.getEntity().world.getBlockState(event.getPos()).getBlock() != CCBlocks.jellySentryKeyHole && event.getEntity().world.getBlockState(event.getPos()).getBlock() != CCBlocks.jellyBossKeyHole && event.getEntity().world.getBlockState(event.getPos()).getBlock() != CCBlocks.blockTeleporter && event.getEntity().world.getBlockState(event.getPos()).getBlock() != CCBlocks.marshmallowChest)
		{
			// event.setCanceled(true);
			return;
		}

		// Juxebox
		if (event.getEntityPlayer().getHeldItem(event.getHand()) != null && event.getEntityPlayer().getHeldItem(event.getHand()).getItem() instanceof ItemRecord)
		{
			IBlockState b = event.getWorld().getBlockState(event.getPos());

			if (b.getBlock() == CCBlocks.cottonCandyJukebox)
			{
				BlockJukebox box = (BlockJukebox) b.getBlock();

				if (!b.getValue(BlockJukebox.HAS_RECORD).booleanValue())
				{
					if (event.getWorld().isRemote)
					{
						event.setUseItem(Result.ALLOW);
						event.setUseBlock(Result.DENY);
						return;
					}
					else
					{
						ItemStack it = event.getEntityPlayer().getHeldItem(event.getHand());
						((BlockJukebox) CCBlocks.cottonCandyJukebox).insertRecord(event.getWorld(), event.getPos(), b, it);
						// TODO sound events
					//	event.getWorld().playAuxSFXAtEntity((EntityPlayer) null, 1005, event.getPos(), Item.getIdFromItem(it.getItem()));
						it.shrink(1);;
						event.setUseItem(Result.ALLOW);
						event.setUseBlock(Result.DENY);
						return;
					}
				}
			}

			return;
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(LeftClickBlock event)
	{
		EntityPlayer p = event.getEntityPlayer();
		if (event.getEntity() != null && event.getEntity().world.provider.getDimension() == CandyCraft.getDungeonDimensionID() && (event.getEntity().world.getTileEntity(event.getPos()) == null || event.getEntity().world.getTileEntity(event.getPos()) instanceof TileEntityTeleporter))
		{
			// TODO reverse
			// event.setCanceled(true);
			return;
		}
	}

	@SubscribeEvent
	public void onDeath(LivingDeathEvent event)
	{
		if (event.getEntity() instanceof EntityCandyCreeper && event.getSource().getImmediateSource() != null)
		{
			if (event.getSource().getTrueSource() instanceof EntityPlayer)
			{
				// TODO advancements
			//	((EntityPlayer) event.getSource().getTrueSource()).addStat(CCAchievements.killCookieCreeper);
			}
			if (event.getSource().getTrueSource() instanceof EntityArrow)
			{
				if (((EntityArrow) event.getSource().getTrueSource()).shootingEntity != null && ((EntityArrow) event.getSource().getTrueSource()).shootingEntity instanceof EntityPlayer)
				{
					// TODO advancements
				//	((EntityPlayer) ((EntityArrow) event.getSource().getTrueSource()).shootingEntity).addStat(CCAchievements.killCookieCreeper);
				}
			}
		}
		if (event.getEntity() instanceof EntitySuguard && event.getSource().getImmediateSource() != null)
		{
			if (event.getSource().getTrueSource() instanceof EntityPlayer)
			{
				// TODO advancements
			//	((EntityPlayer) event.getSource().getTrueSource()).addStat(CCAchievements.killSuguard);
			}
			if (event.getSource().getTrueSource() instanceof EntityArrow)
			{
				if (((EntityArrow) event.getSource().getTrueSource()).shootingEntity != null && ((EntityArrow) event.getSource().getTrueSource()).shootingEntity instanceof EntityPlayer)
				{
					// TODO advancements
				//	((EntityPlayer) ((EntityArrow) event.getSource().getTrueSource()).shootingEntity).addStat(CCAchievements.killSuguard);
				}
			}
		}
		if (event.getEntity() instanceof EntityJellyQueen && event.getSource().getImmediateSource() != null)
		{
			if (event.getSource().getTrueSource() instanceof EntityPlayer)
			{
				// TODO advancements
			//	((EntityPlayer) event.getSource().getTrueSource()).addStat(CCAchievements.killQueenSlime);
			}
			if (event.getSource().getTrueSource() instanceof EntityArrow)
			{
				if (((EntityArrow) event.getSource().getTrueSource()).shootingEntity != null && ((EntityArrow) event.getSource().getTrueSource()).shootingEntity instanceof EntityPlayer)
				{
					// TODO advancements
				//	((EntityPlayer) ((EntityArrow) event.getSource().getTrueSource()).shootingEntity).addStat(CCAchievements.killQueenSlime);
				}
			}
		}
		if (event.getEntity() instanceof EntityBossSuguard && event.getSource().getImmediateSource() != null)
		{
			if (event.getSource().getTrueSource() instanceof EntityPlayer)
			{
				// TODO advancements
			//	((EntityPlayer) event.getSource().getTrueSource()).addStat(CCAchievements.killSuguardBoss);
			}
			if (event.getSource().getTrueSource() instanceof EntityArrow)
			{
				if (((EntityArrow) event.getSource().getTrueSource()).shootingEntity != null && ((EntityArrow) event.getSource().getTrueSource()).shootingEntity instanceof EntityPlayer)
				{
					// TODO advancements
				//	((EntityPlayer) ((EntityArrow) event.getSource().getTrueSource()).shootingEntity).addStat(CCAchievements.killSuguardBoss);
				}
			}
		}
	}

	@SubscribeEvent
	public void onPickup(EntityItemPickupEvent event)
	{
		// TODO advancements
	//	CCAchievements.onPickup(event.getItem(), event.getEntityPlayer());
	}

	@SubscribeEvent
	public void onEntityHurt(LivingHurtEvent event)
	{
		if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (event.getSource().damageType.equals(DamageSource.FALL.damageType))
			{
				if (event.getEntity().dimension == CandyCraft.getDungeonDimensionID() && event.getEntity().posZ <= 0)
				{
					event.setAmount(0);
					event.setResult(Result.DENY);
				}
				if (player.inventory.hasItemStack(new ItemStack(CCItems.jellyEmblem)))
				{
					event.setAmount(event.getAmount() * 0.7F);
				}
				if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == CCItems.jellyBoots)
				{
					event.setAmount(0);
					event.setResult(Result.DENY);
				}
			}
			if (event.getSource().getImmediateSource() instanceof EntityArrow)
			{
				if (player.inventory.hasItemStack(new ItemStack(CCItems.suguardEmblem)))
				{
					event.setAmount(event.getAmount() * 0.8F);
				}
			}
		}
	}
}
