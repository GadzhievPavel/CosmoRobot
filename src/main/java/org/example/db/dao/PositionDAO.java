package org.example.db.dao;

import org.example.config.DataSourceConfig;
import org.example.db.exception.PositionTransactionException;
import org.example.db.map.PositionMap;
import org.example.db.mapper.PositionMapper;
import org.example.model.robot.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.List;

@Repository
@Transactional
public class PositionDAO extends JdbcDaoSupport {
    @Autowired
    public PositionDAO(){
        try {
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            this.setDataSource(dataSourceConfig.dataSource());
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Position> getPositions(){
        String sql = PositionMapper.BASE_SQL;
        PositionMapper mapper = new PositionMapper();
        List<Position> positions = getJdbcTemplate().query(sql,mapper);
        return positions;
    }

    public Position findPosition(int id){
        String sql = PositionMapper.BASE_SQL+" where id=?";
        Object[] params = new Object[]{id};
        PositionMapper mapper = new PositionMapper();
        try {
            Position position = getJdbcTemplate().query(sql,mapper,id).get(0);
            return position;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    @Transactional
    public void addPosition(Position position) throws PositionTransactionException {
            String sql = String.format("INSERT positions(%s,%s,%s) VALUES(%d,%d,%d)",
                    PositionMap.x.name(), PositionMap.y.name(), PositionMap.id_world_side.name(),
                    position.getX(), position.getY(), position.getWorldSide().ordinal());
            getJdbcTemplate().execute(sql);

    }
}
