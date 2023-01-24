package org.example.model.response;

import org.example.model.robot.Robot;
import org.example.model.world.Position;
import org.example.model.world.Vector;
import org.example.model.world.util.VectorHandler;

import java.util.ArrayDeque;
import java.util.Iterator;

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

    public boolean isCircle() {
        int iteration = 10;
        try {
            Position startPosition = (Position) positions.getFirst().clone();
            Robot robotTemp = new Robot((Position) startPosition.clone());
            System.out.println("init func");
            System.out.println(startPosition.toString() + robotTemp.getPosition().toString());
            for (int i = 0; i < iteration; i++) {
                Iterator<Position> iterator = positions.iterator();
                Position prevPosition = iterator.next();
                while (iterator.hasNext()) {
                    Position curPosition = iterator.next();
                    if (isLeftRotate(prevPosition, curPosition)) {
                        robotTemp.rotateLeft();
                    } else if (isRightRotate(prevPosition, curPosition)) {
                        robotTemp.rotateRight();
                    } else {
                        robotTemp.go();
                    }
                    prevPosition = curPosition;
                    System.out.println("Robot " + robotTemp.getPosition().toString());
                }
                System.out.println("end");
                if (startPosition.equals(robotTemp.getPosition())) {
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }


//    public boolean isCircle() {
//        Position startPosition = (Position) positions.getFirst().clone();
//        Robot robotTemp = new Robot((Position) startPosition.clone());
//        for(int i = 0; i<10; i++){
//            Iterator<Position> iter = positions.iterator();
//            while (iter.hasNext()){
//                Position positionTemp = iter.next();
//                System.out.println(positionTemp.toString() + robotTemp.getPosition().toString());
//                if(robotTemp.getPosition() == positionTemp){
//                    System.out.println("пропуск первой позиции");
//                    continue;
//                }
//                if(isLeftRotate(robotTemp.getPosition(),positionTemp)){
//                    System.out.println("Налево");
//                    robotTemp.rotateLeft();
//                } else if (isRightRotate(robotTemp.getPosition(),positionTemp)) {
//                    System.out.println("Направо");
//                    robotTemp.rotateRight();
//                }else{
//                    System.out.println("Вперед");
//                    robotTemp.go();
//                }
//            }
//            if(robotTemp.getPosition().equals(startPosition)){
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean isLeftRotate(Position prev, Position cur){
        if(prev.getWorldSide().rotateLeft() == cur.getWorldSide()){
            return true;
        }
        return false;
    }
    private boolean isRightRotate(Position prev, Position cur){
        if(prev.getWorldSide().rotateRight() == cur.getWorldSide()){
            return true;
        }
        return false;
    }
}
