package com.woof.cas.model;

import java.util.Objects;

public class Vehicle {

    private String vin;
    private String serviceAddress;

    public Vehicle() {
        vin = "";
        serviceAddress = "";
    }

    public Vehicle(String vin, String serviceAddress) {
        this.vin = vin;
        this.serviceAddress = serviceAddress;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin) &&
                Objects.equals(serviceAddress, vehicle.serviceAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, serviceAddress);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", serviceAddress='" + serviceAddress + '\'' +
                '}';
    }
}
