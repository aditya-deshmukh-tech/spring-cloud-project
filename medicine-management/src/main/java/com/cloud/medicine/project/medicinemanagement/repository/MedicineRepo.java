package com.cloud.medicine.project.medicinemanagement.repository;

import com.cloud.medicine.project.medicinemanagement.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, String> {

    @Query(value = "SELECT med_name FROM Medicine WHERE med_name LIKE %?1%", nativeQuery = true)
    public List<String> findMedicinesByName(String name);
}
