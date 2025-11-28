package com.smartvehicle.models;

import com.smartvehicle.enums.VehicleType;
import com.smartvehicle.enums.VehicleStatus;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private int engineCapacity;

    public Motorcycle(String make, String model, Engine engine, boolean hasSidecar, int engineCapacity) {
        super(make, model, engine, VehicleType.MOTORCYCLE);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle " + getMake() + " started.");
        setStatus(VehicleStatus.IN_USE);
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle " + getMake() + " stopped.");
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
