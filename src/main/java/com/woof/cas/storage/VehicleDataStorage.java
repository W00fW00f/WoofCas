package com.woof.cas.storage;

import com.woof.cas.model.Intersection;
import com.woof.cas.model.VehicleData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleDataStorage {

    private Map<String, VehicleData> vehiclesData;
    private Map<String, Intersection> vehicleClosestIntersection;

    public VehicleDataStorage() {
        vehiclesData = new HashMap<>();
        vehicleClosestIntersection = new HashMap<>();
    }

    synchronized public void updateVehicleData(String vin, VehicleData vehicleData) {
        vehiclesData.put(vin, vehicleData);
    }

    synchronized public void updateVehicleClosestIntersection(String vin, Intersection intersection) {
        vehicleClosestIntersection.put(vin, intersection);
    }

    synchronized public VehicleData getLatestVehicleDataFor(String vin) {
        return vehiclesData.get(vin);
    }

    synchronized public List<String> getClosestVehiclesTo(Intersection intersection) {
        List<String> vehicles = new ArrayList<>();

        for (Map.Entry<String, Intersection> entry : vehicleClosestIntersection.entrySet()) {
            if (entry.getValue().equals(intersection)) {
                vehicles.add(entry.getKey());
            }
        }

        return vehicles;
    }
}
