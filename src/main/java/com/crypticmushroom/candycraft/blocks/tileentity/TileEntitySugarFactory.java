package com.crypticmushroom.candycraft.blocks.tileentity;

import java.util.HashMap;
import java.util.Map;

import com.crypticmushroom.candycraft.CandyCraft;
import com.crypticmushroom.candycraft.blocks.CCBlocks;
import com.crypticmushroom.candycraft.items.CCItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntitySugarFactory extends TileEntity implements ISidedInventory, ITickable
{
	public boolean advancedMode = false;
	public boolean checked = false;
	private ItemStack[] FactoryItemStacks = new ItemStack[] {ItemStack.EMPTY, ItemStack.EMPTY};
	public int currentTime = 0;
	private String invName;

	public static Map<ItemStack, ItemStack> recipeList = new HashMap<ItemStack, ItemStack>();
	public static Map<ItemStack, ItemStack> advancedRecipeList = new HashMap<ItemStack, ItemStack>();

	public static Map recipes = new HashMap();

	static
	{
		recipeList.put(new ItemStack(Items.STICK), new ItemStack(CCItems.marshmallowStick));
		recipeList.put(new ItemStack(CCBlocks.fraiseTagadaFlower), new ItemStack(CCItems.honeyShard));
		recipeList.put(new ItemStack(CCBlocks.chocolateStone), new ItemStack(CCItems.chocolateCoin));
		recipeList.put(new ItemStack(CCBlocks.honeyBlock), new ItemStack(CCItems.honeycomb));
		advancedRecipeList.put(new ItemStack(CCBlocks.nougatBlock), new ItemStack(CCBlocks.nougatHead, 1, 1));
		advancedRecipeList.put(new ItemStack(CCBlocks.sugarEssenceFlower), new ItemStack(Items.GOLD_NUGGET));
	}

	public static boolean isItemValid(ItemStack i)
	{
		if (i != null && i.getItem() instanceof ItemBlock && CandyCraft.getItemList().contains(i.getItem()))
		{
			return true;
		}
		return i != null && (CandyCraft.getItemList().contains(i.getItem()));
	}

	@Override
	public int getSizeInventory()
	{
		return FactoryItemStacks.length;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
		FactoryItemStacks = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < FactoryItemStacks.length)
			{
				FactoryItemStacks[b0] = new ItemStack(nbttagcompound1);
			}
		}

		currentTime = par1NBTTagCompound.getShort("BurnTime");

		if (par1NBTTagCompound.hasKey("CustomName"))
		{
			invName = par1NBTTagCompound.getString("CustomName");
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("BurnTime", (short) currentTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < FactoryItemStacks.length; ++i)
		{
			if (FactoryItemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				FactoryItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1NBTTagCompound.setTag("Items", nbttaglist);

		if (hasCustomName())
		{
			par1NBTTagCompound.setString("CustomName", invName);
		}

		return par1NBTTagCompound;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return FactoryItemStacks[i];
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public ItemStack decrStackSize(int i, int j)
	{
		if (FactoryItemStacks[i] != null)
		{
			ItemStack itemstack;

			if (FactoryItemStacks[i].getCount() <= j)
			{
				itemstack = FactoryItemStacks[i];
				FactoryItemStacks[i] = ItemStack.EMPTY;
				return itemstack;
			}
			else
			{
				itemstack = FactoryItemStacks[i].splitStack(j);

				if (FactoryItemStacks[i].getCount() == 0)
				{
					FactoryItemStacks[i] = ItemStack.EMPTY;
				}

				return itemstack;
			}
		}
		else
		{
			return ItemStack.EMPTY;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int i)
	{
		if (FactoryItemStacks[i] != null)
		{
			ItemStack itemstack = FactoryItemStacks[i];
			FactoryItemStacks[i] = ItemStack.EMPTY;
			return itemstack;
		}
		else
		{
			return ItemStack.EMPTY;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack)
	{
		FactoryItemStacks[i] = itemstack;

		if (itemstack != null && itemstack.getCount() > getInventoryStackLimit())
		{
			itemstack.setCount(getInventoryStackLimit());
		}
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer par1EntityPlayer)
	{/*// TODO advancements
		if (par1EntityPlayer != null && FactoryItemStacks[1] != null && FactoryItemStacks[1].getItem() == CCItems.honeycomb)
		{
			par1EntityPlayer.addStat(CCAchievements.craftHoneyComb);
		}
		if (par1EntityPlayer != null && FactoryItemStacks[1] != null && FactoryItemStacks[1].getItem() == CCItems.chocolateCoin)
		{
			par1EntityPlayer.addStat(CCAchievements.craftCoins);
		}*/
		return world.getTileEntity(pos) != this ? false : par1EntityPlayer.getDistanceSq(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void update()
	{
		if (!checked)
		{
			advancedMode = world.getBlockState(pos).getBlock() == CCBlocks.advancedSugarFactory;
			checked = true;
		}
		if (FactoryItemStacks[0] != null && FactoryItemStacks[0].getItem() != Items.SUGAR)
		{
			ItemStack result = new ItemStack(Items.SUGAR, 1);
			ItemStack base = ItemStack.EMPTY;

			if (FactoryItemStacks[0].getItem() == Items.STICK)
			{
				result = new ItemStack(CCItems.marshmallowStick);
			}
			if (FactoryItemStacks[0].getItem() == Item.getItemFromBlock(CCBlocks.fraiseTagadaFlower))
			{
				result = new ItemStack(CCItems.honeyShard);
			}
			if (FactoryItemStacks[0].getItem() == Item.getItemFromBlock(CCBlocks.chocolateStone))
			{
				result = new ItemStack(CCItems.chocolateCoin);
			}
			if (FactoryItemStacks[0].getItem() == Item.getItemFromBlock(CCBlocks.honeyBlock))
			{
				result = new ItemStack(CCItems.honeycomb);
			}

			if (FactoryItemStacks[0].getItem() == Item.getItemFromBlock(CCBlocks.nougatBlock) && advancedMode)
			{
				result = new ItemStack(CCBlocks.nougatHead, 1, 1);
			}
			if (FactoryItemStacks[0].getItem() == Item.getItemFromBlock(CCBlocks.sugarEssenceFlower) && advancedMode)
			{
				result = new ItemStack(Items.GOLD_NUGGET);
			}
			
			// TODO FIXME Grenadine Bucket
		/*	if (FactoryItemStacks[0].getItem() == CCItems.grenadineBucket)
			{
				base = new ItemStack(Items.BUCKET, 1);
			}*/
			if (FactoryItemStacks[0].getItem() == CCItems.caramelBucket)
			{
				base = new ItemStack(Items.BUCKET, 1);
			}

			if (FactoryItemStacks[0] != null && TileEntitySugarFactory.isItemValid(FactoryItemStacks[0]) && (FactoryItemStacks[1] == null || (FactoryItemStacks[1] != null && FactoryItemStacks[1].getCount() < 64 && FactoryItemStacks[1].getItem() == result.getItem())))
			{
				currentTime += advancedMode ? 2 : 1;
			}
			else
			{
				currentTime = 0;
			}
			if (currentTime >= 240 && !world.isRemote)
			{

				if (FactoryItemStacks[1] == ItemStack.EMPTY)
				{
					FactoryItemStacks[1] = result;
					currentTime = 0;
				}
				else if (FactoryItemStacks[1].getCount() < 64 && result.getItem() == FactoryItemStacks[1].getItem())
				{
					FactoryItemStacks[1].grow(1);
					currentTime = 0;
				}

				if (base == ItemStack.EMPTY)
				{
					if (FactoryItemStacks[0].getCount() == 1)
					{
						FactoryItemStacks[0] = ItemStack.EMPTY;
					}
					if (FactoryItemStacks[0] != null)
					{
						FactoryItemStacks[0].shrink(1);
					}
				}
				else
				{
					FactoryItemStacks[0] = base;
				}

			}
		}
		else
		{
			currentTime = 0;
		}
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return i == 1 ? false : true;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		return new int[] { 0, 1 };
	}

	@Override
	public boolean canInsertItem(int slotId, ItemStack itemStackIn, EnumFacing direction)
	{
		return slotId != 1;
	}

	@Override
	public boolean canExtractItem(int slotId, ItemStack stack, EnumFacing direction)
	{
		return slotId != 0;
	}

	@Override
	public String getName()
	{
		return hasCustomName() ? invName : "container.SugarFactory";
	}

	@Override
	public boolean hasCustomName()
	{
		return invName != null && invName.length() > 0;
	}

	@Override
	public void openInventory(EntityPlayer playerIn)
	{}

	@Override
	public void closeInventory(EntityPlayer playerIn)
	{}

	@Override
	public int getField(int id)
	{
		return currentTime;
	}

	@Override
	public void setField(int id, int value)
	{
		currentTime = id;
	}

	@Override
	public int getFieldCount()
	{
		return 1;
	}

	@Override
	public void clear()
	{
		FactoryItemStacks = new ItemStack[2];
	}

	@Override
	public ITextComponent getDisplayName()
	{
		return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName(), new Object[0]);
	}

	@Override
	public boolean isEmpty()
	{
		for(ItemStack itemstack : this.FactoryItemStacks)
		{
			if(itemstack != null && !itemstack.isEmpty())
			{
				return false;
			}
		}
		
		return true;
	}
}
