package com.smartvehicle.models;

import com.smartvehicle.enums.VehicleType;
import com.smartvehicle.enums.VehicleStatus;

public class Truck extends Vehicle {
    private int loadCapacity;
    private boolean trailerAttached;

    public Truck(String make, String model, Engine engine, int loadCapacity, boolean trailerAttached) {
        super(make, model, engine, VehicleType.TRUCK);
        this.loadCapacity = loadCapacity;
        this.trailerAttached = trailerAttached;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public boolean hasTrailer() {
        return trailerAttached;
    }

    @Override
    public void start() {
        System.out.println("Truck " + getMake() + " started.");
        setStatus(VehicleStatus.IN_USE);
    }

    @Override
    public void stop() {
        System.out.println("Truck " + getMake() + " stopped.");
        setStatus(VehicleStatus.AVAILABLE);
    }

    @Override
    public boolean isRunning() {
        return getStatus() == VehicleStatus.IN_USE;
    }

    @Override
    public void performMaintenance() {
        getEngine().setHealthy(true);
        setStatus(VehicleStatus.AVAILABLE);
    }

    @Override
    public boolean needsMaintenance() {
        return getMileage() > 10000 || !getEngine().isHealthy();
    }
}
