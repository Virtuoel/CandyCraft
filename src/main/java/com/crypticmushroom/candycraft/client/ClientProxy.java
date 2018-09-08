package com.crypticmushroom.candycraft.client;

import org.lwjgl.input.Keyboard;

import com.crypticmushroom.candycraft.CommonProxy;
import com.crypticmushroom.candycraft.blocks.CCBlocks;
import com.crypticmushroom.candycraft.blocks.tileentity.TileEntityAlchemy;
import com.crypticmushroom.candycraft.blocks.tileentity.TileEntityCandyChest;
import com.crypticmushroom.candycraft.blocks.tileentity.TileEntityEgg;
import com.crypticmushroom.candycraft.blocks.tileentity.TileEntityTeleporter;
import com.crypticmushroom.candycraft.client.entity.ModelBee;
import com.crypticmushroom.candycraft.client.entity.ModelBeetle;
import com.crypticmushroom.candycraft.client.entity.ModelBunny;
import com.crypticmushroom.candycraft.client.entity.ModelCandyPig;
import com.crypticmushroom.candycraft.client.entity.ModelDragon;
import com.crypticmushroom.candycraft.client.entity.ModelFish;
import com.crypticmushroom.candycraft.client.entity.ModelPingouin;
import com.crypticmushroom.candycraft.client.entity.ModelWaffleSheep;
import com.crypticmushroom.candycraft.client.entity.ModelWaffleSheep2;
import com.crypticmushroom.candycraft.client.entity.RenderBee;
import com.crypticmushroom.candycraft.client.entity.RenderBeetle;
import com.crypticmushroom.candycraft.client.entity.RenderBossBeetle;
import com.crypticmushroom.candycraft.client.entity.RenderBunny;
import com.crypticmushroom.candycraft.client.entity.RenderCandyArrow;
import com.crypticmushroom.candycraft.client.entity.RenderCandyCreeper;
import com.crypticmushroom.candycraft.client.entity.RenderCandyPig;
import com.crypticmushroom.candycraft.client.entity.RenderCandyWolf;
import com.crypticmushroom.candycraft.client.entity.RenderCottonSpider;
import com.crypticmushroom.candycraft.client.entity.RenderDragon;
import com.crypticmushroom.candycraft.client.entity.RenderDynamite;
import com.crypticmushroom.candycraft.client.entity.RenderEntityFish;
import com.crypticmushroom.candycraft.client.entity.RenderGingerBreadMan;
import com.crypticmushroom.candycraft.client.entity.RenderGummyBall;
import com.crypticmushroom.candycraft.client.entity.RenderJellyQueen;
import com.crypticmushroom.candycraft.client.entity.RenderKamikazeJelly;
import com.crypticmushroom.candycraft.client.entity.RenderKingBeetle;
import com.crypticmushroom.candycraft.client.entity.RenderKingJelly;
import com.crypticmushroom.candycraft.client.entity.RenderMageSuguard;
import com.crypticmushroom.candycraft.client.entity.RenderMermaid;
import com.crypticmushroom.candycraft.client.entity.RenderNessie;
import com.crypticmushroom.candycraft.client.entity.RenderNougatGolem;
import com.crypticmushroom.candycraft.client.entity.RenderPEZJelly;
import com.crypticmushroom.candycraft.client.entity.RenderPingouin;
import com.crypticmushroom.candycraft.client.entity.RenderSprinter;
import com.crypticmushroom.candycraft.client.entity.RenderSuguard;
import com.crypticmushroom.candycraft.client.entity.RenderSuguardeBoss;
import com.crypticmushroom.candycraft.client.entity.RenderTornadoJelly;
import com.crypticmushroom.candycraft.client.entity.RenderWaffleSheep;
import com.crypticmushroom.candycraft.client.gui.GuiEmpty;
import com.crypticmushroom.candycraft.client.tileentity.RenderEgg;
import com.crypticmushroom.candycraft.client.tileentity.TileEntityAlchemyRenderer;
import com.crypticmushroom.candycraft.client.tileentity.TileEntityCandyChestRenderer;
import com.crypticmushroom.candycraft.client.tileentity.TileEntityRendererTeleporter;
import com.crypticmushroom.candycraft.entity.EntityBee;
import com.crypticmushroom.candycraft.entity.EntityBeetle;
import com.crypticmushroom.candycraft.entity.EntityBunny;
import com.crypticmushroom.candycraft.entity.EntityCandyArrow;
import com.crypticmushroom.candycraft.entity.EntityCandyCreeper;
import com.crypticmushroom.candycraft.entity.EntityCandyPig;
import com.crypticmushroom.candycraft.entity.EntityCandyWolf;
import com.crypticmushroom.candycraft.entity.EntityCottonCandySpider;
import com.crypticmushroom.candycraft.entity.EntityDragon;
import com.crypticmushroom.candycraft.entity.EntityDynamite;
import com.crypticmushroom.candycraft.entity.EntityFish;
import com.crypticmushroom.candycraft.entity.EntityGingerBreadMan;
import com.crypticmushroom.candycraft.entity.EntityGlueDynamite;
import com.crypticmushroom.candycraft.entity.EntityGummyBall;
import com.crypticmushroom.candycraft.entity.EntityKingBeetle;
import com.crypticmushroom.candycraft.entity.EntityMageSuguard;
import com.crypticmushroom.candycraft.entity.EntityMermaid;
import com.crypticmushroom.candycraft.entity.EntityNessie;
import com.crypticmushroom.candycraft.entity.EntityNougatGolem;
import com.crypticmushroom.candycraft.entity.EntityPingouin;
import com.crypticmushroom.candycraft.entity.EntityRedJelly;
import com.crypticmushroom.candycraft.entity.EntitySuguard;
import com.crypticmushroom.candycraft.entity.EntityTornadoJelly;
import com.crypticmushroom.candycraft.entity.EntityWaffleSheep;
import com.crypticmushroom.candycraft.entity.EntityYellowJelly;
import com.crypticmushroom.candycraft.entity.boss.EntityBossBeetle;
import com.crypticmushroom.candycraft.entity.boss.EntityBossSuguard;
import com.crypticmushroom.candycraft.entity.boss.EntityJellyQueen;
import com.crypticmushroom.candycraft.entity.boss.EntityKingSlime;
import com.crypticmushroom.candycraft.entity.boss.EntityPEZJelly;
import com.crypticmushroom.candycraft.items.CCItems;

