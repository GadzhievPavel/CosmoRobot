package org.example.model.robot;

import org.example.model.IMoveable;
import org.example.model.world.Position;

public class Robot implements IMoveable {
    private Position position;
    private History history;
    public Robot(){
        position = new Position();
        history = new History(position);
    }
    public Robot(History history){
        setHistory(history);
        setPosition(history.getPositions().peekLast());
    }

    public Robot(Position position){
        setPosition(position);
        setHistory(new History(position));
    }
    public Position getPosition() {
        return position;
    }
    private void setPosition(Position position) {
        this.position = position;
    }
    @Override
    public void go() {
        switch (getPosition().getWorldSide()) {
            case East:
                getPosition().getPoint().setX(getPosition().getPoint().getX() + 1);
                break;
            case West:
                getPosition().getPoint().setX(getPosition().getPoint().getX() - 1);
                break;
            case North:
                getPosition().getPoint().setY(getPosition().getPoint().getY() + 1);
                break;
            case South:
                getPosition().getPoint().setY(getPosition().getPoint().getY() - 1);
                break;
        }
        getHistory().addPosition(position);
    }

    @Override
    public void rotateLeft() {
        getPosition().setWorldSide(getPosition().getWorldSide().rotateLeft());
        getHistory().addPosition(position);
    }
    @Override
    public void rotateRight() {
        getPosition().setWorldSide(getPosition().getWorldSide().rotateRight());
        getHistory().addPosition(position);
    }
    @Override
    public String toString() {
        return "Robot{" +
                "position=" + position +
                ", \nhistory=" + history +
                '}';
    }
    public History getHistory() {
        return history;
    }
    private void setHistory(History history) {
        this.history = history;
    }

    public void reset(){
        setPosition(new Position());
        history.clear();
        getHistory().addPosition(getPosition());
    }
}
