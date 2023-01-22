package org.example.controller;

import org.example.db.PositionRepo;
import org.example.db.dao.PositionDAO;
import org.example.entity.PositionEntity;
import org.example.model.command.Command;
import org.example.model.robot.Position;
import org.example.model.world.WorldSide;
import org.example.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.annotation.Resource;

@RestController
@RequestMapping("/robot")
public class ControllerRobot {
    @Autowired
    RobotService robotService;
    @GetMapping("/position")
    public ResponseEntity getPosition(){
        try {
            return ResponseEntity.ok("моя позиция");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("я потерялся");
        }
    }

    @GetMapping("/route")
    public ResponseEntity getRoute(){
        try{
            return ResponseEntity.ok("У самурая нет маршрута, только путь");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("не могу найти маршрут");
        }
    }

    @PostMapping("/reset")
    public ResponseEntity resetPosition(){
        try {
            return ResponseEntity.ok("вернулся в исходную позицию");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("не получилось вернуться");
        }
    }
    @PostMapping(path = "/command")
    public ResponseEntity moving(@RequestBody Command command){
            return ResponseEntity.ok().body(robotService.move(command));


    }
}
