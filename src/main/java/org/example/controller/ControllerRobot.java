package org.example.controller;

import org.example.model.command.Command;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.annotation.Resource;

@RestController
@RequestMapping("/robot")
public class ControllerRobot {
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
        try {
            return ResponseEntity.ok().body("Command is "+command.getMoveRobot());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("не понял команду");
        }

    }
}
