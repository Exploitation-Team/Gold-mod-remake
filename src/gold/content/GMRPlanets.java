package gold.content;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import gold.graphics.*;
import gold.planets.*;
import gold.world.meta.GMREnv;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static gold.content.GMRItems.falrenItems;
import static gold.content.GMRItems.goldItems;
import static mindustry.content.Items.*;
import static mindustry.content.Planets.*;


public class GMRPlanets {
    public static Planet
            zuila, falren;
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
        falren = new Planet("falren", zuila, 0.2f){{
            hasAtmosphere = false;
            updateLighting = false;
            icon = "commandRally";
            iconColor = GMRPal.goldDark;
            sectors.add(new Sector(this, PlanetGrid.Ptile.empty));
            camRadius = 0.68f * 1.3f;
            minZoom = 0.5f;
            drawOrbit = false;
            accessible = true;
            alwaysUnlocked = true;
            clipRadius = 2f;
            defaultEnv = GMREnv.goldSpace;
            generator = new GMRAsteroidsGenerator(){{
                carbonChance = 0.36f;
                goldChance = 0.55f;
                crystalChance = 0.4f;
            }};
            ruleSetter = r -> {
                r.loadout = ItemStack.list(GMRItems.gold, 200);
                r.winWave = 1;
                r.waveTeam = Team.green;
            };
            meshLoader = () -> {
                Rand rand = new Rand(8);
                Seq<GenericMesh> meshes = new Seq<>();
                meshes.add(new NoiseMesh(
                        this, 8, 2, radius, 2, 0.65f, 0.45f, 14f,
                        GMRPal.goldDark, GMRPal.goldDark, 3, 0.6f, 0.4f, 0.5f
                ));

                for(int j = 0; j < 28; j++){

                    meshes.add(new MatMesh(
                            new NoiseMesh(this, 7, 1, 0.032f + rand.random(0.05f) * 1.32f, 2, 0.6f, 0.36f, 21f,
                                    GMRPal.carbon, GMRPal.carbon, 4, 0.74f, 0.4f, 0.5f),
                            new Mat3D().setToTranslation(Tmp.v31.setToRandomDirection(rand).setLength(rand.random(0.44f, 1.4f) * 1.3f)))
                    );
                }

                return new MultiMesh(meshes.toArray(GenericMesh.class));
            };
        }};

        zuila.hiddenItems.addAll(Vars.content.items()).removeAll(goldItems);
        falren.hiddenItems.addAll(Vars.content.items()).removeAll(falrenItems);
        serpulo.hiddenItems.addAll(Vars.content.items()).removeAll(serpuloItems);

    }}
