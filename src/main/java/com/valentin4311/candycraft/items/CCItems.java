package com.valentin4311.candycraft.items;

import com.valentin4311.candycraft.CandyCraft;
import com.valentin4311.candycraft.blocks.CCBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.GameData;

public class CCItems
{
	/**
	 * Materials
	 **/
	private static ToolMaterial licoriceMaterial = EnumHelper.addToolMaterial("Licorice", 1, 175, 4.0F, 1, 8);
	private static ArmorMaterial licoriceArmorMaterial = EnumHelper.addArmorMaterial("Licorice", "licorice", 18, new int[] { 1, 5, 4, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	private static ToolMaterial honeyMaterial = EnumHelper.addToolMaterial("Honey", 3, 400, 7.0F, 2.0F, 18);
	private static ArmorMaterial honeyArmorMaterial = EnumHelper.addArmorMaterial("Honey", "honey", 22, new int[] { 2, 7, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
	private static ToolMaterial PEZMaterial = EnumHelper.addToolMaterial("PEZ", 4, 1034, 7.6F, 3.4F, 3);
	private static ArmorMaterial PEZArmorMaterial = EnumHelper.addArmorMaterial("PEZ", "pez", 24, new int[] { 4, 9, 7, 4 }, 6, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

	private static ArmorMaterial jellyCrownMaterial = EnumHelper.addArmorMaterial("Jelly_Crown", "Jelly_Crown", 0, new int[] { 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	private static ArmorMaterial waterMaskMaterial = EnumHelper.addArmorMaterial("Water_Mask", "Armor_Mask", 0, new int[] { 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	private static ArmorMaterial jellyBootsMaterial = EnumHelper.addArmorMaterial("Jelly_Boots", "Armor_Boots", 0, new int[] { 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	/**
	 * Items
	 **/
	// /Materials
	// Marshmallow
	public static Item marshmallowStick;
	public static Item marshmallowSword;
	public static Item marshmallowShovel;
	public static Item marshmallowPickaxe;
	public static Item marshmallowAxe;
	public static Item marshmallowHoe;
	// Licorice
	public static Item licorice;
	public static Item licoriceSpear;
	public static Item licoriceSword;
	public static Item licoriceShovel;
	public static Item licoricePickAxe;
	public static Item licoriceAxe;
	public static Item licoriceHoe;
	public static Item licoriceHelmet;
	public static Item licoricePlate;
	public static Item licoriceLeggings;
	public static Item licoriceBoots;
	// HoneyComb
	public static Item honeyShard;
	public static Item honeycomb;
	public static Item honeyHelmet;
	public static Item honeyPlate;
	public static Item honeyLeggings;
	public static Item honeyBoots;
	public static Item honeySword;
	public static Item honeyShovel;
	public static Item honeyPickaxe;
	public static Item honeyAxe;
	public static Item honeyHoe;
	public static Item caramelBow;
	public static Item honeyArrow;
	public static Item caramelCrossbow;
	public static Item honeyBolt;
	// PEZ
	public static Item PEZ;
	public static Item PEZDust;
	public static Item PEZHelmet;
	public static Item PEZPlate;
	public static Item PEZLeggings;
	public static Item PEZBoots;
	public static Item PEZSword;
	public static Item PEZShovel;
	public static Item PEZPickaxe;
	public static Item PEZAxe;
	public static Item PEZHoe;
	// Gummy
	public static Item gummy;
	public static Item hotGummy;
	public static Item gummyBall;
	// Others
	public static Item candyCane;
	public static Item cottonCandy;
	public static Item cranberryScale;
	public static Item sugarCrystal;
	public static Item nougatPowder;
	// /Materials End

	// /StoryBoard
	// Dungeon Keys
	public static Item orangeKey;
	public static Item blueKey;
	public static Item whiteKey;
	public static Item purpleKey;
	// Boss keys
	public static Item jellySentryKey;
	public static Item jellyBossKey;
	public static Item suguardSentryKey;
	public static Item suguardBossKey;
	// Emblems
	public static Item honeyEmblem;
	public static Item jellyEmblem;
	public static Item suguardEmblem;
	public static Item cranberryEmblem;
	public static Item gingerbreadEmblem;
	public static Item waterEmblem;
	public static Item chewingGumEmblem;
	public static Item skyEmblem;
	// /Storyboard End

	// /Food Purpose
	public static Item cranberryFish;
	public static Item cranberryFishCooked;
	public static Item caramelBucket;
	public static Item waffleNugget;
	public static Item waffle;
	public static Item lollipop;
	public static Item dragibus;
	public static Item candiedCherry;
	public static Item sugarPill;
	// /Food Purpose End

	// /Misc
	// Record
	public static Item CD1;
	public static Item CD2;
	public static Item CD3;
	public static Item CD4;
	// Equipment & Tools
	public static Item fork;
	public static Item dragibusStick;
	public static Item jellyCrown;
	public static Item jellyWand;
	public static Item jumpWand;
	public static Item jellyBoots;
	public static Item waterMask;
	public static Item dynamite;
	public static Item glueDynamite;
	// Block Placing
	public static Item lollipopSeeds;
	public static Item marshmallowDoor;
	public static Item cottonCandyBed;
	// Others
	public static Item marshmallowFlower;
	public static Item chewingGum;
	public static Item chocolateCoin;
	public static Item wiki;
	public static Item candyPlacer;

	// Misc End

	private static Side currentSide = null;

	public static void loadItems()
	{
		licorice = new ItemFood(6, true).setTranslationKey("licorice").setCreativeTab(CandyCraft.getCandyTab());
		licoriceSpear = new ItemSword(licoriceMaterial).setTranslationKey("licorice_spear").setCreativeTab(CandyCraft.getCandyTab());
		licoriceSword = new ItemSword(licoriceMaterial).setTranslationKey("licorice_sword").setCreativeTab(CandyCraft.getCandyTab());
		licoriceShovel = new ItemSpade(licoriceMaterial).setTranslationKey("licorice_shovel").setCreativeTab(CandyCraft.getCandyTab());
		licoricePickAxe = new ItemCandyPickaxe(licoriceMaterial).setTranslationKey("licorice_pickaxe").setCreativeTab(CandyCraft.getCandyTab());
		licoriceAxe = new ItemCandyAxe(licoriceMaterial).setTranslationKey("licorice_axe").setCreativeTab(CandyCraft.getCandyTab());
		licoriceHoe = new ItemHoe(licoriceMaterial).setTranslationKey("licorice_hoe").setCreativeTab(CandyCraft.getCandyTab());
		licoriceHelmet = new ItemCandyArmor(licoriceArmorMaterial, EntityEquipmentSlot.HEAD).setTranslationKey("licorice_helmet").setCreativeTab(CandyCraft.getCandyTab());
		licoricePlate = new ItemCandyArmor(licoriceArmorMaterial, EntityEquipmentSlot.CHEST).setTranslationKey("licorice_plate").setCreativeTab(CandyCraft.getCandyTab());
		licoriceLeggings = new ItemCandyArmor(licoriceArmorMaterial, EntityEquipmentSlot.LEGS).setTranslationKey("licorice_leggings").setCreativeTab(CandyCraft.getCandyTab());
		licoriceBoots = new ItemCandyArmor(licoriceArmorMaterial, EntityEquipmentSlot.FEET).setTranslationKey("licorice_boots").setCreativeTab(CandyCraft.getCandyTab());
		candyCane = new ItemFood(4, true).setTranslationKey("candy_cane").setCreativeTab(CandyCraft.getCandyTab());
		caramelBucket = new ItemCaramelBucket().setTranslationKey("caramel_bucket").setCreativeTab(CandyCraft.getCandyTab()).setContainerItem(Items.BUCKET);
		lollipopSeeds = new ItemCandySeeds().setTranslationKey("lollipop_seeds").setCreativeTab(CandyCraft.getCandyTab());
		lollipop = new ItemLollipop().setTranslationKey("lollipop").setCreativeTab(CandyCraft.getCandyTab());
		fork = new ItemFork().setTranslationKey("fork").setCreativeTab(CandyCraft.getCandyTab());
		dragibus = (new ItemCandySeedFood(1, 0.3F, CCBlocks.dragibusCrops)).setTranslationKey("dragibus").setCreativeTab(CandyCraft.getCandyTab());
		dragibusStick = new ItemDragibusStick().setTranslationKey("dragibus_stick").setCreativeTab(CandyCraft.getCandyTab());
		marshmallowStick = new Item().setTranslationKey("marshmallow_stick").setCreativeTab(CandyCraft.getCandyTab());
		marshmallowDoor = (new ItemCandyDoor(CCBlocks.marshmallowDoor)).setCreativeTab(CandyCraft.getCandyTab()).setTranslationKey("marshmallow_door_item");
		honeyShard = new Item().setTranslationKey("honey_shard").setCreativeTab(CandyCraft.getCandyTab());
		chocolateCoin = new ItemFood(2, false).setTranslationKey("chocolate_coin").setCreativeTab(CandyCraft.getCandyTab());
		honeycomb = new Item().setTranslationKey("honeycomb").setCreativeTab(CandyCraft.getCandyTab());
		honeyHelmet = new ItemCandyArmor(honeyArmorMaterial, EntityEquipmentSlot.HEAD).setTranslationKey("honey_helmet").setCreativeTab(CandyCraft.getCandyTab());
		honeyPlate = new ItemCandyArmor(honeyArmorMaterial, EntityEquipmentSlot.CHEST).setTranslationKey("honey_plate").setCreativeTab(CandyCraft.getCandyTab());
		honeyLeggings = new ItemCandyArmor(honeyArmorMaterial, EntityEquipmentSlot.LEGS).setTranslationKey("honey_leggings").setCreativeTab(CandyCraft.getCandyTab());
		honeyBoots = new ItemCandyArmor(honeyArmorMaterial, EntityEquipmentSlot.FEET).setTranslationKey("honey_boots").setCreativeTab(CandyCraft.getCandyTab());
		honeySword = new ItemSword(honeyMaterial).setTranslationKey("honey_sword").setCreativeTab(CandyCraft.getCandyTab());
		honeyShovel = new ItemSpade(honeyMaterial).setTranslationKey("honey_shovel").setCreativeTab(CandyCraft.getCandyTab());
		honeyPickaxe = new ItemCandyPickaxe(honeyMaterial).setTranslationKey("honey_pickaxe").setCreativeTab(CandyCraft.getCandyTab());
		honeyAxe = new ItemCandyAxe(honeyMaterial).setTranslationKey("honey_axe").setCreativeTab(CandyCraft.getCandyTab());
		honeyHoe = new ItemHoe(honeyMaterial).setTranslationKey("honey_hoe").setCreativeTab(CandyCraft.getCandyTab());
		caramelBow = new ItemCandyBow().setTranslationKey("caramel_bow").setCreativeTab(CandyCraft.getCandyTab());
		honeyArrow = new ItemHoneyArrow(false).setTranslationKey("honey_arrow").setCreativeTab(CandyCraft.getCandyTab());
		gummy = new ItemFood(4, false).setPotionEffect(new PotionEffect(MobEffects.NAUSEA, 30, 0), 0.9F).setTranslationKey("gummy").setCreativeTab(CandyCraft.getCandyTab());
		hotGummy = new ItemFood(7, false).setPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 60, 1), 0.9F).setTranslationKey("hot_gummy").setCreativeTab(CandyCraft.getCandyTab());
		gummyBall = new ItemGummyBall().setTranslationKey("gummy_ball").setCreativeTab(CandyCraft.getCandyTab());
		PEZ = new ItemFood(10, false).setPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 60, 0), 0.9F).setAlwaysEdible().setTranslationKey("PEZ").setCreativeTab(CandyCraft.getCandyTab());
		PEZDust = new Item().setTranslationKey("PEZ_dust").setCreativeTab(CandyCraft.getCandyTab());
		PEZHelmet = new ItemCandyArmor(PEZArmorMaterial, EntityEquipmentSlot.HEAD).setTranslationKey("PEZ_helmet").setCreativeTab(CandyCraft.getCandyTab());
		PEZPlate = new ItemCandyArmor(PEZArmorMaterial, EntityEquipmentSlot.CHEST).setTranslationKey("PEZ_plate").setCreativeTab(CandyCraft.getCandyTab());
		PEZLeggings = new ItemCandyArmor(PEZArmorMaterial, EntityEquipmentSlot.LEGS).setTranslationKey("PEZ_leggings").setCreativeTab(CandyCraft.getCandyTab());
		PEZBoots = new ItemCandyArmor(PEZArmorMaterial, EntityEquipmentSlot.FEET).setTranslationKey("PEZ_boots").setCreativeTab(CandyCraft.getCandyTab());
		PEZSword = new ItemSword(PEZMaterial).setTranslationKey("PEZ_sword").setCreativeTab(CandyCraft.getCandyTab());
		PEZShovel = new ItemSpade(PEZMaterial).setTranslationKey("PEZ_shovel").setCreativeTab(CandyCraft.getCandyTab());
		PEZPickaxe = new ItemCandyPickaxe(PEZMaterial).setTranslationKey("PEZ_pickaxe").setCreativeTab(CandyCraft.getCandyTab());
		PEZAxe = new ItemCandyAxe(PEZMaterial).setTranslationKey("PEZ_axe").setCreativeTab(CandyCraft.getCandyTab());
		PEZHoe = new ItemHoe(PEZMaterial).setTranslationKey("PEZ_hoe").setCreativeTab(CandyCraft.getCandyTab());
		cottonCandy = new ItemFood(3, true).setPotionEffect(new PotionEffect(MobEffects.HASTE, 30, 0), 0.9F).setTranslationKey("cotton_candy").setCreativeTab(CandyCraft.getCandyTab());
		cranberryFish = new ItemFood(2, true).setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 30, 0), 0.9F).setTranslationKey("cranberry_fish").setCreativeTab(CandyCraft.getCandyTab());
		cranberryFishCooked = new ItemFood(6, true).setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 60, 0), 0.9F).setTranslationKey("cranberry_fish_cooked").setCreativeTab(CandyCraft.getCandyTab());
		cranberryScale = new Item().setTranslationKey("cranberry_scale").setCreativeTab(CandyCraft.getCandyTab());
		cottonCandyBed = (new ItemCandyBed()).setMaxStackSize(1).setTranslationKey("cotton_candy_bed").setCreativeTab(CandyCraft.getCandyTab());
		sugarCrystal = new Item().setTranslationKey("sugar_crystal").setCreativeTab(CandyCraft.getCandyTab());
		jellyCrown = new ItemCandyArmor(jellyCrownMaterial, EntityEquipmentSlot.HEAD).setTranslationKey("jelly_crown").setCreativeTab(CandyCraft.getCandyTab());
		jellyWand = new ItemJellyWand().setTranslationKey("jelly_wand").setCreativeTab(CandyCraft.getCandyTab());
		waterMask = new ItemCandyArmor(waterMaskMaterial, EntityEquipmentSlot.HEAD).setTranslationKey("water_mask").setCreativeTab(CandyCraft.getCandyTab());
		jumpWand = new ItemJumpWand().setTranslationKey("jump_wand").setCreativeTab(CandyCraft.getCandyTab());
		jellyBoots = new ItemCandyArmor(jellyBootsMaterial, EntityEquipmentSlot.FEET).setTranslationKey("jelly_boots").setCreativeTab(CandyCraft.getCandyTab());
		candiedCherry = new ItemFood(3, true).setTranslationKey("candied_cherry").setCreativeTab(CandyCraft.getCandyTab());
		waffleNugget = new ItemFood(1, true).setTranslationKey("waffle_nugget").setCreativeTab(CandyCraft.getCandyTab());
		waffle = new ItemFood(10, true).setTranslationKey("waffle").setCreativeTab(CandyCraft.getCandyTab());
		marshmallowSword = new ItemSword(ToolMaterial.WOOD).setTranslationKey("marshmallow_sword").setCreativeTab(CandyCraft.getCandyTab());
		marshmallowShovel = new ItemSpade(ToolMaterial.WOOD).setTranslationKey("marshmallow_shovel").setCreativeTab(CandyCraft.getCandyTab());
		marshmallowPickaxe = new ItemCandyPickaxe(ToolMaterial.WOOD).setTranslationKey("marshmallow_pickaxe").setCreativeTab(CandyCraft.getCandyTab());
		marshmallowAxe = new ItemCandyAxe(ToolMaterial.WOOD).setTranslationKey("marshmallow_axe").setCreativeTab(CandyCraft.getCandyTab());
		marshmallowHoe = new ItemHoe(ToolMaterial.WOOD).setTranslationKey("marshmallow_hoe").setCreativeTab(CandyCraft.getCandyTab());
		nougatPowder = new ItemNougatPowder(3, true).setTranslationKey("nougat_powder").setCreativeTab(CandyCraft.getCandyTab());
		dynamite = new ItemDynamite().setTranslationKey("dynamite").setCreativeTab(CandyCraft.getCandyTab());
		glueDynamite = new ItemDynamite().setTranslationKey("glue_dynamite").setCreativeTab(CandyCraft.getCandyTab());
		chewingGum = new Item().setTranslationKey("chewing_gum").setCreativeTab(CandyCraft.getCandyTab());
		sugarPill = ((ItemFood) new ItemGrenadineCandy().setTranslationKey("sugar_pill")).setAlwaysEdible().setCreativeTab(null);
		marshmallowFlower = new Item().setTranslationKey("marshmallow_flower").setCreativeTab(CandyCraft.getCandyTab());
		honeyBolt = new ItemHoneyArrow(true).setTranslationKey("honey_bolt").setCreativeTab(CandyCraft.getCandyTab());
		caramelCrossbow = new ItemCandyCrossbow().setTranslationKey("caramel_crossbow").setCreativeTab(CandyCraft.getCandyTab());

		CD1 = new ItemCandyRecord("CD-1", "C418 - Sweden - Remix Caution & Crisis", "Sweden Remix").setTranslationKey("record_1").setCreativeTab(CandyCraft.getCandyTab());
		CD2 = new ItemCandyRecord("CD-2", "Jakim - Every", "Every").setTranslationKey("record_2").setCreativeTab(CandyCraft.getCandyTab());
		CD3 = new ItemCandyRecord("CD-3", "Rainbow Bunchie", "Rainbow Bunchie").setTranslationKey("record_3").setCreativeTab(CandyCraft.getCandyTab());
		CD4 = new ItemCandyRecord("CD-4", "C418 - Einfallslos", "Einfallslos").setTranslationKey("record_4").setCreativeTab(CandyCraft.getCandyTab());

		candyPlacer = new ItemCandyMonsterPlacer().setTranslationKey("candy_spawn_egg").setCreativeTab(CandyCraft.getCandyTab());
		wiki = new ItemWiki().setTranslationKey("wiki").setCreativeTab(CandyCraft.getCandyTab());
		orangeKey = new ItemDungeonKey(0).setTranslationKey("jelly_key").setCreativeTab(CandyCraft.getCandyTab());
		blueKey = new ItemDungeonKey(1).setTranslationKey("suguard_key").setCreativeTab(CandyCraft.getCandyTab());
		whiteKey = new ItemDungeonKey(2).setTranslationKey("sky_key").setCreativeTab(CandyCraft.getCandyTab());
		purpleKey = new ItemDungeonKey(3).setTranslationKey("beetle_key").setCreativeTab(CandyCraft.getCandyTab());

		honeyEmblem = new ItemEmblem("HoneyEmblem").setTranslationKey("honey_emblem").setCreativeTab(CandyCraft.getCandyTab());
		jellyEmblem = new ItemEmblem("JellyEmblem").setTranslationKey("jelly_emblem").setCreativeTab(CandyCraft.getCandyTab());
		suguardEmblem = new ItemEmblem("SuguardEmblem").setTranslationKey("suguard_emblem").setCreativeTab(CandyCraft.getCandyTab());
		cranberryEmblem = new ItemEmblem("CranberryEmblem").setTranslationKey("cranberry_emblem").setCreativeTab(CandyCraft.getCandyTab());
		gingerbreadEmblem = new ItemEmblem("GingerbreadEmblem").setTranslationKey("gingerbread_emblem").setCreativeTab(CandyCraft.getCandyTab());
		waterEmblem = new ItemEmblem("WaterEmblem").setTranslationKey("water_emblem").setCreativeTab(CandyCraft.getCandyTab());
		chewingGumEmblem = new ItemEmblem("ChewingGumEmblem").setTranslationKey("chewing_gum_emblem").setCreativeTab(CandyCraft.getCandyTab());
		skyEmblem = new ItemEmblem("SkyEmblem").setTranslationKey("sky_emblem").setCreativeTab(CandyCraft.getCandyTab());

		jellySentryKey = new ItemBossKey(0).setTranslationKey("jelly_sentry_key").setCreativeTab(CandyCraft.getCandyTab());
		jellyBossKey = new ItemBossKey(1).setTranslationKey("jelly_boss_key").setCreativeTab(CandyCraft.getCandyTab());
		suguardSentryKey = new ItemBossKey(2).setTranslationKey("suguard_sentry_key").setCreativeTab(CandyCraft.getCandyTab());
		suguardBossKey = new ItemBossKey(3).setTranslationKey("suguard_boss_key").setCreativeTab(CandyCraft.getCandyTab());

		licoriceMaterial.setRepairItem(new ItemStack(licorice));
		honeyMaterial.setRepairItem(new ItemStack(honeycomb));
		PEZMaterial.setRepairItem(new ItemStack(PEZ));
	}

	public static void registerItems(Side side)
	{
		currentSide = side;
		registerItem(marshmallowStick);
		registerItem(marshmallowDoor);
		registerItem(cottonCandyBed);
		registerItem(fork);
		registerItem(dragibus);
		registerItem(dragibusStick);
		registerItem(lollipopSeeds);
		registerItem(lollipop);
		registerItem(candyCane);
		registerItem(marshmallowSword);
		registerItem(marshmallowShovel);
		registerItem(marshmallowPickaxe);
		registerItem(marshmallowAxe);
		registerItem(marshmallowHoe);
		registerItem(gummy);
		registerItem(hotGummy);
		registerItem(cottonCandy);
		registerItem(cranberryFish);
		registerItem(cranberryFishCooked);
		registerItem(gummyBall);
		registerItem(chocolateCoin);
		registerItem(caramelBucket);
		registerItem(licorice);
		registerItem(licoriceSpear);
		registerItem(licoriceSword);
		registerItem(licoriceShovel);
		registerItem(licoricePickAxe);
		registerItem(licoriceAxe);
		registerItem(licoriceHoe);
		registerItem(licoriceHelmet);
		registerItem(licoricePlate);
		registerItem(licoriceLeggings);
		registerItem(licoriceBoots);
		registerItem(honeyShard);
		registerItem(honeycomb);
		registerItem(honeySword);
		registerItem(honeyShovel);
		registerItem(honeyPickaxe);
		registerItem(honeyAxe);
		registerItem(honeyHoe);
		registerItem(honeyHelmet);
		registerItem(honeyPlate);
		registerItem(honeyLeggings);
		registerItem(honeyBoots);
		registerItem(PEZ);
		registerItem(PEZDust);
		registerItem(PEZSword);
		registerItem(PEZShovel);
		registerItem(PEZPickaxe);
		registerItem(PEZAxe);
		registerItem(PEZHoe);
		registerItem(PEZHelmet);
		registerItem(PEZPlate);
		registerItem(PEZLeggings);
		registerItem(PEZBoots);
		registerItem(caramelBow);
		registerItem(honeyArrow);
		registerItem(caramelCrossbow);
		registerItem(honeyBolt);
		registerItem(cranberryScale);
		registerItem(sugarCrystal);
		registerItem(jellyWand);
		registerItem(jumpWand);
		registerItem(waterMask);
		registerItem(jellyCrown);
		registerItem(jellyBoots);
		registerItem(candiedCherry);
		registerItem(waffleNugget);
		registerItem(waffle);
		registerItem(nougatPowder);
		registerItem(dynamite);
		registerItem(glueDynamite);
		registerItem(chewingGum);
		registerItem(marshmallowFlower);
		registerItem(sugarPill);
		registerItem(honeyEmblem);
		registerItem(jellyEmblem);
		registerItem(suguardEmblem);
		registerItem(cranberryEmblem);
		registerItem(gingerbreadEmblem);
		registerItem(waterEmblem);
		registerItem(chewingGumEmblem);
		registerItem(skyEmblem);
		registerItem(CD1);
		registerItem(CD2);
		registerItem(CD3);
		registerItem(CD4);
		registerItem(orangeKey);
		registerItem(blueKey);
		registerItem(whiteKey);
		registerItem(purpleKey);
		registerItem(jellySentryKey);
		registerItem(jellyBossKey);
		registerItem(suguardSentryKey);
		registerItem(suguardBossKey);
		registerItem(candyPlacer);
		registerItem(wiki);
	}

	public static void registerItem(final Item item)
	{
		ForgeRegistries.ITEMS.register(item.setRegistryName(item.getTranslationKey().substring(5)));
		CandyCraft.getItemList().add(item);
		if (currentSide == Side.CLIENT)
		{
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("candycraft:" + item.getTranslationKey().substring(5), "inventory"));
		}
	}
}
