package com.cloud.medicine.project.medicinemanagement.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medicine {

    @Id
    @Column(name = "med_name")
    private String name;
    private String info;
    private String moreInfo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "med_symptom",
            joinColumns = @JoinColumn(name = "med_name"),
            inverseJoinColumns = @JoinColumn(name = "symptom_name")
    )
    private List<Symptom> symptoms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}
