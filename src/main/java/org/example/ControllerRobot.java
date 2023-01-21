package org.example;

import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import javax.annotation.Resource;

@RestController
@RequestMapping("/robot")
public class ControllerRobot {
    @GetMapping("/")
    public ResponseEntity go(){
        try{
            return ResponseEntity.ok("Едем");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("что-то сломалось");
        }
    }

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

//    @PostMapping(path = "/command",params = )
//    public ResponseEntity moving(){
//        try {
//
//        }catch (Exception e) {
//        }
//
//    }
}
