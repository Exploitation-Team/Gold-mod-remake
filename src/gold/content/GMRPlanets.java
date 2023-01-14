package gold.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import gold.graphics.*;
import gold.planets.*;
import gold.world.blocks.meta.*;

import static gold.content.GMRItems.falrenItems;
import static gold.content.GMRItems.goldItems;
import static mindustry.content.Items.*;
import static mindustry.content.Planets.*;


public class GMRPlanets {
    public static Planet
            zuila, falren, cori;
    public static void load(){
        Planets.tantros.visible = true;
        zuila = new Planet("zuila", Planets.sun, 1f, 3){{
            defaultCore = GMRBlocks.coreShiny;
            sectorSeed = 2;
            generator = new ZuilaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 3, 0.2f, 0.19f, 5, GMRPal.goldHeat.a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                            new HexSkyMesh(this, 2, 0.3f, 0.27f, 5, GMRPal.goldHeat.a(0.45f), 4, 0.35f, 1.35f, 0.45f)
            );
            iconColor = GMRPal.goldHeat;
            accessible = true;
            alwaysUnlocked = true;
            atmosphereColor = Color.valueOf("393939");
            startSector = 19;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.3f;
            clearSectorOnLose = true;
            allowLaunchLoadout = true;
            ruleSetter = r -> {
                r.loadout = ItemStack.list(Items.copper, 100, Items.lead, 100);
                r.defaultTeam = Team.sharded;
                r.waveTeam = Team.green;
                r.attributes.clear();
                r.showSpawns = true;
                r.fog = false;
                r.onlyDepositCore = false;
                r.coreIncinerates = true;
            };
        }};
        falren = makeAsteroid("falren", zuila, GMRBlocks.goldStone, Blocks.crystallineStoneWall, 0.43f, 10, 1.85f, gen -> {
            gen.carbonChance = 0.36f;
            gen.goldChance = 0.55f;
            gen.crystalChance = 0.4f;
        });
        falren.accessible = falren.alwaysUnlocked = true;

        zuila.hiddenItems.addAll(Vars.content.items()).removeAll(goldItems);
        falren.hiddenItems.addAll(Vars.content.items()).removeAll(falrenItems);
        serpulo.hiddenItems.addAll(Vars.content.items()).removeAll(serpuloItems);

    }
    private static Planet makeAsteroid(String name, Planet parent, Block base, Block tint, float tintThresh, int pieces, float scale, Cons<GMRAsteroidsGenerator> cgen){
        return new Planet(name, parent, 0.12f){{
            hasAtmosphere = false;
            updateLighting = false;
            sectors.add(new Sector(this, Ptile.empty));
            camRadius = 0.68f * scale;
            minZoom = 0.6f;
            drawOrbit = false;
            accessible = false;
            clipRadius = 2f;
            defaultEnv = Env.space;
            icon = "commandRally";
            generator = new GMRAsteroidsGenerator();
            cgen.get((GMRAsteroidsGenerator) generator);

            meshLoader = () -> {
                iconColor = tint.mapColor;
                Color tinted = tint.mapColor.cpy().a(1f - tint.mapColor.a);
                Seq<GenericMesh> meshes = new Seq<>();
                Color color = base.mapColor;
                Rand rand = new Rand(id + 2);

                meshes.add(new NoiseMesh(
                        this, 0, 2, radius, 2, 0.55f, 0.45f, 14f,
                        color, tinted, 3, 0.6f, 0.38f, tintThresh
                ));

                for(int j = 0; j < pieces; j++){
                    meshes.add(new MatMesh(
                            new NoiseMesh(this, j + 1, 1, 0.022f + rand.random(0.039f) * scale, 2, 0.6f, 0.38f, 20f,
                                    color, tinted, 3, 0.6f, 0.38f, tintThresh),
                            new Mat3D().setToTranslation(Tmp.v31.setToRandomDirection(rand).setLength(rand.random(0.44f, 1.4f) * scale)))
                    );
                }

                return new MultiMesh(meshes.toArray(GenericMesh.class));
            };
        }};
    }
}
