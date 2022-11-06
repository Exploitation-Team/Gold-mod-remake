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
import static mindustry.Vars.*;
import static mindustry.content.Items.*;
import static mindustry.content.TechTree.*;

public class FalrenTechTree {
    public static void load(){
        GMRPlanets.falren.techTree = nodeRoot("falren", coreSolar, false, () -> {
            nodeProduce(GMRItems.rawgold, () -> {
                nodeProduce(lead, () -> {
                    nodeProduce(graphite, () -> {
                        nodeProduce(titanium, () -> {

                        });
                        nodeProduce(thorium, () -> {

                        });
                    });
                });
                nodeProduce(GMRLiquids.liquidGold, () -> {

                });
                nodeProduce(GMRItems.gold, () -> {
                    nodeProduce(GMRItems.shinyAlloy, () -> {

                    });
                });
            });
            node(goldDuct,() -> {
                node(goldDuctRouter,() -> {

                });
                node(goldDuctBridge,() -> {
                    node(goldTransporter,() -> {
                        node(shinyTransporter,() -> {

                        });
                    });
                });
            });
            node(spaceDrill,() -> {

            });
            node(navales,() -> {

            });
            node(basicSmelter,() -> {
                node(advancedSmelter,() -> {

                });
            });
        });
    }
}
