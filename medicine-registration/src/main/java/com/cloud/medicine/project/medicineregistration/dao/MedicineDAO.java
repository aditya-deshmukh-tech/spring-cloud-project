package com.cloud.medicine.project.medicineregistration.dao;

import com.cloud.medicine.project.medicineregistration.models.Medicine;
import com.cloud.medicine.project.medicineregistration.models.Symptom;
import com.cloud.medicine.project.medicineregistration.repo.CachedMedicineRepo;
import com.cloud.medicine.project.medicineregistration.repo.CachedSymptomRepo;
import com.cloud.medicine.project.medicineregistration.repo.RemoteRepoProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MedicineDAO {

    @Autowired
    private RemoteRepoProxy remoteRepoProxy;

    @Autowired
    private CachedMedicineRepo cachedMedicineRepo;

    @Autowired
    private CachedSymptomRepo cachedSymptomRepo;

    @CircuitBreaker(name = "default", fallbackMethod = "cachedResponse")
    public List<Medicine> findAll() {
        List<Medicine> medicines = cachedMedicineRepo.findAll();
      /*  if (medicines.size() == 0) {
            medicines = remoteRepoProxy.retriveAllMedicines();
        }*/
        return medicines;
    }

    public List<String> searchMedicinesByName(String medicine) {
        List<String> medicineNames = cachedMedicineRepo.findMedicinesByName(medicine);
  /*      if (medicineNames.size() == 0) {
            medicineNames = remoteRepoProxy.retriveMedicineListByName(medicine);
        }*/
        return medicineNames;
    }

    public List<String> searchSymptomsByName(String symptom) {
        List<String> symptoms = cachedSymptomRepo.findSymptomsByName(symptom);
        return symptoms;
    }

    public Medicine findMedicineByName(String medicine) {
        Optional<Medicine> medicine1 = cachedMedicineRepo.findById(medicine);
     /*   if (medicine1.isEmpty()) {
            medicine1 = Optional.ofNullable(remoteRepoProxy.retriveMedicine(medicine));
        }*/
        return medicine1.get();
    }

    public List<Medicine> findAllMedicinesBySymptom(String symptom) {
        Symptom symptom1 = cachedSymptomRepo.findMedicinesByName(symptom);
        //return remoteRepoProxy.retriveMedicinesForSymptom(symptom);
        List<Medicine> medicines = symptom1.getMedicines();
        return medicines;
    }

    public Medicine addMedicine(Medicine medicine) {
       // Medicine medicine1 = remoteRepoProxy.registerMedicine(medicine);
        Medicine medicine1 = cachedMedicineRepo.save(medicine);
        return medicine1;
    }

    public Medicine updateMedicine(Medicine medicine) {
        //Medicine medicine1 = remoteRepoProxy.updateMedicine(medicine);
        Medicine medicine1 = cachedMedicineRepo.save(medicine);
        return medicine1;
    }

    public void deleteMedicine(String medicine) {
        cachedMedicineRepo.deleteById(medicine);
    }

    public List<Medicine> cachedResponse(Exception ex) {
        Symptom symptom = new Symptom();
        symptom.setName("Not available");
        Medicine fallBackMedicine = new Medicine();
        fallBackMedicine.setName("Not available");
        fallBackMedicine.setInfo("Not available");
        fallBackMedicine.setMoreInfo("Not available");
        fallBackMedicine.setSymptoms(Arrays.asList(symptom));
        return Arrays.asList(fallBackMedicine);
    }
}
