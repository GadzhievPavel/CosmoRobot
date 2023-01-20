package org.example.model.world;

public class WorldSideUtil {
    static public WorldSide getWorldSide(int i) {
        WorldSide side = null;
        switch (i) {
            case 1:
                side = WorldSide.North;
                break;
            case 2:
                side = WorldSide.East;
                break;
            case 3:
                side = WorldSide.South;
                break;
            case 4:
                side = WorldSide.West;
                break;
        }
        return side;
    }
}
