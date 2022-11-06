package gold.content;

import mindustry.game.*;

public class GMRLoadouts {
    public static Schematic
            basicShiny, basicSolar;

    public static void load(){
            basicShiny = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZWANzsjMq2TgTkktTi7KLCjJzM9jYGBgy0lMSs0pZmCKjmVk4E/Pz0nRTc4vStUtBitmYGAEISAEAK2MEYk=");
            basicSolar = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZeB2zi9KtVIIzs9JLGLgTkktTi7KLCjJzM9jYGBgy0lMSs0pZmCKjmVk4E/Pz0nRTQaq1i0GK2ZgYAQhIAQAMTQTXg==");
    }
}
