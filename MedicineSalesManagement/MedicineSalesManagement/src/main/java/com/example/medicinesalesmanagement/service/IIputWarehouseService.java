package com.example.medicinesalesmanagement.service;

import com.example.medicinesalesmanagement.model.InputWarehouse;

import java.time.LocalDateTime;
import java.util.List;

public interface IIputWarehouseService {
    List<InputWarehouse> findAll(String nameSupplier,String nameMedicine);
    List<InputWarehouse> findAll();
    void save(InputWarehouse inputWarehouse);
    InputWarehouse findById(Integer id);
    void delete(Integer id);
}
