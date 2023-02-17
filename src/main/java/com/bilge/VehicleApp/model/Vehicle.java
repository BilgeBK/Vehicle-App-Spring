package com.bilge.VehicleApp.model;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("vehicles")
@ToString
public class Vehicle {

    @Id
    private String vehicleId;
    private String licensePlate;
    private String color;
    private String brand;
    private String model;
    private String information;
    private List<String> date;
    private int countPasses;



    public Vehicle(String licensePlate, String color, String brand, String model, String information, List<String> date,int countPasses){

        this.licensePlate = licensePlate;
        this.color = color;
        this.brand = brand;
        this.model= model;
        this.information = information;
        this.date = date;
        this.countPasses = countPasses;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getCountPasses() {
        return countPasses;
    }

    public void setCountPasses(int countPasses) {
        this.countPasses = countPasses;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }
}
