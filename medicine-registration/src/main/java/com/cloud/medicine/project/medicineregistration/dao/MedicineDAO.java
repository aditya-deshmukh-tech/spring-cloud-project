package com.cloud.medicine.project.medicineregistration.dao;

import com.cloud.medicine.project.medicineregistration.models.Medicine;
import com.cloud.medicine.project.medicineregistration.repo.RemoteRepoProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MedicineDAO {

    @Autowired
    private RemoteRepoProxy remoteRepoProxy;

    public List<Medicine> findAll() {
      return remoteRepoProxy.retriveAllMedicines();
    }

    public List<String> searchMedicinesByName(String medicine) {
       return remoteRepoProxy.retriveMedicineListByName(medicine);
    }

    public List<String> searchSymptomsByName(String symptom) {
        return remoteRepoProxy.retriveSymptomList(symptom);
    }

    public Medicine findMedicineByName(String medicine) {
       return remoteRepoProxy.retriveMedicine(medicine);
    }

    public List<Medicine> findAllMedicinesBySymptom(String symptom) {
        return remoteRepoProxy.retriveMedicinesForSymptom(symptom);
    }

    public Medicine addMedicine(Medicine medicine) {
       return remoteRepoProxy.registerMedicine(medicine);
    }

    public Medicine updateMedicine(Medicine medicine) {
        return remoteRepoProxy.updateMedicine(medicine);
    }

    public void deleteMedicine(String medicine) {
        remoteRepoProxy.deleteRemoteMedicine(medicine);
    }


}
