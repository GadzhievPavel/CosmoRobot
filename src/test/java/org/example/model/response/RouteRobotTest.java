package org.example.model.response;

import org.example.model.robot.Robot;
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

        assertTrue(routeRobot.isCircle());

        robot.go();
        robot.rotateRight();
        robot.go();

        assertFalse(routeRobot.isCircle());

        robot.reset();
        robot.go();
        robot.go();
        RouteRobot routeRobot1 = new RouteRobot(robot.getHistory().getPositions());

        assertFalse(routeRobot1.isCircle());

        robot.reset();
        robot.go();
        robot.go();
        robot.rotateLeft();
        robot.rotateLeft();
        robot.go();
        robot.go();

        RouteRobot routeRobot2 = new RouteRobot(robot.getHistory().getPositions());
        assertTrue(routeRobot2.isCircle());


    }
}