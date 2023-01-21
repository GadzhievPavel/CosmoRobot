package org.example.db.dao;

import org.example.config.DataSourceConfig;
import org.example.db.exception.PositionTransactionException;
import org.example.db.map.PositionMap;
import org.example.db.mapper.PositionMapper;
import org.example.model.robot.Position;
import org.example.model.world.WorldSideUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.List;

@Repository
//@Transactional
public class PositionDAO extends JdbcDaoSupport implements IBaseCommands<Position> {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PositionDAO(DataSource dataSource){
        setDataSource(dataSource);
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Position selectByID(int id) {
        String sql = PositionMapper.BASE_SQL+" where id=?";
        PositionMapper mapper = new PositionMapper();
        try {
            Position position = getJdbcTemplate().query(sql,mapper,id).get(0);
            return position;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void insert(Position position){
        String sql = String.format("INSERT positions(%s,%s,%s) VALUES(%d,%d,%d)",
                PositionMap.x.name(), PositionMap.y.name(), PositionMap.id_world_side.name(),
                position.getX(), position.getY(), position.getWorldSide().ordinal());
        getJdbcTemplate().execute(sql);
    }

    @Override
    public void update(Position position) {
        StringBuilder builder = new StringBuilder("UPDATE positions SET ");
        builder.append(PositionMap.x.name()).append("=");
        builder.append(position.getX());
        builder.append(", ");
        builder.append(PositionMap.y.name()).append("=");
        builder.append(position.getY());
        builder.append(", ");
        builder.append(PositionMap.id_world_side.name()).append("=");
        builder.append(WorldSideUtil.getWorldSide(position.getWorldSide()));
        builder.append(" WHERE ");
        builder.append(PositionMap.id.name());
        builder.append("="+position.getId());
        String sql = builder.toString();
        getJdbcTemplate().update(sql);
    }

    @Override
    public void delete(Position position) {
        StringBuilder builder = new StringBuilder("DELETE FROM positions WHERE ");
        builder.append("id="+position.getId());
        getJdbcTemplate().execute(builder.toString());
    }
}
