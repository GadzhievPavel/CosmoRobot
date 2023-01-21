package org.example.db.mapper;


import org.example.db.map.PositionMap;
import org.example.model.robot.Position;
import org.example.model.world.WorldSide;
import org.example.model.world.WorldSideUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position> {
    public static final String BASE_SQL =String.format("SELECT %s, %s, %s FROM positions",
            PositionMap.x.name(),PositionMap.y.name(),PositionMap.id_world_side.name());
    @Override
    public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(PositionMap.id.name());
        int x = rs.getInt(PositionMap.x.name());
        int y = rs.getInt(PositionMap.y.name());
        WorldSide side = WorldSideUtil.getWorldSide(rs.getInt(PositionMap.id_world_side.name()));
        Position position = new Position(id,x,y,side);
        return position;
    }
}
