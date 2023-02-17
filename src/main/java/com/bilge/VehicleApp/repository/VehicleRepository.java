package com.bilge.VehicleApp.repository;

import com.bilge.VehicleApp.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {
}
