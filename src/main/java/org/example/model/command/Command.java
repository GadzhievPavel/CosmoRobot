package org.example.model.command;

import org.springframework.stereotype.Component;

@Component
public class Command {
    char moveRobot;

    public char getMoveRobot() {
        return moveRobot;
    }

    public void setMoveRobot(char moveRobot) {
        this.moveRobot = moveRobot;
    }

}
