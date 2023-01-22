package org.example.model.robot;

import org.example.config.DataSourceConfig;
import org.example.db.dao.PositionDAO;
import org.example.db.exception.PositionTransactionException;
import org.example.db.map.PositionMap;
import org.example.model.robot.exception.HistoryPositionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayDeque;

@Component
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
        //Position oldTempPosition = null;
        if(getMaxSizeHistory()<=0){
            throw new HistoryPositionException("max size ArrayDeque<Position> <= 0");
        }
        if(positions.size()<getMaxSizeHistory()){
            positions.addLast(clone);
        }else{
            //oldTempPosition = positions.pop();
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
