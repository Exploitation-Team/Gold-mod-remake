package gold.content;

import arc.graphics.g2d.*;
import arc.math.geom.*;
import gold.graphics.*;
import mindustry.entities.Effect;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static mindustry.type.ItemStack.*;

public class GMRBlocks {
    public static Block

    //environment
    goldOre, darksandTarred, sandTarred, oilWall, goldBridge,
    //defence

    //production
    goldDrillStation,
    //storage
    coreShiny,
    //crafting
    goldFurnance, goldPressurer,
    //power
    oilGenerator,
    //turrets
    prelver;
    public static void load(){
        Blocks.grass.attributes.set(GMRAttributes.golden, 1f);
        Blocks.darksandWater.attributes.set(GMRAttributes.golden, 1.6f);
        Blocks.sandWater.attributes.set(GMRAttributes.golden, 1.6f);
        //environment
        goldOre = new OreBlock(GMRItems.rawgold){{
            oreDefault = true;
        }};
        darksandTarred = new ShallowLiquid("darksand-tarred"){{
            liquidDrop = Liquids.oil;
            cacheLayer = CacheLayer.tar;
            speedMultiplier = 0.8f;
            liquidMultiplier = 0.6f;
            statusDuration = 60f;
            albedo = 0.9f;
            attributes.set(GMRAttributes.golden, 0.4f);
            supportsOverlay = true;

        }};
        sandTarred = new ShallowLiquid("sand-tarred"){{
            liquidDrop = Liquids.oil;
            cacheLayer = CacheLayer.tar;
            speedMultiplier = 0.8f;
            liquidMultiplier = 0.6f;
            statusDuration = 60f;
            albedo = 0.9f;
            attributes.set(GMRAttributes.golden, 0.4f);
            supportsOverlay = true;

        }};
        goldBridge = new Floor("gold-bridge"){{
            requirements(Category.effect, with(GMRItems.gold, 4));
            variants = 0;
            health = 130;
            targetable = true;
            breakable = true;
            destructible = true;
            placeableLiquid = true;
        }};
        oilWall = new StaticWall("oil-wall"){{
            variants = 3;
            darksandTarred.asFloor().wall = Blocks.tar.asFloor().wall = Blocks.duneWall;
            sandTarred.asFloor().wall = Blocks.sandWall;
            Blocks.grass.asFloor().wall = Blocks.shrubs;
            inEditor = false;
        }};
        //production
        goldDrillStation = new SolidPump("goldDrillStation"){{
            requirements(Category.production, with(Items.lead, 200, Items.titanium, 150, Items.silicon, 200, Items.metaglass, 50, Items.thorium, 100, GMRItems.rawgold, 40));
            result = GMRLiquids.liquidGold;
            pumpAmount = 0.07f;
            size = 3;
            liquidCapacity = 30f;
            rotateSpeed = 1f;
            attribute = GMRAttributes.golden;

            consumePower(4f);
            researchCostMultiplier = 0.5f;
        }};
        //storage
        coreShiny = new CoreBlock("core-shiny"){{
            requirements(Category.effect, with(Items.copper, 5000, Items.lead, 6000, Items.silicon, 5000, Items.thorium, 3000, GMRItems.gold, 6000));
            alwaysUnlocked = true;
            isFirstTier = true;
            unitType = GMRUnits.sigma;
            health = 12000;
            itemCapacity = 16000;
            size = 3;

            unitCapModifier = 12;
        }};
        //crafting
        goldFurnance = new GenericCrafter("gold-furnance"){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 60, Items.graphite, 80, Items.titanium, 50));
            health = 300;
            outputLiquid = new LiquidStack(GMRLiquids.liquidGold, 14f / 60f);

            craftTime = 18f;
            hasLiquids = hasPower = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawDefault());

            consumePower(1.4f);
            consumeItem(GMRItems.rawgold, 2);
        }};
        goldPressurer = new GenericCrafter("gold-pressurer"){{
            requirements(Category.crafting, with(Items.lead, 70, Items.silicon, 60, Items.graphite, 90, Items.titanium, 100));
            health = 360;
            size = 2;
            outputItem = new ItemStack(GMRItems.gold, 1);

            craftTime = 18f;
            hasLiquids = hasPower = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawDefault());

            consumePower(3.2f);
            consumeItems(with(Items.copper, 1, Items.lead, 1));
            consumeLiquid(GMRLiquids.liquidGold, 28f / 60f);
        }};
        //power
        oilGenerator = new ConsumeGenerator("oil-generator"){{
            requirements(Category.power, with(Items.silicon, 70, Items.graphite, 55, Items.titanium, 50, GMRItems.rawgold, 30));
            powerProduction = 4.6f;
            consumeLiquid(Liquids.oil, 4f / 60f);
            size = 2;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawDefault());
            liquidCapacity = 20f;
        }};
        //turrets
        prelver = new ItemTurret("prelver"){{
            requirements(Category.turret, with(
                    Items.copper, 90,
                    Items.graphite, 60,
                    Items.titanium, 50,
                    GMRItems.gold, 30
            ));
            scaledHealth = 190;
            size = 2;
            reload = 30f;
            range = 170f;
            recoil = 2.1f;
            shoot.shots = 4;
            shoot.shotDelay = 3f;
            coolant = consumeCoolant(0.2f);
            heatColor = GMRPal.goldHeat;
            ammo(
                    GMRItems.rawgold, new RailBulletType(){{
                        length = 170f;
                        ammoMultiplier = 2f;
                        damage = 8f;
                        pierce = false;
                        hitColor = GMRPal.goldHeat;
                        hitEffect = endEffect = Fx.hitBulletColor;
                        lineEffect = new Effect(20f, e -> {
                            if(!(e.data instanceof Vec2 v)) return;

                            color(GMRPal.goldHeat);
                            stroke(e.fout() * 0.9f + 0.6f);

                            Fx.rand.setSeed(e.id);
                            for(int i = 0; i < 7; i++){
                                Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                                lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                            }

                            e.scaled(14f, b -> {
                                stroke(b.fout() * 1.5f);
                                color(GMRPal.goldHeat);
                                line(e.x, e.y, v.x, v.y);
                            });
                        });
                        fragBullet = new BasicBulletType(){{
                            damage = 4f;
                            speed = 3f;
                            width = 4f;
                            height = 6f;
                            ammoMultiplier = 1f;
                            lifetime = 5f;
                        }};
                        fragBullets = 3;
                        fragVelocityMin = 0.5f;
                        fragVelocityMax = 1.2f;
                        fragLifeMin = 0.6f;
                    }},
            GMRItems.gold, new RailBulletType(){{
                length = 170f;
                ammoMultiplier = 3f;
                damage = 35f;
                pierce = false;
                hitColor = GMRPal.goldHeat;
                hitEffect = endEffect = Fx.hitBulletColor;
                lineEffect = new Effect(20f, e -> {
                    if(!(e.data instanceof Vec2 v)) return;

                    color(GMRPal.goldHeat);
                    stroke(e.fout() * 0.9f + 0.6f);

                    Fx.rand.setSeed(e.id);
                    for(int i = 0; i < 7; i++){
                        Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                        lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                    }

                    e.scaled(14f, b -> {
                        stroke(b.fout() * 1.5f);
                        color(GMRPal.goldHeat);
                        line(e.x, e.y, v.x, v.y);
                    });
                });
            }});
            drawer = new DrawTurret("gold-");
        }};
    }
}
