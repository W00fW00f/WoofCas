package com.woof.cas.model;

import java.util.Objects;

public class VehicleData {

    public enum Direction {
        NONE,
        FORWARD,
        BACKWARD
    }

    private Position position;
    private Integer speed;
    private Direction direction;

    public VehicleData() {
        position = new Position();
        speed = 0;
        direction = Direction.NONE;
    }

    public VehicleData(Position position, Integer speed, Direction direction) {
        this.position = position;
        this.speed = speed;
        this.direction = direction;
    }

    public VehicleData(Position position, Integer speed, String direction) {
        this.position = position;
        this.speed = speed;
        this.direction = Direction.valueOf(direction.toUpperCase());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setDirection(String direction) {
        this.direction = Direction.valueOf(direction.toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleData that = (VehicleData) o;
        return Objects.equals(position, that.position) &&
                Objects.equals(speed, that.speed) &&
                direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, speed, direction);
    }

    @Override
    public String toString() {
        return "VehicleData{" +
                "position=" + position +
                ", speed=" + speed +
                ", direction=" + direction +
                '}';
    }
}
