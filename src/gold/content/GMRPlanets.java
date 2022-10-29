package gold.content;

import arc.graphics.*;
import gold.graphics.*;
import gold.planets.*;
import mindustry.content.*;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.type.*;


public class GMRPlanets {
    public static Planet
            zuila;
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
    }}
