package org.example.db;

import org.example.entity.PositionEntity;
import org.example.model.robot.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepo extends CrudRepository<PositionEntity,Long> {
}
