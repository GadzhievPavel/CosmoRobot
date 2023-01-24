package org.example.entity;

import org.example.model.world.Position;
import org.example.model.world.util.WorldSideUtil;

import javax.persistence.*;

@Entity
@Table(name="positions")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "x")
    private int x;
    @Column(name = "y")
    private int y;
    @Column(name = "id_world_side")
    private short worldSide;

    public PositionEntity(){

    }

    public PositionEntity(Position position){
        setX(position.getPoint().getX());
        setY(position.getPoint().getY());
        setWorldSide((short) WorldSideUtil.getWorldSide(position.getWorldSide()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public short getWorldSide() {
        return worldSide;
    }

    public void setWorldSide(short worldSide) {
        this.worldSide = worldSide;
    }
}
