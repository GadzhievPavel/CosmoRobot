package org.example.model.world.util;

import org.example.model.world.Vector;

public class VectorHandler {
    private Vector vector;

    public VectorHandler(Vector vector){
        Vector copy = new Vector(vector);
        this.vector = copy;
    }
    public void rotateAroundFirstPoint(double angle){
        vector.setX2((int) (vector.getX2()*Math.cos(angle) - vector.getY2()*Math.sin(angle)));
        vector.setY2((int) (vector.getX2()*Math.sin(angle) + vector.getY2()*Math.cos(angle)));
    }
    public void moveFirstPoint(int x, int y){
        int deltaX = x - vector.getX1();
        int deltaY = y - vector.getY1();
        vector.setX1(vector.getX1()+deltaX);
        vector.setX2(vector.getX2()+deltaX);
        vector.setY1(vector.getY1()+deltaY);
        vector.setY2(vector.getY2()+deltaY);
    }

    public Vector getVector() {
        return vector;
    }
}
