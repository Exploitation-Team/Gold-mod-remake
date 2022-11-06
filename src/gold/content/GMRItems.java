package gold.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

import static mindustry.content.Items.*;

public class GMRItems {

    public static Item gold, rawgold, shinyAlloy;

    public static final Seq<Item> goldItems = new Seq<>();
    public static final Seq<Item> falrenItems = new Seq<>();

    public static void load(){
        gold = new Item("gold", Color.valueOf("e0c518")){{
            hardness = 1;
            cost = 7f;
            healthScaling = 5.4f;
        }};
        rawgold = new Item("raw-gold", Color.valueOf("b9a311")){{
            hardness = 4;
            cost = 5f;
            healthScaling = 3.2f;
        }};
        shinyAlloy = new Item("shiny-alloy", Color.valueOf("d4d4d4")){{
            cost = 9f;
            healthScaling = 6f;
        }};
        goldItems.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass, gold, rawgold, shinyAlloy
        );
        falrenItems.addAll(
                lead, graphite, titanium, thorium, rawgold, gold, shinyAlloy
        );
    }
}
