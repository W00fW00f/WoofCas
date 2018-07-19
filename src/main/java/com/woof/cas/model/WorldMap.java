package com.woof.cas.model;

import java.util.ArrayList;
import java.util.List;

public class WorldMap {

    private List<Lane> lanes;
    private List<Intersection> intersections;

    public WorldMap() {
        lanes = new ArrayList<>();
        intersections = new ArrayList<>();
    }

    public void addLane(Lane lane) {
        lanes.add(lane);
    }

    public List<Lane> getLanes() {
        return lanes;
    }

    public void addIntersection(Intersection intersection) {
        intersections.add(intersection);
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }

}
