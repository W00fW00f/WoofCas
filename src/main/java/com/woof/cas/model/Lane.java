package com.woof.cas.model;

import com.snatik.polygon.Line;
import com.snatik.polygon.Point;
import com.snatik.polygon.Polygon;

import java.util.List;

public class Lane {

    private Integer id;
    private Polygon polyline;

    public Lane() {
        polyline = Polygon.Builder().build();
    }

    public Lane(Integer id, List<Point> points) {
        this.id = id;

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
}
