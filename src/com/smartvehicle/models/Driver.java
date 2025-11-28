package com.smartvehicle.models;

import com.smartvehicle.enums.DriverLicense;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String id;
    private String name;
    private DriverLicense license;
    private String phone;
    private List<Integer> assignedVehicles;

    public Driver(String id, String name, DriverLicense license, String phone) {
        this.id = id;
        this.name = name;
        this.license = license;
        this.phone = phone;
        this.assignedVehicles = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public DriverLicense getLicense() { return license; }
    public String getPhone() { return phone; }
    public List<Integer> getAssignedVehicles() { return assignedVehicles; }

    public void assignVehicle(int vehicleId) {
        assignedVehicles.add(vehicleId);
    }

    public void detachVehicle(int vehicleId) {
        assignedVehicles.remove((Integer) vehicleId);
    }
}
