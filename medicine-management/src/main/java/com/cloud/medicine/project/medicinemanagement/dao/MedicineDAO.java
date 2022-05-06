package com.cloud.medicine.project.medicinemanagement.dao;

import com.cloud.medicine.project.medicinemanagement.models.Medicine;
import com.cloud.medicine.project.medicinemanagement.models.Symptom;
import com.cloud.medicine.project.medicinemanagement.repository.MedicineRepo;
import com.cloud.medicine.project.medicinemanagement.repository.SymptomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicineDAO {

    @Autowired
    private MedicineRepo medicineRepo;

    @Autowired
    private SymptomRepo symptomRepo;

    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }

    public List<String> searchMedicinesByName(String medicine) {
       return medicineRepo.findMedicinesByName(medicine);
    }

    public List<String> searchSymptomsByName(String symptom) {
        return symptomRepo.findSymptomsByName(symptom);
    }

    public Medicine findMedicineByName(String medicine) {
        return medicineRepo.findById(medicine).get();
    }

    public List<Medicine> findAllMedicinesBySymptom(String symptom) {
        Symptom symptom1 = symptomRepo.findMedicinesByName(symptom);
        List<Medicine> medicines = symptom1.getMedicines();
        return medicines;
    }

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    public Medicine updateMedicine(Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    public void deleteMedicine(String medicine) {
        medicineRepo.deleteById(medicine);
    }

}
