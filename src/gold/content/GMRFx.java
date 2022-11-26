package gold.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.units.UnitAssembler.*;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class GMRFx {

    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static final Effect

    polyForceShrink = new Effect(20, e -> {
        color(e.color, e.fout());
        if(renderer.animateShields){
            Fill.poly(e.x, e.y, 4, e.rotation * e.fout());
            Fill.poly(e.x, e.y, 4, e.rotation * e.fout(), 45);
        }else{
            stroke(1.5f);
            Draw.alpha(0.09f);
            Fill.poly(e.x, e.y, 4, e.rotation * e.fout());
            Draw.alpha(1f);
            Lines.poly(e.x, e.y, 4, e.rotation * e.fout());
            stroke(1.5f);
            Draw.alpha(0.09f);
            Fill.poly(e.x, e.y, 4, e.rotation * e.fout(), 45);
            Draw.alpha(1f);
            Lines.poly(e.x, e.y, 4, e.rotation * e.fout(), 45);
        }
    }).layer(Layer.shields),
            polyShieldBreak = new Effect(40, e -> {
                color(e.color);
                stroke(3f * e.fout());
                Lines.poly(e.x, e.y, 4, e.rotation + e.fin());
                Lines.poly(e.x, e.y, 4, e.rotation + e.fin(), 45);
            }).followParent(true);
}
