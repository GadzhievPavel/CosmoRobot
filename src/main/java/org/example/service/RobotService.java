package org.example.service;

import org.example.entity.PositionRepo;
import org.example.entity.PositionEntity;
import org.example.model.command.Command;
import org.example.model.response.RouteRobot;
import org.example.model.robot.Position;
import org.example.model.robot.Robot;
import org.example.model.world.Vector;
import org.example.model.world.util.VectorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayDeque;
import java.util.List;

@Service
public class RobotService {
    @Autowired
    private PositionRepo repo;
    private Robot robot;

    public RobotService (){
        robot = new Robot();
    }
    @PostConstruct
    public void saveRobotPosition(){
        PositionEntity positionEntity = new PositionEntity(robot.getPosition());
        repo.save(positionEntity);
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

    public Position getPosition(){
        return robot.getPosition();
    }

    public Position resetPosition(){
        robot.reset();
        repo.save(new PositionEntity(robot.getPosition()));
        return robot.getPosition();
    }

    public RouteRobot getRoute(){
        return new RouteRobot(robot.getHistory().getPositions());
    }


}
