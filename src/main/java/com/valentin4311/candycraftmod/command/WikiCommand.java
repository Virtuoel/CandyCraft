package com.valentin4311.candycraftmod.command;

import java.util.ArrayList;
import java.util.List;

import com.valentin4311.candycraftmod.items.CCItems;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class WikiCommand extends CommandBase
{
	private List<String> aliases = new ArrayList<String>();

	public WikiCommand()
	{
		aliases.add("candywiki");
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 0;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args)
	{
		if (sender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) sender;

			if (!player.inventory.hasItemStack(new ItemStack(CCItems.wiki)))
			{
				if (player.inventory.addItemStackToInventory(new ItemStack(CCItems.wiki)))
				{
					player.sendMessage(new TextComponentString("\247a" + new TextComponentTranslation("chat.wikiOk").getUnformattedText()));
					// TODO advancements
				//	player.addStat(CCAchievements.openWiki);
				}
				else
				{
					player.sendMessage(new TextComponentString("\247c" + new TextComponentTranslation("chat.wikiRoom").getUnformattedText()));
				}
			}
			else
			{
				player.sendMessage(new TextComponentString("\247c" + new TextComponentTranslation("chat.wikiFail").getUnformattedText()));
			}
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
	{
		return sender instanceof EntityPlayer;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_)
	{
		return false;
	}

	@Override
	public String getName()
	{
		return "candywiki";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "/candywiki";
	}

	@Override
	public List<String> getAliases()
	{
		return aliases;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
	{
		return null;
	}
}
