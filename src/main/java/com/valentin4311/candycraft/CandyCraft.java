package com.valentin4311.candycraft;

import java.io.File;
import java.util.ArrayList;

import com.valentin4311.candycraft.blocks.CCBlocks;
import com.valentin4311.candycraft.blocks.fluid.CCFluids;
import com.valentin4311.candycraft.client.gui.GuiHandlerCandyCraft;
import com.valentin4311.candycraft.command.WikiCommand;
import com.valentin4311.candycraft.entity.CCEntities;
import com.valentin4311.candycraft.event.ClientEventCatcher;
import com.valentin4311.candycraft.event.ClientTick;
import com.valentin4311.candycraft.event.ServerEventCatcher;
import com.valentin4311.candycraft.event.ServerTick;
import com.valentin4311.candycraft.items.CCItems;
import com.valentin4311.candycraft.misc.CCRecipes;
import com.valentin4311.candycraft.world.TerrainCatcher;
import com.valentin4311.candycraft.world.WorldProviderCandy;
import com.valentin4311.candycraft.world.WorldProviderVoid;
import com.valentin4311.candycraft.world.WorldTypeCandy;
import com.valentin4311.candycraft.world.biomes.CCBiomes;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = CandyCraft.MODID, name = CandyCraft.NAME, version = CandyCraft.VERSION)
public class CandyCraft
{
	
	public static final String MODID = "candycraft";
    public static final String NAME = "CandyCraft";
    public static final String VERSION = "1.0";
    
    @Instance
	public static CandyCraft instance;

	@SidedProxy(clientSide = "com.valentin4311.candycraft.client.ClientProxy", serverSide = "com.valentin4311.candycraft.CommonProxy")
	private static CommonProxy proxy;
	private static ClientTick clientTicker;
	private static ServerTick serverTicker;

	private static CreativeTabs creativeTab = new CreativeTabs(MODID)
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(CCBlocks.marshmallowWorkbench);
		}
	};
	private static GuiHandlerCandyCraft guiHandler = new GuiHandlerCandyCraft();
	private static ArrayList<Item> itemList = new ArrayList<Item>();
	// Dimension
	private static WorldTypeCandy candyWorldType = new WorldTypeCandy();
	private static int candyDimensionID;
	private static int dungeonDimensionID;

	// Misc
	private static boolean shouldUpdate = false;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		boolean isClient = event.getSide() == Side.CLIENT;

		if (isClient)
		{
			clientTicker = new ClientTick();
			MinecraftForge.EVENT_BUS.register(new ClientEventCatcher());
		}
		serverTicker = new ServerTick();

		MinecraftForge.EVENT_BUS.register(new ServerEventCatcher());
		MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainCatcher());

		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);

		CCFluids.init();
		CCBlocks.loadBlocks();
		CCItems.loadItems();
		CCFluids.postInit();

		addContentFromConfig(isClient, event.getModConfigurationDirectory());
		
		CCBlocks.registerBlocks(event.getSide());
		CCBlocks.doMiningLevel();

		CCItems.registerItems(event.getSide());

		//FlashFyre
		CCBiomes.registerBiomes();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		CCRecipes.init();
		
	//	CCAchievements.init(); // TODO Advancements
		
		//FlashFyre
		proxy.attachRenderLayers();
	}

	public void addContentFromConfig(boolean client, File configDirectory)
	{
		CandyCraftPreferences.init(configDirectory);

		Configuration config = new Configuration(new File(configDirectory, "/CandyCraft/CandyCraft-CFG.cfg"));
		config.load();

		// Dimension
		candyDimensionID = config.get("Dimension", "Id", 23).getInt();
		dungeonDimensionID = config.get("Dimension", "Dungeon", 24).getInt();

		DimensionManager.registerDimension(getCandyDimensionID(), WorldProviderCandy.CANDY_WORLD);
		DimensionManager.registerDimension(getDungeonDimensionID(), WorldProviderVoid.DUNGEON_WORLD);

		// Entities
		CCEntities.init();
		
		CCBiomes.init();

		config.save();
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new WikiCommand());
	}

	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event)
	{
		if (Loader.isModLoaded("NotEnoughItems") && event.getSide() == Side.CLIENT)
		{
			// NEIModule.loadNEI();
		}
	}

	public static int getCandyDimensionID()
	{
		return candyDimensionID;
	}

	public static CreativeTabs getCandyTab()
	{
		return creativeTab;
	}

	public static CandyCraft getInstance()
	{
		return instance;
	}

	public static boolean isShouldUpdate()
	{
		return shouldUpdate;
	}

	public static void setShouldUpdate(boolean shouldUpdate)
	{
		CandyCraft.shouldUpdate = shouldUpdate;
	}

	public static int getDungeonDimensionID()
	{
		return dungeonDimensionID;
	}

	public static ServerTick getServerTicker()
	{
		return serverTicker;
	}

	public static ClientTick getClientTicker()
	{
		return clientTicker;
	}

	public static ArrayList<Item> getItemList()
	{
		return itemList;
	}

	public static WorldTypeCandy getCandyWorldType()
	{
		return candyWorldType;
	}

	public static void setCandyWorldType(WorldTypeCandy candyWorldType)
	{
		CandyCraft.candyWorldType = candyWorldType;
	}
}
