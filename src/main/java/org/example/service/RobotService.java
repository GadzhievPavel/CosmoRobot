package org.example.service;

import org.example.db.PositionRepo;
import org.example.entity.PositionEntity;
import org.example.model.command.Command;
import org.example.model.robot.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    @Autowired
    private PositionRepo repo;
    private Robot robot;

    public RobotService (){
        robot = new Robot();
    }

    public PositionEntity move(Command command){
        switch (command.getMoveRobot()){
            case 'L':
                robot.rotateLeft();
                break;
            case 'R':
                robot.rotateRight();
                break;
            case 'G':
                robot.go();
                break;
        }
        PositionEntity positionEntity = new PositionEntity(robot.getPosition());
        return repo.save(positionEntity);
    }
}
