package com.cloud.medicine.project.medicineregistration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Symptom {

    @Id
    @Column(name = "symptom_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "symptoms")
    @JsonIgnore
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
