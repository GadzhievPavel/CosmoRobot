package org.example.model.response;

import org.example.model.robot.Position;
import org.example.model.world.Vector;
import org.example.model.world.util.VectorHandler;

import java.util.ArrayDeque;

public class RouteRobot {
    private ArrayDeque<Position> positions;
    private boolean isCircle;

    public RouteRobot(){
        this.positions = new ArrayDeque<>();
        this.isCircle=false;
    }
    public RouteRobot(ArrayDeque<Position> positions){
        this.positions = positions;
        this.isCircle = isCircle();
    }

    public ArrayDeque<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayDeque<Position> positions) {
        this.positions = positions;
    }

    public void setCircle(boolean circle) {
        isCircle = circle;
    }

    public boolean getCircle(){
        return isCircle;
    }
    private boolean isCircle(){
        Position positionStart = positions.getFirst();
        Position positionFinish = positions.getLast();
        Vector vector = new Vector(positionStart.getX(), positionStart.getY(),
                positionFinish.getX(),positionFinish.getY());
        VectorHandler vectorHandler = new VectorHandler(vector);
        boolean result = false;
        for(int i=0; i<10;i++){
            vectorHandler.moveFirstPoint(vector.getX2(), vector.getY2());
            vectorHandler.rotateAroundFirstPoint(vector.getAngle());
            result = vector.equals(vectorHandler.getVector());
            if(result){
                return true;
            }
        }
        return false;
    }
}
