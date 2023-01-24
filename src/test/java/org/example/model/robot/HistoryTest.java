package org.example.model.robot;

import org.example.model.world.Position;
import org.example.model.world.WorldSide;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryTest {

    @Test
    void addPosition() {
        History history = new History();
        ArrayList<Position> positions =new ArrayList<Position>(Arrays.asList(
                new Position(0,0, WorldSide.North),
                new Position(0,1,WorldSide.North),
                new Position(0,2,WorldSide.North),
                new Position(0,3,WorldSide.North),
                new Position(0,3,WorldSide.East),
                new Position(0,0,WorldSide.North),
                new Position(0,1,WorldSide.North),
                new Position(0,2,WorldSide.North),
                new Position(0,3,WorldSide.North),
                new Position(0,0,WorldSide.North),
                new Position(0,1,WorldSide.North),
                new Position(0,2,WorldSide.North),
                new Position(0,3,WorldSide.North)));

        ArrayDeque<Position> standart = new ArrayDeque<>(Arrays.asList(
                new Position(0,3,WorldSide.North),
                new Position(0,3,WorldSide.East),
                new Position(0,0,WorldSide.North),
                new Position(0,1,WorldSide.North),
                new Position(0,2,WorldSide.North),
                new Position(0,3,WorldSide.North),
                new Position(0,0,WorldSide.North),
                new Position(0,1,WorldSide.North),
                new Position(0,2,WorldSide.North),
                new Position(0,3,WorldSide.North)
        ));
        for (Position position : positions) {
            history.addPosition(position);
        }

        assertEquals(history.getPositions().toString(),standart.toString());
    }

    @Test
    void getPositions() {
        ArrayList<Position> positions =new ArrayList<Position>(Arrays.asList(
                new Position(0,0, WorldSide.North),
                new Position(0,1,WorldSide.North),
                new Position(0,2,WorldSide.East),
                new Position(0,3,WorldSide.North))
        );
        History history = new History();
        for (Position position: positions) {
            history.addPosition(position);
        }

        ArrayList<Position> positionsStandard =new ArrayList<Position>(Arrays.asList(
                new Position(0,0, WorldSide.North),
                new Position(0,1,WorldSide.North),
                new Position(0,2,WorldSide.East),
                new Position(0,3,WorldSide.North))
        );
        assertEquals(history.getPositions().toString(), positionsStandard.toString());
    }
}