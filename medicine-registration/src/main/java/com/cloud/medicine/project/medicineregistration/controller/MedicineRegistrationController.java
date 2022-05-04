package com.cloud.medicine.project.medicineregistration.controller;

import com.cloud.medicine.project.medicineregistration.dao.MedicineDAO;
import com.cloud.medicine.project.medicineregistration.models.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
