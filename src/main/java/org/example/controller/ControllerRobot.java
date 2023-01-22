package org.example.controller;

import org.example.exception.RobotException;
import org.example.model.command.Command;
import org.example.model.robot.Position;
import org.example.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/robot")
public class ControllerRobot {
    @Autowired
    RobotService robotService;
    @GetMapping("/position")
    public ResponseEntity getPosition(){
        try {
            return ResponseEntity.ok(robotService.getPosition());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("я потерялся");
        }
    }

    @GetMapping("/route")
    public ResponseEntity getRoute(){
            return ResponseEntity.ok(robotService.getRoute());

    }

    @PostMapping("/reset")
    public ResponseEntity resetPosition(){
        try {
            return ResponseEntity.ok(robotService.resetPosition());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("робот не смог вернуться назад");
        }
    }
    @PostMapping(path = "/command")
    public ResponseEntity moving(@RequestBody Command command){
        try{
            return ResponseEntity.ok().body(Position.toModel(robotService.move(command)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("робот не смог переместиться");
        }
    }
}
