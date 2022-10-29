package gold.content;

import mindustry.world.meta.Attribute;

public class GMRAttributes {
    public static Attribute golden;

    public static void load() {
        golden = Attribute.add("golden");

    }
}
