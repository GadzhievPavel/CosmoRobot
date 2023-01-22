package org.example.model.world;

public class Vector {
    private int x1,y1;
    private int x2,y2;
    private double angle;

    public Vector(){
        x1=0; y1=0;
        x2=1; y2=1;
        angle = calcAngle();
    }

    public Vector(int x, int y, int x1, int y1){
        this.x1=x;
        this.x2=x1;
        this.y1=y;
        this.y2=y1;
        angle = calcAngle();
    }

    public Vector(Vector vector){
        this.x1= vector.getX1();
        this.x2= vector.getX2();
        this.y1= vector.getY1();
        this.y2= vector.getY2();
        angle = calcAngle();
    }
    private double calcAngle(){
        int deltaX = x2-x1;
        int deltaY = y2-y1;
        return Math.tan(deltaX/deltaY);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public double getAngle() {
        return angle;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (x1 != vector.x1) return false;
        if (y1 != vector.y1) return false;
        if (x2 != vector.x2) return false;
        if (y2 != vector.y2) return false;
        return Double.compare(vector.angle, angle) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        temp = Double.doubleToLongBits(angle);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
