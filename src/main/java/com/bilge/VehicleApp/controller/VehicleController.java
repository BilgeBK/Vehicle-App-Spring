package com.bilge.VehicleApp.controller;

import com.bilge.VehicleApp.model.Vehicle;
import com.bilge.VehicleApp.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class VehicleController {

    private VehicleServiceImpl vehicleService;

    @Autowired
    VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @RequestMapping({"/vehicles","/vehicles/index.html"})
    public String index(Model model){
        model.addAttribute("vehicles",vehicleService.allVehicle());
        return "vehicles/index";
    }
    @RequestMapping({"/vehicles/noLPlate"})
    public String noLPlate(Model model){
        model.addAttribute("vehicles",vehicleService.noLPlateVehicles());
        return "vehicles/noLPlateIndex" +
                "";
    }
    @RequestMapping(value = "/addVehicle", method = RequestMethod.GET)
    public String addVehicleIndex(){
        return "vehicles/addVehicle";
    }

    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
    public String addVehicle(@RequestParam String licensePlate, @RequestParam  String color, @RequestParam  String brand, @RequestParam String model, @RequestParam  String information, Model mdl, @RequestParam String vehicleDate){
        List<String> date = new ArrayList<>();
        date.add(vehicleDate);
        Vehicle vehicle = new Vehicle(licensePlate,color,brand,model,information,date,1);
        vehicleService.addVehicle(vehicle);
        System.out.println("Eklendi");
        System.out.println("Tarih:"+vehicleDate);

        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/updateVehicle/{id}",method = RequestMethod.GET)
    public String updateViewVehicle(@PathVariable String id, Model model){
        model.addAttribute("vehicle",vehicleService.viewVehicle(id));
        return "vehicles/updateViewVehicle";
    }

    @RequestMapping(value = "/updateVehicle/{id}",method = RequestMethod.POST)
    public String updateVehicle(@PathVariable String id,@RequestParam String licensePlate,@RequestParam  String color,@RequestParam  String brand, @RequestParam String model, @RequestParam  String information,Model mdl,@RequestParam String vehicleDate){
        List<String> date = new ArrayList<>();
        date.add(vehicleDate);
        int count = vehicleService.countPasses(id);
        System.out.println("count sayısı"+count);
        Vehicle vehicle = new Vehicle(licensePlate,color,brand,model,information,date,count);
        vehicleService.updateVehicle(id,vehicle);
        System.out.println("Güncellendi");
        return "redirect:/vehicles";
    }
    @RequestMapping(value ="/vehicle/{id}",method = RequestMethod.GET)
    public String viewVehicle(@PathVariable String id, Model model){
        var dateChange = vehicleService.viewVehicle(id).getDate().toString().replace("]"," ");
        var dateChange1 = vehicleService.viewVehicle(id).getDate().toString().replace("["," ");
        var dateChange2 = vehicleService.viewVehicle(id).getDate().toString().replace(",","\n");
        model.addAttribute("vehicle",vehicleService.viewVehicle(id));
        return "vehicles/viewVehicle";
    }

    @RequestMapping(value="/deleteVehicle/{id}",method = RequestMethod.POST)
    public String deleteVehicle(@PathVariable String id, Model model){
        model.addAttribute("vehicles",vehicleService.deleteVehicle(id));

        return "redirect:/vehicles";
    }
    @RequestMapping(value = "/vehicles",method = RequestMethod.POST)
    public String searchVehicle(@RequestParam String searchVehicle,Model model){
        if (vehicleService.searchVehicle(searchVehicle).size() !=0){
            model.addAttribute("vehicles",vehicleService.searchVehicle(searchVehicle));
            return "/vehicles/index";
        }
        return "not found";
    }
}
