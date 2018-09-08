package valentin4311.candycraft;

import java.io.File;
import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
import valentin4311.candycraft.blocks.CCBlocks;
import valentin4311.candycraft.blocks.fluid.CCFluids;
import valentin4311.candycraft.client.gui.GuiHandlerCandyCraft;
import valentin4311.candycraft.command.WikiCommand;
import valentin4311.candycraft.entity.CCEntities;
import valentin4311.candycraft.event.ClientEventCatcher;
import valentin4311.candycraft.event.ClientTick;
import valentin4311.candycraft.event.ServerEventCatcher;
import valentin4311.candycraft.event.ServerTick;
import valentin4311.candycraft.items.CCItems;
import valentin4311.candycraft.misc.CCAchievements;
import valentin4311.candycraft.misc.CCCreativeTabs;
import valentin4311.candycraft.misc.CCEnchantments;
import valentin4311.candycraft.misc.CCRecipes;
import valentin4311.candycraft.world.TerrainCatcher;
import valentin4311.candycraft.world.WorldProviderCandy;
import valentin4311.candycraft.world.WorldProviderVoid;
import valentin4311.candycraft.world.WorldTypeCandy;
import valentin4311.candycraft.world.biomes.CCBiomes;

@Mod(modid = "candycraftmod", name = "candycraftmod", version = CandyCraft.VERSION)
public class CandyCraft
{
	@Instance("candycraftmod")
	private static CandyCraft modInstance;
	public static final String VERSION = "Beta 1.3.1";

	@SidedProxy(clientSide = "com.valentin4311.candycraftmod.client.ClientProxy", serverSide = "com.valentin4311.candycraftmod.CommonProxy")
	private static CommonProxy proxy;
	private static ClientTick clientTicker;
	private static ServerTick serverTicker;

	private static CreativeTabs creativeTab = new CCCreativeTabs("CandyCraft");
	private static GuiHandlerCandyCraft guiHandler = new GuiHandlerCandyCraft();
	private static ArrayList<Item> itemList = new ArrayList();
	// Dimension
	private static WorldTypeCandy candyWorldType = new WorldTypeCandy();
	private static int candyDimensionID;
	private static int dungeonDimensionID;

	// Misc
	private static boolean shouldUpdate = false;

	@EventHandler
	public void preInitMod(FMLPreInitializationEvent event)
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
	}

	@EventHandler
	public void initMod(FMLInitializationEvent event)
	{

		proxy.init();

		CCRecipes.init();
	//	CCAchievements.init(); // TODO Advancements
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
		CCEnchantments.init(config);
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
		return modInstance;
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
