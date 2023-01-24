package org.example.model.response;

import org.example.model.robot.Robot;
import org.example.model.world.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteRobotTest {

    @Test
    void isCircle() {
        Robot robot = new Robot();
        robot.go();
        robot.go();
        robot.rotateLeft();

        RouteRobot routeRobot = new RouteRobot(robot.getHistory().getPositions());

        assertEquals(routeRobot.isCircle(),true);

        robot.go();
        robot.rotateRight();
        robot.go();

        assertEquals(routeRobot.isCircle(),false);

    }
}