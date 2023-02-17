package com.bilge.VehicleApp.service;

import com.bilge.VehicleApp.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> allVehicle();
    Vehicle addVehicle(Vehicle vehicle);
    String deleteVehicle(String vehicleId);
    Vehicle updateVehicle(String vehicleId, Vehicle vehicle);
    List<Vehicle> searchVehicle(String licensePlate);
    Vehicle viewVehicle(String vehicleId);
    Integer countPasses(String vehicleId);
    List<Vehicle> noLPlateVehicles();
}
