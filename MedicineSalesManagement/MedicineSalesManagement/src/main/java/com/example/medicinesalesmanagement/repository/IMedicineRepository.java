package com.example.medicinesalesmanagement.repository;

import com.example.medicinesalesmanagement.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine,Integer> {
    List<Medicine> findMedicineByNameContaining(String name);
}
