package com.woof.cas.storage;

import com.woof.cas.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleStorage {

    private List<Vehicle> vehicles;

    public VehicleStorage() {
        vehicles = new ArrayList<>();
    }

    synchronized public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    synchronized public Vehicle findVehicleByVin(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().compareTo(vin) == 0) {
                return vehicle;
            }
        }

        return null;
    }

}
