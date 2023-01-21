package org.example;

import org.example.config.DataSourceConfig;
import org.example.db.dao.PositionDAO;
import org.example.model.robot.History;
import org.example.model.robot.Position;
import org.example.model.robot.Robot;
import org.example.model.world.WorldSide;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.example")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);

        SpringApplication.run(Main.class, args);
//        Robot robot = new Robot();
//        System.out.println(robot.toString());
//        robot.go();
//        robot.rotateRight();
//        robot.go();
//        robot.go();
//        robot.rotateRight();
//        robot.go();
//        robot.go();
//        robot.rotateRight();
//        robot.go();
//        robot.go();
//        robot.rotateRight();
//        System.out.println(robot.getHistory().toString());
    }
}