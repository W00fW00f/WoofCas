package com.woof.cas.generator;

import com.snatik.polygon.Point;
import com.woof.cas.model.Intersection;
import com.woof.cas.model.Lane;
import com.woof.cas.model.WorldMap;

import java.util.Arrays;

public class MapGenerator {

    public static WorldMap generateMap() {
        WorldMap map = new WorldMap();

        // generate lane0
        Lane lane0 = new Lane(
                0,
                Arrays.asList(
                        new Point(0, 4),
                        new Point(15, 4),
                        new Point(15, 5),
                        new Point(0, 5)
                )
        );
        map.addLane(lane0);

        // generate lane1
        Lane lane1 = new Lane(
                1,
                Arrays.asList(
                        new Point(0, 5),
                        new Point(15, 5),
                        new Point(15, 6),
                        new Point(0, 6)
                )
        );
        map.addLane(lane1);

        // generate lane2
        Lane lane2 = new Lane(
                2,
                Arrays.asList(
                        new Point(17, 4),
                        new Point(32, 4),
                        new Point(32, 30),
                        new Point(31, 30),
                        new Point(31, 5),
                        new Point(17, 5)
                )
        );
        map.addLane(lane2);

        // generate lane3
        Lane lane3 = new Lane(
                3,
                Arrays.asList(
                        new Point(17, 5),
                        new Point(31, 5),
                        new Point(31, 30),
                        new Point(30, 30),
                        new Point(30, 6),
                        new Point(17, 6)
                )
        );
        map.addLane(lane3);

        // generate lane4
        Lane lane4 = new Lane(
                4,
                Arrays.asList(
                        new Point(16, 6),
                        new Point(17, 6),
                        new Point(17, 15),
                        new Point(16, 15)
                )
        );
        map.addLane(lane4);

        // generate lane5
        Lane lane5 = new Lane(
                5,
                Arrays.asList(
                        new Point(15, 6),
                        new Point(16, 6),
                        new Point(16, 15),
                        new Point(15, 15)
                )
        );
        map.addLane(lane5);

        // generate lane6
        Lane lane6 = new Lane(
                6,
                Arrays.asList(
                        new Point(16, 16),
                        new Point(17, 16),
                        new Point(17, 30),
                        new Point(16, 30)
                )
        );
        map.addLane(lane6);

        // generate lane7
        Lane lane7 = new Lane(
                7,
                Arrays.asList(
                        new Point(15, 16),
                        new Point(16, 16),
                        new Point(16, 30),
                        new Point(15, 30)
                )
        );
        map.addLane(lane7);

        // generate lane8
        Lane lane8 = new Lane(
                8,
                Arrays.asList(
                        new Point(0, 15),
                        new Point(15, 15),
                        new Point(15, 16),
                        new Point(0, 16)
                )
        );
        map.addLane(lane8);

        // generate lane9
        Lane lane9 = new Lane(
                9,
                Arrays.asList(
                        new Point(15, 0),
                        new Point(16, 0),
                        new Point(16, 4),
                        new Point(15, 4)
                )
        );
        map.addLane(lane9);

        // generate lane10
        Lane lane10 = new Lane(
                10,
                Arrays.asList(
                        new Point(16, 0),
                        new Point(17, 0),
                        new Point(17, 4),
                        new Point(16, 4)
                )
        );
        map.addLane(lane10);

        // generate intersection0
        map.addIntersection(new Intersection(
                0,
                Arrays.asList(
                        new Point(15, 4),
                        new Point(17, 4),
                        new Point(17, 6),
                        new Point(15, 6)
                ),
                Arrays.asList(
                    lane0, lane1, lane2, lane3, lane4, lane5, lane9, lane10
                )
        ));

        // generate intersection1
        map.addIntersection(new Intersection(
                1,
                Arrays.asList(
                        new Point(15, 15),
                        new Point(17, 15),
                        new Point(17, 16),
                        new Point(15, 16)
                ),
                Arrays.asList(
                        lane4, lane5, lane6, lane7, lane8
                )
        ));

        return map;
    }

}
