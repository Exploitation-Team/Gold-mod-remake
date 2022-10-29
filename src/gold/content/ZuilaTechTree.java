package gold.content;

import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.blocks.defense.turrets.*;

import static gold.content.GMRBlocks.*;
import static gold.content.GMRSectors.*;
import static mindustry.Vars.*;
import static mindustry.content.TechTree.*;

public class ZuilaTechTree {
    public static void load(){
        GMRPlanets.zuila.techTree = nodeRoot("zuila", coreShiny, false, () -> {
            nodeProduce(GMRItems.rawgold, () -> {
                nodeProduce(GMRLiquids.liquidGold, () -> {

                });
                nodeProduce(GMRItems.gold, () -> {

                });
            });
            node(groundOne, Seq.with(new SectorComplete(SectorPresets.planetaryTerminal), new Research(coreShiny)),() -> {

            });
            node(goldDrillStation, Seq.with(new OnSector(groundOne), new Produce(GMRItems.gold)),() -> {

            });
            node(goldFurnance, Seq.with(new OnSector(groundOne)),() -> {
                node(goldFurnance, Seq.with(new Produce(GMRLiquids.liquidGold)),() -> {

                });
            });
        });
    }
}