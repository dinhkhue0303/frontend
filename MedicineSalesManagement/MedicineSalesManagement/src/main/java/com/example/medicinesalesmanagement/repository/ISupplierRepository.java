package com.example.medicinesalesmanagement.repository;
import com.example.medicinesalesmanagement.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISupplierRepository extends JpaRepository<Supplier,Integer> {
    List<Supplier> findSupplierByNameContaining(String name);
}
