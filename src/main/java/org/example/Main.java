package org.example;

import org.example.model.robot.Robot;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.toString());
        robot.go();
        robot.rotateRight();
        robot.go();
        robot.go();
        robot.rotateRight();
        robot.go();
        robot.go();
        robot.rotateRight();
        robot.go();
        robot.go();
        robot.rotateRight();
        System.out.println(robot.getHistory().toString());
    }
}