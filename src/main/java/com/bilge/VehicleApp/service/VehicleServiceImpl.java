package com.bilge.VehicleApp.service;

import com.bilge.VehicleApp.model.Vehicle;
import com.bilge.VehicleApp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    private VehicleRepository vehicleRepository;

    @Autowired
    VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> allVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }

    @Override
    public String deleteVehicle(String vehicleId) {
        try{
            var findVehicle = vehicleRepository.findById(vehicleId);
            vehicleRepository.delete(findVehicle.get());

            return "success";
        }catch (Exception ex){
            return ex.getMessage();
        }

    }

    @Override
    public Vehicle updateVehicle(String vehicleId, Vehicle vehicle) {

            var findVehicle = vehicleRepository.findById(vehicleId);
            findVehicle.get().setLicensePlate(vehicle.getLicensePlate());
            findVehicle.get().setColor(vehicle.getColor());
            findVehicle.get().setBrand(vehicle.getBrand());
            findVehicle.get().setModel(vehicle.getModel());
            findVehicle.get().setInformation(vehicle.getInformation());
            findVehicle.get().getDate().add(vehicle.getDate().toString());
            findVehicle.get().setCountPasses(countPasses(vehicleId));
            vehicleRepository.save(findVehicle.get());
            return findVehicle.get();


    }

    @Override
    public List<Vehicle> searchVehicle(String licensePlate) {
        List<Vehicle> findVehiclesList = new ArrayList<>();
        var allVehiclesList = vehicleRepository.findAll();
        if(licensePlate.equals("")){
            return allVehiclesList;
        }else{
        for (var vehicle : allVehiclesList){
            if (vehicle.getLicensePlate().equals(licensePlate)){
                findVehiclesList.add(vehicle);
            }
        }
        return findVehiclesList;
        }
    }

    @Override
    public Vehicle viewVehicle(String vehicleId) {
        var findVehicle = vehicleRepository.findById(vehicleId);
        return findVehicle.get();
    }

    @Override
    public Integer countPasses(String vehicleId) {
        var findVehicle = vehicleRepository.findById(vehicleId);
        return findVehicle.get().getDate().size()+1;
    }

    @Override
    public List<Vehicle> noLPlateVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        var result = vehicleRepository.findAll();
        for (var element : result){
            if (element.getLicensePlate().equals("")){
                vehicleList.add(element);
            }
        }
        return vehicleList;
    }


}
