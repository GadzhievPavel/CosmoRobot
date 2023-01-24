package org.example.model.world;

import org.example.model.world.util.WorldSideUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void getPointStart() {
        Point point = new Point(0,0);
        Point point1 = new Point(1,1);
        Vector vector = new Vector(point,point1);
        assertEquals(vector.getPointStart().toString(),point.toString());
    }

    @Test
    void setPointStart() {
    }

    @Test
    void getPointFinish() {
    }

    @Test
    void setPointFinish() {
    }

    @Test
    void move() {
        Point point = new Point(0,0);
        Point point1 = new Point(1,1);
        Vector vector = new Vector(point,point1);
        Point point2 = new Point(0,0);
        Point point3 = new Point(1,1);
        Vector vector1 = new Vector(point2,point3);
        vector.move(vector1);
        assertEquals(vector.getPointFinish().getY(),2);
        assertEquals(vector.getPointFinish().getX(),2);
        assertEquals(vector.getPointStart().getX(),1);
        assertEquals(vector.getPointStart().getX(),1);
    }

    @Test
    void rotateAroundFirstPoint() {
        Point point = new Point(0,0);
        Point point1 = new Point(1,0);
        Vector vector = new Vector(point,point1);
        try {
            vector.rotateAroundFirstPoint(WorldSideUtil.getAngleInDescartesSystem2D(WorldSide.North));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(vector.getPointFinish().getX(),-0);
        assertEquals(vector.getPointFinish().getY(),1);

        try {
            vector.rotateAroundFirstPoint(WorldSideUtil.getAngleInDescartesSystem2D(WorldSide.North));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(vector.getPointFinish().getX(),-0);
        assertEquals(vector.getPointFinish().getY(),1);
    }
}