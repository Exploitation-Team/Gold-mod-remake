package gold.content;

import mindustry.type.*;

import static gold.content.GMRPlanets.*;

public class GMRSectors {
    public static SectorPreset
            groundOne, schemeBattle, abandonedLaboratory;

    public static void load(){
        groundOne = new SectorPreset("ground-one", zuila, 19){{
            captureWave = 30;
            difficulty = 5;
            startWaveTimeMultiplier = 2.4f;
        }};
        schemeBattle = new SectorPreset("scheme-battle", zuila, 191){{
            difficulty = 6;
            allowLaunchSchematics = true;
        }};
        abandonedLaboratory = new SectorPreset("abandoned-laboratory", zuila, 8){{
            captureWave = 40;
            difficulty = 8;
        }};
    }
}
