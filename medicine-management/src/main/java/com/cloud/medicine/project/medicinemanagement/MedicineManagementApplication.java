package com.cloud.medicine.project.medicinemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MedicineManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineManagementApplication.class, args);
	}

}
