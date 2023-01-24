package org.example.controller;

import org.example.model.command.Command;
import org.example.model.world.Position;
import org.example.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/robot")
public class ControllerRobot {
    @Autowired
    RobotService robotService;
    private final int  delay = 11;
    @GetMapping("/position")
    public ResponseEntity getPosition(){
        cosmoDelaySimulation();
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
        cosmoDelaySimulation();
        try {
            return ResponseEntity.ok(robotService.resetPosition());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("робот не смог вернуться назад");
        }
    }
    @PostMapping(path = "/command")
    public ResponseEntity moving(@RequestBody Command command){
        cosmoDelaySimulation();
        try{
            return ResponseEntity.ok().body(Position.toModel(robotService.move(command)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("робот не смог переместиться");
        }
    }

    private void cosmoDelaySimulation(){
        Random random = new Random();
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(delay));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
