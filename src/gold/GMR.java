package gold;

import arc.*;
import arc.util.*;
import gold.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import static mindustry.Vars.ui;

public class GMR extends Mod{

    public GMR(){
        Log.info("Loaded GMR constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            ui.showOkText("@gold.disclaimer", "@gold.unknown",() -> {});
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loading some gold content.");
        GMRSounds.load();
        GMRAttributes.load();
        GMRItems.load();
        GMRLiquids.load();
        GMRUnits.load();
        GMRBlocks.load();
        GMRLoadouts.load();
        GMRPlanets.load();
        GMRSectors.load();
        ZuilaTechTree.load();
        FalrenTechTree.load();
    }

}
