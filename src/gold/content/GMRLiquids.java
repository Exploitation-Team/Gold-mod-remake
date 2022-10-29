package gold.content;

import arc.graphics.*;
import gold.graphics.GMRPal;
import mindustry.content.*;
import mindustry.type.*;

public class GMRLiquids {

    public static Liquid
    liquidGold;

    public static void load() {
        liquidGold = new Liquid("liquid-gold", Color.valueOf("e0c518")){{
            temperature = 1f;
            viscosity = 0.64f;
            effect = StatusEffects.melting;
            lightColor = GMRPal.goldHeat.a(0.4f);
        }};
    }
}