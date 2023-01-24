package org.example.model.robot;

import org.example.model.world.Position;
import org.example.model.world.WorldSide;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Robot robot = new Robot(new Position(1,2, WorldSide.North));

    @Test
    void getPosition() {
        Position position = new Position(1,2,WorldSide.North);
        assertEquals(robot.getPosition().toString(), position.toString());
    }

    @Test
    void go() {
        robot.go();
        Position position = new Position(1,3,WorldSide.North);
        assertEquals(robot.getPosition().toString(),position.toString());
    }

    @Test
    void rotateLeft() {
        robot.rotateLeft();
        Position position = new Position(1,2,WorldSide.West);
        assertEquals(robot.getPosition().toString(),position.toString());
    }

    @Test
    void rotateRight() {
        robot.rotateRight();
        robot.rotateRight();
        Position position = new Position(1,2, WorldSide.South);
        assertEquals(robot.getPosition().toString(), position.toString());
    }

    @Test
    void getHistory() {
        robot.go();
        robot.go();
        robot.rotateRight();
        robot.go();
        robot.rotateLeft();
        robot.go();
        robot.rotateLeft();
        robot.rotateLeft();
        robot.go();
        robot.go();
        ArrayList<Position> positionsStandard =new ArrayList<Position>(Arrays.asList(
                new Position(1,2, WorldSide.North),
                new Position(1,3,WorldSide.North),
                new Position(1,4,WorldSide.North),
                new Position(1,4,WorldSide.East),
                new Position(2,4,WorldSide.East),
                new Position(2,4,WorldSide.North),
                new Position( 2,5,WorldSide.North),
                new Position(2,5,WorldSide.West),
                new Position(2,5,WorldSide.South),
                new Position(2,4,WorldSide.South),
                new Position(2,3,WorldSide.South)
                ));
        assertEquals(robot.getHistory().getPositions().toString(), positionsStandard.toString());
        //assertEquals(robot.getHistory().getMaxSizeHistory(),10);
    }
}