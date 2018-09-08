package com.valentin4311.candycraftmod.event;

import com.valentin4311.candycraftmod.CandyCraft;
import com.valentin4311.candycraftmod.CandyCraftPreferences;
import com.valentin4311.candycraftmod.client.gui.GuiBoss;
import com.valentin4311.candycraftmod.misc.ThreadCheckUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientTick
{
	private boolean isSay = false;
	@SideOnly(Side.CLIENT)
	public Object bossHealth;
	boolean isDeclared = false;
	public static boolean threadFinished = false;
	public static String version = "";
	public static String mcVersion = "";
	public static String words = "";

	public void onPlayerTick(EntityPlayer player)
	{
		if (!isSay)
		{
			// player.addChatMessage(new TextComponentTranslation("\247e" +
			// I18n.format("chat.checkingUpdate")));
			ThreadCheckUpdate maj = new ThreadCheckUpdate();
			maj.start();
			isSay = true;
		}
		if (ClientTick.threadFinished && CandyCraftPreferences.checkForUpdates)
		{
			ClientTick.threadFinished = false;
			if (CandyCraft.isShouldUpdate())
			{
				String m1 = I18n.format("chat.UpdateFound").replace("*version*", ClientTick.version);
				String m2 = m1.replace("*mcVersion*", ClientTick.mcVersion);
				String m3 = I18n.format("chat.UpdateFound2").replace("*features*", ClientTick.words);
				String m4 = I18n.format("chat.UpdateFound3").replace("*link*", "http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/1292999");
				player.sendMessage(new TextComponentTranslation("\247a" + m2));
				player.sendMessage(new TextComponentTranslation(""));
				player.sendMessage(new TextComponentTranslation("\247a" + m3));
				player.sendMessage(new TextComponentTranslation(""));
				player.sendMessage(new TextComponentTranslation("\247a" + m4));
			}
			else
			{
				// player.addChatMessage(new TextComponentTranslation("\2476" +
				// I18n.format("chat.NoUpdate")));
			}
			player.sendMessage(new TextComponentTranslation("This is a test version, bugs, glitch, crash may occurs !"));
		}
	}

	public void onRenderTick(float tick)
	{
		if (!isDeclared)
		{
			bossHealth = new GuiBoss();
			isDeclared = true;
		}
		if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().currentScreen == null)
		{
			((GuiBoss) bossHealth).drawScreen(tick);
		}
	}
}
