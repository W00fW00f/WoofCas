package com.woof.cas.algorithm;

import com.snatik.polygon.Point;
import com.woof.cas.generator.MapGenerator;
import com.woof.cas.model.*;
import com.woof.cas.storage.RuleStorage;
import com.woof.cas.storage.VehicleDataStorage;
import com.woof.cas.storage.VehicleStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectionAlgorithm {

    private WorldMap map;
    private VehicleDataStorage vehicleDataStorage;

    private VehicleStorage vehicleStorage;
    private RuleStorage ruleStorage;

    public DetectionAlgorithm(VehicleStorage vehicleStorage,
                              RuleStorage ruleStorage) {
        map = MapGenerator.generateMap();
        vehicleDataStorage = new VehicleDataStorage();

        this.vehicleStorage = vehicleStorage;
        this.ruleStorage = ruleStorage;
    }

    public void onNewVehicleData(String vin, VehicleData vehicleData) {
        // update vehicle's current position
        vehicleDataStorage.updateVehicleData(vin, vehicleData);

        // find the road on which the vehicle is
        Lane lane = findLaneByPosition(vehicleData.getPosition());

        // find the intersection that's closest to the road
        Intersection intersection = findClosestIntersection(lane, vehicleData.getPosition());
        vehicleDataStorage.updateVehicleClosestIntersection(vin, intersection);

        // find all vehicles that are close to the intersection
        List<String> vehicles = vehicleDataStorage.getClosestVehiclesTo(intersection);
        Map<String, Lane> vehicleLanes = getLaneForVehicles(vehicles);

        // compute priorities based on rules
        Rule currentRule = ruleStorage.getLatestRuleFor(intersection.getId());
        computeAlerts(vehicleLanes, currentRule);
    }

    private Lane findLaneByPosition(Position position) {
        List<Lane> lanes = map.getLanes();
        Point point = new Point(position.getLatitude(), position.getLongitude());

        for (Lane lane : lanes) {
            if (lane.contains(point)) {
                return lane;
            }
        }

        return null;
    }

    private Intersection findClosestIntersection(Lane lane, Position position) {
        List<Intersection> intersections = getLaneIntersections(lane);
        Point point = new Point(position.getLatitude(), position.getLongitude());

        // compute distance to the given intersections
        double minDistance = Double.MAX_VALUE;
        Intersection closestIntersection = null;

        for (Intersection intersection : intersections) {
            double d = intersection.distanceTo(point);
            if (d < minDistance) {
                minDistance = d;
                closestIntersection = intersection;
            }
        }

        return closestIntersection;
    }

    private List<Intersection> getLaneIntersections(Lane lane) {
        List<Intersection> intersections = new ArrayList<>();

        for (Intersection intersection : map.getIntersections()) {
            if (intersection.intersectsLane(lane)) {
                intersections.add(intersection);
            }
        }

        return intersections;
    }

    private Map<String, Lane> getLaneForVehicles(List<String> vehicles) {
        Map<String, Lane> vehicleLanes = new HashMap<>();

        for (String vehicle : vehicles) {
            VehicleData vehicleData = vehicleDataStorage.getLatestVehicleDataFor(vehicle);

            if (vehicleData != null) {
                Lane lane = findLaneByPosition(vehicleData.getPosition());
                vehicleLanes.put(vehicle, lane);
            }
        }

        return vehicleLanes;
    }

    private void computeAlerts(Map<String, Lane> vehicleLanes, Rule currentRule) {
        for (Map.Entry<String, Lane> entry1 : vehicleLanes.entrySet()) {
            for (Map.Entry<String, Lane> entry2 : vehicleLanes.entrySet()) {
                if (entry1 != entry2) {
                    Integer lane1 = entry1.getValue().getId();
                    Integer lane2 = entry2.getValue().getId();

                    for (RuleEntry ruleEntry : currentRule.getEntries()) {
                        if (ruleEntry.getHighPriorityRoad() == lane1 &&
                            ruleEntry.getLowPriorityRoad() == lane2) {
                            System.out.println("Car " + entry1.getKey() + " warn!");
                            System.out.println("Car " + entry2.getKey() + " stop!");
                        }
                    }
                }
            }
        }
    }
}
