package com.smartvehicle.models;

import com.smartvehicle.enums.VehicleType;
import com.smartvehicle.enums.VehicleStatus;
import com.smartvehicle.interfaces.Drivable;
import com.smartvehicle.interfaces.Maintainable;

public abstract class Vehicle implements Drivable, Maintainable {
    private static int counter = 1;

    private int id;
    private String make;
    private String model;
    private Engine engine;
    private int mileage;
    private VehicleStatus status;
    private VehicleType type;
    private Driver assignedDriver;

    public Vehicle(String make, String model, Engine engine, VehicleType type) {
        this.id = counter++;
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.type = type;
        this.mileage = 0;
        this.status = VehicleStatus.AVAILABLE;
    }

    public int getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public Engine getEngine() { return engine; }
    public int getMileage() { return mileage; }
    public void addMileage(int m) { this.mileage += m; }
    public VehicleStatus getStatus() { return status; }
    public void setStatus(VehicleStatus status) { this.status = status; }
    public VehicleType getType() { return type; }

    public Driver getAssignedDriver() { return assignedDriver; }
    public void setAssignedDriver(Driver driver) { this.assignedDriver = driver; }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Type: " + type);
        System.out.println("Mileage: " + mileage);
        System.out.println("Status: " + status);
        System.out.println("Engine: " + engine.getHorsepower() + " HP, " + engine.getType());
        System.out.println("Assigned Driver: " + (assignedDriver != null ? assignedDriver.getName() : "None"));
    }
}
