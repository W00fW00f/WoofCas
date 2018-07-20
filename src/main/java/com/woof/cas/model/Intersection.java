package com.woof.cas.model;

import com.snatik.polygon.Line;
import com.snatik.polygon.Point;
import com.snatik.polygon.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    private Integer id;
    private Polygon polyline;
    private List<Lane> lanes;

    public Intersection() {
        id = 0;
        polyline = Polygon.Builder().build();
        lanes = new ArrayList<>();
    }

    public Intersection(Integer id, List<Point> points, List<Lane> lanes) {
        this.id = id;
        this.lanes = lanes;

        Polygon.Builder polygonBuilder = Polygon.Builder();

        for (Point point : points) {
            polygonBuilder.addVertex(point);
        }

        polyline = polygonBuilder.build();
    }

    public Integer getId() {
        return id;
    }

    public boolean contains(Point point) {
        List<Line> sides = polyline.getSides();

        for (Line side : sides) {
            if (side.isInside(point)) {
                return true;
            }
        }

        return polyline.contains(point);
    }

    public boolean intersectsLane(Lane lane) {
        return lanes.contains(lane);
    }

    public double distanceTo(Point point) {
        double distance = Double.MAX_VALUE;

        for (Line line : polyline.getSides()) {
            double d = distance(line.getStart(), point);
            if (d < distance) {
                distance = d;
            }
        }

        return distance;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
