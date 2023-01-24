package org.example.model.world;

import org.example.entity.PositionEntity;
import org.example.model.IMoveable;
import org.example.model.world.util.WorldSideUtil;

public class Position implements Cloneable, IMoveable {
    private Point point;
    private WorldSide worldSide;

    public Position(){
        point = new Point(0,0);
        setWorldSide(WorldSide.North);
    }
    public Position(int x, int y, WorldSide worldSide){
        point = new Point(x,y);
        setWorldSide(worldSide);
    }

    public static Position toModel(PositionEntity positionEntity){
        return new Position(positionEntity.getX(), positionEntity.getY(), WorldSideUtil.getWorldSide(positionEntity.getWorldSide()));
    }
    public WorldSide getWorldSide() {
        return worldSide;
    }

    protected void setWorldSide(WorldSide worldSide) {
        this.worldSide = worldSide;
    }

    public Object clone(){
        Position position = new Position(this.point.getX(),this.point.getY(),this.worldSide);
        return position;
    }

    public Point getPoint() {
        return point;
    }

    protected void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Position{" +
                "point=" + point +
                ", worldSide=" + worldSide +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!point.equals(position.point)) return false;
        return worldSide == position.worldSide;
    }

    @Override
    public int hashCode() {
        int result = point.hashCode();
        result = 31 * result + worldSide.hashCode();
        return result;
    }

    @Override
    public void go() {
        switch (this.getWorldSide()) {
            case East:
                this.getPoint().setX(this.getPoint().getX() + 1);
                break;
            case West:
                this.getPoint().setX(this.getPoint().getX() - 1);
                break;
            case North:
                this.getPoint().setY(this.getPoint().getY() + 1);
                break;
            case South:
                this.getPoint().setY(this.getPoint().getY() - 1);
                break;
        }
    }

    @Override
    public void rotateLeft() {
        this.worldSide = worldSide.rotateLeft();
    }

    @Override
    public void rotateRight() {
        this.worldSide = worldSide.rotateRight();
    }
}
