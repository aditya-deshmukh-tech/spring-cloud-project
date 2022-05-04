package com.cloud.medicine.project.medicineregistration.repo;

import com.cloud.medicine.project.medicineregistration.models.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CachedSymptomRepo extends JpaRepository<Symptom, String> {

    @Query(value = "SELECT symptom_name FROM Symptom WHERE symptom_name LIKE %?1%", nativeQuery = true)
    public List<String> findSymptomsByName(String symptom);

    public Symptom findMedicinesByName(String symptom);

}
