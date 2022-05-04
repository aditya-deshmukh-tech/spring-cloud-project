package com.cloud.medicine.project.medicineregistration.repo;

import com.cloud.medicine.project.medicineregistration.models.Medicine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "medicine-management", url = "localhost:8002")
public interface RemoteRepoProxy {

    @GetMapping("/medicine-management/medicine/all")
    public List<Medicine> retriveAllMedicines();

    @GetMapping("/medicine-management/symptom/{symptom}")
    public List<String> retriveSymptomList(@PathVariable String symptom);

    @GetMapping("/medicine-management/medicine/match/{medicine}")
    public List<String> retriveMedicineListByName(@PathVariable String medicine);

    @GetMapping("/medicine-management/symptom/medicine/{symptom}")
    public List<Medicine> retriveMedicinesForSymptom(@PathVariable String symptom);

    @GetMapping("/medicine-management/medicine/{medicine}")
    public Medicine retriveMedicine(@PathVariable String medicine);

    @PostMapping("/medicine-management/medicine/register")
    public Medicine registerMedicine(@RequestBody Medicine medicine);

    @PutMapping("/medicine-management/medicine/update")
    public Medicine updateMedicine(@RequestBody Medicine medicine);

    @DeleteMapping("/medicine-management/medicine/delete/{medicine}")
    public void deleteRemoteMedicine(@PathVariable String medicine);
}
