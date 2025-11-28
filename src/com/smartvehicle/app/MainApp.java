package com.smartvehicle.app;

import com.smartvehicle.models.*;
import com.smartvehicle.managers.*;
import com.smartvehicle.enums.*;
import com.smartvehicle.exceptions.*;

public class MainApp {
    public static void main(String[] args) {
        // Engines
        Engine engine1 = new Engine(120, EngineType.PETROL);
        Engine engine2 = new Engine(250, EngineType.DIESEL);
        Engine engine3 = new Engine(60, EngineType.ELECTRIC);

        // Vehicles
        Car car1 = new Car("Toyota", "Corolla", engine1, 5, true);
        Truck truck1 = new Truck("Volvo", "FH", engine2, 15, true);
        Motorcycle moto1 = new Motorcycle("Yamaha", "MT-07", engine3, false, 689);

        // FleetManager
        FleetManager fleet = new FleetManager();
        fleet.addVehicle(car1);
        fleet.addVehicle(truck1);
        fleet.addVehicle(moto1);

        // Drivers
        Driver driver1 = new Driver("D001", "Alice", DriverLicense.B, "555-111");
        Driver driver2 = new Driver("D002", "Bob", DriverLicense.C, "555-222");
        Driver driver3 = new Driver("D003", "Charlie", DriverLicense.A, "555-333");

        fleet.addDriver(driver1);
        fleet.addDriver(driver2);
        fleet.addDriver(driver3);

        try {
            fleet.assignDriverToVehicle(car1.getId(), driver1.getId());
            fleet.assignDriverToVehicle(truck1.getId(), driver2.getId());
            fleet.assignDriverToVehicle(moto1.getId(), driver3.getId());
        } catch (Exception e) { System.out.println(e.getMessage()); }

        try {
            fleet.startVehicle(car1.getId());
            car1.addMileage(120);
            fleet.stopVehicle(car1.getId());
        } catch (Exception e) { System.out.println(e.getMessage()); }

        try {
            fleet.performMaintenanceOnVehicle(truck1.getId());
        } catch (Exception e) { System.out.println(e.getMessage()); }

        System.out.println("\n--- All Vehicles ---");
        for (Vehicle v : fleet.listAllVehicles()) {
            v.displayInfo();
            System.out.println("---------------------");
        }

        System.out.println("\n--- Vehicles Needing Maintenance ---");
        for (Vehicle v : fleet.listVehiclesNeedingMaintenance())
            System.out.println("Vehicle ID: " + v.getId() + " | Mileage: " + v.getMileage());
    }
}
