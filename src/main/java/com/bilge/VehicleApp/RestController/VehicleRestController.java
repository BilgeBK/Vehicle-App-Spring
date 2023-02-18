package com.bilge.VehicleApp.RestController;

import com.bilge.VehicleApp.model.Vehicle;
import com.bilge.VehicleApp.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleRestController {

    private VehicleServiceImpl vehicleService;

    @Autowired
    VehicleRestController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = "/vehicle/addVehicle")

    String addVehicle(@RequestBody Vehicle vehicle){
        if (vehicle != null){
            vehicleService.addVehicle(vehicle);
            return vehicle + "saved";
        }else{
            return "not save";
        }
    }

    @GetMapping(value = "/vehicle/allVehicles")
    List<Vehicle> getAllVehicles(){
        return vehicleService.allVehicle();
    }

    @GetMapping(value = "/vehicle/selectedVehicle{vehicle_id}")
    Vehicle getSelectedVehicle(@PathVariable String vehicle_id){
        return vehicleService.viewVehicle(vehicle_id);
    }

    @PutMapping(value = "/vehicle/updateVehicle{id}")
    String updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicle){
        if (id != null && vehicle != null){
            vehicleService.updateVehicle(id,vehicle);
            return vehicle + "updated";
        }else{
            return "not update";
        }
    }
}