import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	public static IRenderHandler weatherRenderer = new RenderWeather();

	public static GuiEmpty emptyGui = new GuiEmpty();
	public static ModelBiped crown = new ModelBiped(0.1F);
	public static KeyBinding unleashMountPower = new KeyBinding("key.mountPower", Keyboard.KEY_P, "CandyCraft");

	public static ModelResourceLocation bowAn1 = new ModelResourceLocation("candycraft:caramel_bow_1", "inventory");
	public static ModelResourceLocation bowAn2 = new ModelResourceLocation("candycraft:caramel_bow_2", "inventory");
	public static ModelResourceLocation bowAn3 = new ModelResourceLocation("candycraft:caramel_bow_3", "inventory");

	public static ModelResourceLocation dynAn1 = new ModelResourceLocation("candycraft:dynamite_1", "inventory");
	public static ModelResourceLocation dynAn1_1 = new ModelResourceLocation("candycraft:glue_dynamite_1", "inventory");
	public static ModelResourceLocation dynAn2 = new ModelResourceLocation("candycraft:dynamite_2", "inventory");

	public static ModelResourceLocation crossAn1 = new ModelResourceLocation("candycraft:caramel_crossbow_1", "inventory");
	public static ModelResourceLocation crossAn2 = new ModelResourceLocation("candycraft:caramel_crossbow_2", "inventory");
	public static ModelResourceLocation crossAn3 = new ModelResourceLocation("candycraft:caramel_crossbow_3", "inventory");

	@Override
	public void init()
	{
		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		RenderItem ri = Minecraft.getMinecraft().getRenderItem();

		rm.entityRenderMap.put(EntityCandyPig.class, new RenderCandyPig(rm, new ModelCandyPig(), 0.7F));
		rm.entityRenderMap.put(EntityCandyCreeper.class, new RenderCandyCreeper(rm));
		rm.entityRenderMap.put(EntitySuguard.class, new RenderSuguard(rm));
		rm.entityRenderMap.put(EntityMageSuguard.class, new RenderMageSuguard(rm));
		rm.entityRenderMap.put(EntityCandyWolf.class, new RenderCandyWolf(rm, new ModelWolf(), 0.5F));
		rm.entityRenderMap.put(EntityJellyQueen.class, new RenderJellyQueen(rm, new ModelSlime(16)));
		rm.entityRenderMap.put(EntityBunny.class, new RenderBunny(rm, new ModelBunny(), 0.5F));
		rm.entityRenderMap.put(EntityBee.class, new RenderBee(rm, new ModelBee(), 0.5F));
		rm.entityRenderMap.put(EntityGingerBreadMan.class, new RenderGingerBreadMan(rm, new ModelBiped(0.0F), 0.5F));
		rm.entityRenderMap.put(EntityCandyArrow.class, new RenderCandyArrow(rm));
		rm.entityRenderMap.put(EntityGummyBall.class, new RenderGummyBall(rm, CCItems.gummyBall, ri));
		rm.entityRenderMap.put(EntityBossSuguard.class, new RenderSuguardeBoss(rm));
		rm.entityRenderMap.put(EntityCottonCandySpider.class, new RenderCottonSpider(rm));
		rm.entityRenderMap.put(EntityFish.class, new RenderEntityFish(rm, new ModelFish(), 0.5F));
		rm.entityRenderMap.put(EntityNessie.class, new RenderNessie(rm));
		rm.entityRenderMap.put(EntityWaffleSheep.class, new RenderWaffleSheep(rm, new ModelWaffleSheep2(), new ModelWaffleSheep(), 0.7F));
		rm.entityRenderMap.put(EntityYellowJelly.class, new RenderSprinter(rm, new ModelSlime(16)));
		rm.entityRenderMap.put(EntityRedJelly.class, new RenderKamikazeJelly(rm, new ModelSlime(16)));
		rm.entityRenderMap.put(EntityTornadoJelly.class, new RenderTornadoJelly(rm, new ModelSlime(16)));
		rm.entityRenderMap.put(EntityPEZJelly.class, new RenderPEZJelly(rm, new ModelSlime(16)));
		rm.entityRenderMap.put(EntityKingSlime.class, new RenderKingJelly(rm, new ModelSlime(16)));
		rm.entityRenderMap.put(EntityDynamite.class, new RenderDynamite(rm, false, ri));
		rm.entityRenderMap.put(EntityGlueDynamite.class, new RenderDynamite(rm, true, ri));
		rm.entityRenderMap.put(EntityNougatGolem.class, new RenderNougatGolem(rm));
		rm.entityRenderMap.put(EntityBeetle.class, new RenderBeetle(rm, new ModelBeetle(), 0.5F));
		rm.entityRenderMap.put(EntityBossBeetle.class, new RenderBossBeetle(rm, new ModelBeetle(), 0.5F));
		rm.entityRenderMap.put(EntityPingouin.class, new RenderPingouin(rm, new ModelPingouin(), 0.5F));
		rm.entityRenderMap.put(EntityDragon.class, new RenderDragon(rm, new ModelDragon(), 0.5F));
		rm.entityRenderMap.put(EntityKingBeetle.class, new RenderKingBeetle(rm, new ModelBeetle(), 0.5F));
		rm.entityRenderMap.put(EntityMermaid.class, new RenderMermaid(rm));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandyChest.class, new TileEntityCandyChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemy.class, new TileEntityAlchemyRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleporter.class, new TileEntityRendererTeleporter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEgg.class, new RenderEgg());
		ClientRegistry.registerKeyBinding(ClientProxy.unleashMountPower);

		crown.bipedHead = new ModelRenderer(crown, 0, 0);
		crown.bipedHead.addBox(-4.0F, -9.5F, -4.0F, 8, 8, 8, 0.1F);
		crown.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);

		ri.getItemModelMesher().register(CCItems.caramelBow, 0, new ModelResourceLocation("candycraft:caramel_bow", "inventory"));
		ri.getItemModelMesher().register(CCItems.caramelBow, 1, new ModelResourceLocation("candycraft:caramel_bow_1", "inventory"));
		ri.getItemModelMesher().register(CCItems.caramelBow, 2, new ModelResourceLocation("candycraft:caramel_bow_2", "inventory"));
		ri.getItemModelMesher().register(CCItems.caramelBow, 3, new ModelResourceLocation("candycraft:caramel_bow_3", "inventory"));
		ModelBakery.registerItemVariants(CCItems.caramelBow, new ResourceLocation[] { new ResourceLocation("candycraft:caramel_bow"), new ResourceLocation("candycraft:caramel_bow_1"), new ResourceLocation("candycraft:caramel_bow_2"), new ResourceLocation("candycraft:caramel_bow_3") });

		ri.getItemModelMesher().register(CCItems.caramelCrossbow, 0, new ModelResourceLocation("candycraft:caramel_crossbow", "inventory"));
		ri.getItemModelMesher().register(CCItems.caramelCrossbow, 1, new ModelResourceLocation("candycraft:caramel_crossbow_1", "inventory"));
		ri.getItemModelMesher().register(CCItems.caramelCrossbow, 2, new ModelResourceLocation("candycraft:caramel_crossbow_2", "inventory"));
		ri.getItemModelMesher().register(CCItems.caramelCrossbow, 3, new ModelResourceLocation("candycraft:caramel_crossbow_3", "inventory"));
		ModelBakery.registerItemVariants(CCItems.caramelCrossbow, new ResourceLocation[] { new ResourceLocation("candycraft:caramel_crossbow"), new ResourceLocation("candycraft:caramel_crossbow_1"), new ResourceLocation("candycraft:caramel_crossbow_2"), new ResourceLocation("candycraft:caramel_crossbow_3") });

		ri.getItemModelMesher().register(CCItems.dynamite, 0, new ModelResourceLocation("candycraft:dynamite", "inventory"));
		ri.getItemModelMesher().register(CCItems.dynamite, 1, new ModelResourceLocation("candycraft:dynamite_1", "inventory"));
		ri.getItemModelMesher().register(CCItems.dynamite, 2, new ModelResourceLocation("candycraft:dynamite_2", "inventory"));
		ModelBakery.registerItemVariants(CCItems.dynamite, new ResourceLocation[] { new ResourceLocation("candycraft:dynamite"), new ResourceLocation("candycraft:dynamite_1"), new ResourceLocation("candycraft:dynamite_2") });

		ri.getItemModelMesher().register(CCItems.glueDynamite, 0, new ModelResourceLocation("candycraft:glue_dynamite", "inventory"));
		ri.getItemModelMesher().register(CCItems.glueDynamite, 1, new ModelResourceLocation("candycraft:glue_dynamite_1", "inventory"));
		ri.getItemModelMesher().register(CCItems.glueDynamite, 2, new ModelResourceLocation("candycraft:dynamite_2", "inventory"));
		ModelBakery.registerItemVariants(CCItems.glueDynamite, new ResourceLocation[] { new ResourceLocation("candycraft:glue_dynamite"), new ResourceLocation("candycraft:glue_dynamite_1"), new ResourceLocation("candycraft:dynamite_2") });

		ri.getItemModelMesher().register(CCItems.gummyBall, 0, new ModelResourceLocation("candycraft:gummy_ball", "inventory"));
		ri.getItemModelMesher().register(CCItems.gummyBall, 1, new ModelResourceLocation("candycraft:gummy_ball_1", "inventory"));
		ri.getItemModelMesher().register(CCItems.gummyBall, 2, new ModelResourceLocation("candycraft:gummy_ball_2", "inventory"));
		ModelBakery.registerItemVariants(CCItems.gummyBall, new ResourceLocation[] { new ResourceLocation("candycraft:gummy_ball"), new ResourceLocation("candycraft:gummy_ball_1"), new ResourceLocation("candycraft:gummy_ball_2") });

		ri.getItemModelMesher().register(Item.getItemFromBlock(CCBlocks.marshmallowChest), 0, new ModelResourceLocation("candycraft:marshmallow_chest", "inventory"));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemy.class, new TileEntityAlchemyRenderer());
		ri.getItemModelMesher().register(Item.getItemFromBlock(CCBlocks.alchemyTable), 0, new ModelResourceLocation("candycraft:alchemy_table", "inventory"));

		ri.getItemModelMesher().getModelManager().getBlockModelShapes().registerBlockWithStateMapper(CCBlocks.cottonCandyBedBlock, (new StateMap.Builder()).ignore(new IProperty[] { BlockBed.OCCUPIED }).build());
		ri.getItemModelMesher().getModelManager().getBlockModelShapes().registerBlockWithStateMapper(CCBlocks.grenadine, (new StateMap.Builder()).ignore(new IProperty[] { BlockFluidBase.LEVEL }).build());
		ri.getItemModelMesher().getModelManager().getBlockModelShapes().registerBlockWithStateMapper(CCBlocks.marshmallowDoor, (new StateMap.Builder()).ignore(new IProperty[] { BlockDoor.POWERED }).build());

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CCItems.candyPlacer, new ItemMeshDefinition()
		{
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack)
			{
				return new ModelResourceLocation("candycraft:" + CCItems.candyPlacer.getTranslationKey().substring(5), "inventory");
			}
		});

		ModelBakery.registerItemVariants(Item.getItemFromBlock(CCBlocks.grenadine));
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(CCBlocks.grenadine), new ItemMeshDefinition()
		{
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack)
			{
				return new ModelResourceLocation("candycraft:grenadine");
			}
		});

		ModelLoader.setCustomStateMapper(CCBlocks.grenadine, new StateMapperBase()
		{
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state)
			{
				return new ModelResourceLocation("candycraft:grenadine");
			}
		});

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(CCItems.sugarPill, new ItemMeshDefinition()
		{
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack)
			{
				return new ModelResourceLocation("candycraft:" + CCItems.sugarPill.getTranslationKey().substring(5), "inventory");
			}
		});
	}
}
