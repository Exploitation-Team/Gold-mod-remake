package gold.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class GMRItems {

    public static Item gold, rawgold;

    public static final Seq<Item> goldItems = new Seq<>();

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
    }
}
