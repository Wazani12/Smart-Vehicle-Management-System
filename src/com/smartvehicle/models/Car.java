package com.smartvehicle.models;

import com.smartvehicle.enums.VehicleType;
import com.smartvehicle.enums.VehicleStatus;

public class Car extends Vehicle {
    private int seats;
    private boolean airConditioned;

    public Car(String make, String model, Engine engine, int seats, boolean airConditioned) {
        super(make, model, engine, VehicleType.CAR);
        this.seats = seats;
        this.airConditioned = airConditioned;
    }

    public int getSeats() {
        return seats;
    }

    public boolean hasAirCondition() {
        return airConditioned;
    }

    @Override
    public void start() {
        System.out.println("Car " + getMake() + " started.");
        setStatus(VehicleStatus.IN_USE);
    }

    @Override
    public void stop() {
        System.out.println("Car " + getMake() + " stopped.");
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
