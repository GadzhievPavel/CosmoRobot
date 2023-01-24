package org.example.model.world;

public class Vector {
    private Point pointStart;
    private Point pointFinish;

    private double angleRadian;

    public Vector(){
        this.pointStart = new Point(0,0);
        this.pointFinish = new Point(1,1);
        angleRadian = calcAngle();
    }

    public Vector(Point point1, Point point2){
        this.pointStart = point1;
        this.pointFinish = point2;
        angleRadian = calcAngle();
    }

    public Vector(Vector vector){
        this.pointStart = vector.getPointStart();
        this.pointFinish = vector.getPointFinish();
    }

    public Point getPointStart() {
        return pointStart;
    }

    public void setPointStart(Point pointStart) {
        this.pointStart = pointStart;
    }

    public Point getPointFinish() {
        return pointFinish;
    }

    public void setPointFinish(Point pointFinish) {
        this.pointFinish = pointFinish;
    }

    public void move(Vector vector){
        int deltaX = vector.getPointFinish().getX() - vector.getPointStart().getX();
        int deltaY = vector.getPointFinish().getY() - vector.getPointStart().getY();
        this.pointStart.setX(this.pointStart.getX()+deltaX);
        this.pointStart.setY(this.pointStart.getY()+deltaY);
        this.pointFinish.setX(this.pointFinish.getX()+deltaX);
        this.pointFinish.setY(this.pointFinish.getY()+deltaY);
    }

    public void rotateAroundFirstPoint(double angleRadian){
        int deltaX = -pointStart.getX();
        int deltaY = -pointStart.getY();
        int x = (int) (((pointFinish.getX()+deltaX)*Math.cos(angleRadian) - (pointFinish.getY()+deltaY)*Math.sin(angleRadian))-deltaX);
        int y = (int) (((pointFinish.getY()+deltaY)*Math.cos(angleRadian) + (pointFinish.getX()+deltaX)*Math.sin(angleRadian))-deltaY);
        pointFinish.setX(x);
        pointFinish.setY(y);
        this.angleRadian = calcAngle();
    }

    private double calcAngle(){
        int deltaX = pointFinish.getX()- pointStart.getX();
        int deltaY = pointFinish.getY() - pointStart.getY();
        double gipo = deltaX/(Math.sqrt(Math.pow(deltaY,2)+Math.pow(deltaX,2)));
        return deltaX/gipo;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "pointStart=" + pointStart +
                ", pointFinish=" + pointFinish +
                ", angle=" + Math.toDegrees(angleRadian) +
                '}';
    }
}
