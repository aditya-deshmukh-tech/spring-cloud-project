package com.cloud.medicine.project.medicineregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MedicineRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineRegistrationApplication.class, args);
	}

}
