package org.example.model.world.util;

import org.example.model.world.WorldSide;

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

    static public int getWorldSide(WorldSide worldSide){
        return worldSide.ordinal()+1;
    }

    static public double getAngleInDescartesSystem2D(WorldSide worldSide) throws Exception {
        switch (worldSide){
            case East:return 0;
            case North:return Math.PI/2;
            case West:return Math.PI;
            case South:return 3*Math.PI/2;
            default: throw new Exception();
        }
    }
}
