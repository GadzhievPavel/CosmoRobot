package org.example.model.robot;

import org.example.model.robot.exception.HistoryPositionException;

import java.util.ArrayDeque;

public class History {

    private final short standardSize=10;
    private short maxSizeHistory;

    private final ArrayDeque<Position> positions;

    public History(){
        positions = new ArrayDeque<>();
        setMaxSizeHistory(standardSize);
    }

    public History(Position position){
        positions = new ArrayDeque<>();
        setMaxSizeHistory(standardSize);
        addPosition(position);
    }
    public void addPosition(Position position){
        Position clone = (Position) position.clone();
        if(getMaxSizeHistory()<=0){
            throw new HistoryPositionException("max size ArrayDeque<Position> <= 0");
        }
        if(positions.size()<getMaxSizeHistory()){
            positions.addLast(clone);
        }else{
            positions.pop();
            positions.addLast(clone);
        }
    }

    public short getMaxSizeHistory() {
        return maxSizeHistory;
    }

    public void setMaxSizeHistory(short maxSizeHistory) {
        if(positions.size()<maxSizeHistory){
            this.maxSizeHistory = maxSizeHistory;
        }
    }

    public ArrayDeque<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "History{" +
                "maxSizeHistory=" + maxSizeHistory +
                ", positions=" + positions +
                '}';
    }
}
