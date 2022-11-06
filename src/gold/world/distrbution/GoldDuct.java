package gold.world.distrbution;

import arc.struct.*;
import gold.content.GMRBlocks;
import mindustry.entities.units.*;
import mindustry.input.*;
import mindustry.world.blocks.distribution.*;

public class GoldDuct extends Duct{
    //Slotterleet code moment
    //Why we cant put custom bridges replacement in custom duct like in conveyors?
    public GoldDuct(String name) {
        super(name);
    }

    @Override
    public void handlePlacementLine(Seq<BuildPlan> plans){
        Placement.calculateBridges(plans, (DuctBridge) GMRBlocks.goldDuctBridge, false, b -> b instanceof Duct || b instanceof StackConveyor || b instanceof Conveyor);
    }
}
