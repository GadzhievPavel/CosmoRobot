package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.world.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ControllerRobot.class)
class ControllerRobotTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ControllerRobot controllerRobot;

    @Test
    void getPosition() throws Exception {
        Position position = new Position();
        Mockito.when(controllerRobot.getPosition()).thenReturn(ResponseEntity.ok().body(position));
    }

    @Test
    void getRoute() {
    }

    @Test
    void resetPosition() {
    }

    @Test
    void moving() {
    }
}