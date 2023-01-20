package org.example.db.mapper;


import org.example.db.map.PositionMap;
import org.example.model.robot.Position;
import org.example.model.world.WorldSide;
import org.example.model.world.WorldSideUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position> {
    public static final String BASE_SQL ="SELECT x, y, id_world_side FROM positions";
    @Override
    public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
        int x = rs.getInt(PositionMap.x.name());
        int y = rs.getInt(PositionMap.y.name());
        WorldSide side = WorldSideUtil.getWorldSide(rs.getInt(PositionMap.id_world_side.name()));
        Position position = new Position(x,y,side);
        return position;
    }
}
