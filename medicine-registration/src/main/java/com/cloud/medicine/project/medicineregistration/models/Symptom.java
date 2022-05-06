package com.cloud.medicine.project.medicineregistration.models;

import java.util.List;

public class Symptom {

    private String name;

    private List<Medicine> medicines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
