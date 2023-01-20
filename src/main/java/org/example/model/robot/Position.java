package org.example.model.robot;

import org.example.model.world.WorldSide;

public class Position implements Cloneable {
    private int x;
    private int y;
    private WorldSide worldSide;

    public Position(){
        setY(0);
        setX(0);
        setWorldSide(WorldSide.North);
    }
    public Position(int x, int y, WorldSide worldSide){
        setX(x);
        setY(y);
        setWorldSide(worldSide);
    }
    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public WorldSide getWorldSide() {
        return worldSide;
    }

    protected void setWorldSide(WorldSide worldSide) {
        this.worldSide = worldSide;
    }

    public Object clone(){
        Position position = new Position(this.x,this.y,this.worldSide);
        return position;
    }
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", worldSide=" + worldSide +
                '}';
    }
}
