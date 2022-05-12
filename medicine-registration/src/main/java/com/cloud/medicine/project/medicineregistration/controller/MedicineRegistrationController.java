package com.cloud.medicine.project.medicineregistration.controller;

import com.cloud.medicine.project.medicineregistration.dao.MedicineDAO;
import com.cloud.medicine.project.medicineregistration.models.Medicine;
import com.cloud.medicine.project.medicineregistration.models.Symptom;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/medicine-registration")
public class MedicineRegistrationController {

    @Autowired
    private MedicineDAO medicineDAO;


    @GetMapping("/medicine/all")
    public List<Medicine> getAll() {
        return medicineDAO.findAll();
    }

    @GetMapping("/symptom/{symptom}")
    public List<String> listSymptoms(@PathVariable String symptom) {
        return medicineDAO.searchSymptomsByName(symptom);
    }

    @GetMapping("/medicine/match/{medicineName}")
    public List<String> listMedicineNames(@PathVariable String medicineName) {
        return medicineDAO.searchMedicinesByName(medicineName);
    }

    @GetMapping("/symptom/medicine/{symptom}")
    public List<Medicine> listMedicineBySymptom(@PathVariable String symptom) {
        return medicineDAO.findAllMedicinesBySymptom(symptom);
    }

    @GetMapping("/medicine/{medicine}")
    @CircuitBreaker(name = "default", fallbackMethod = "cachedResponse")
    public Medicine getSingleMedicine(@PathVariable String medicine) {
        return medicineDAO.findMedicineByName(medicine);
    }

    @PostMapping("/medicine/register")
    public Medicine registerMedicine(@RequestBody Medicine medicine) {
        return medicineDAO.addMedicine(medicine);
    }

    @PutMapping("/medicine/update")
    public Medicine updateMedicine(@RequestBody Medicine medicine) {
        return medicineDAO.updateMedicine(medicine);
    }

    @DeleteMapping("/medicine/delete/{medicine}")
    public ResponseEntity deleteMedicine(@PathVariable String medicine) {
        medicineDAO.deleteMedicine(medicine);
        return ResponseEntity.ok("deleted successfully");
    }

    public ResponseEntity cachedResponse(Exception ex) {
        Medicine medicine = new Medicine();
        medicine.setName("Not available");
        medicine.setInfo("Not available");
        medicine.setMoreInfo("Not available");
        medicine.setSymptoms(Arrays.asList(new Symptom()));
        List<Medicine> medicines = new ArrayList<>();
        if (ex.getMessage().contains("Connection refused")) {
            return ResponseEntity.ok(medicines);
        }
        return new ResponseEntity(ex, HttpStatus.valueOf("500"));
    }

}
