package com.smartvehicle.managers;

import com.smartvehicle.models.*;
import com.smartvehicle.enums.*;
import com.smartvehicle.exceptions.*;
import java.util.*;

public class FleetManager {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final Map<Integer, Vehicle> vehicleMap = new HashMap<>();
    private final List<Driver> drivers = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        vehicleMap.put(v.getId(), v);
    }

    public void removeVehicle(int id) throws VehicleNotFoundException {
        Vehicle v = findVehicleById(id);
        vehicles.remove(v);
        vehicleMap.remove(id);
    }

    public Vehicle findVehicleById(int id) throws VehicleNotFoundException {
        Vehicle v = vehicleMap.get(id);
        if (v == null) throw new VehicleNotFoundException("Vehicle with ID " + id + " not found!");
        return v;
    }

    public void addDriver(Driver d) { drivers.add(d); }

    public void assignDriverToVehicle(int vehicleId, String driverId)
            throws VehicleNotFoundException, InvalidDriverAssignmentException {
        Vehicle v = findVehicleById(vehicleId);
        Driver d = null;
        for (Driver driver : drivers) if (driver.getId().equals(driverId)) d = driver;
        if (d == null) throw new InvalidDriverAssignmentException("Driver not found");

        if ((v.getType() == VehicleType.MOTORCYCLE && d.getLicense() != DriverLicense.A)
                || (v.getType() == VehicleType.CAR && d.getLicense() != DriverLicense.B)
                || (v.getType() == VehicleType.TRUCK && d.getLicense() != DriverLicense.C))
            throw new InvalidDriverAssignmentException("Driver license not valid for this vehicle type");

        if (v.getAssignedDriver() != null)
            throw new InvalidDriverAssignmentException("Vehicle already has a driver assigned");

        v.setAssignedDriver(d);
        d.assignVehicle(v.getId());
    }

    public void detachDriverFromVehicle(int vehicleId) throws VehicleNotFoundException {
        Vehicle v = findVehicleById(vehicleId);
        Driver d = v.getAssignedDriver();
        if (d != null) {
            d.detachVehicle(vehicleId);
            v.setAssignedDriver(null);
        }
    }

    public void startVehicle(int vehicleId) throws VehicleNotFoundException, Exception {
        Vehicle v = findVehicleById(vehicleId);
        v.start();
    }

    public void stopVehicle(int vehicleId) throws VehicleNotFoundException {
        Vehicle v = findVehicleById(vehicleId);
        v.stop();
    }

    public void performMaintenanceOnVehicle(int vehicleId) throws VehicleNotFoundException {
        Vehicle v = findVehicleById(vehicleId);
        v.performMaintenance();
        System.out.println("Maintenance completed on vehicle ID " + vehicleId);
    }

    public List<Vehicle> listAllVehicles() { return new ArrayList<>(vehicles); }

    public List<Vehicle> listVehiclesNeedingMaintenance() {
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle v : vehicles) if (v.getMileage() > 10000 || !v.getEngine().isHealthy()) list.add(v);
        return list;
    }
}
