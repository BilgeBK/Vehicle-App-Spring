package com.bilge.VehicleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VehicleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleAppApplication.class, args);
	}

}
