package com.example.medicinesalesmanagement.service;

import com.example.medicinesalesmanagement.model.InputWarehouse;
import com.example.medicinesalesmanagement.repository.IInputWarehouseResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InputWarehouseService implements IIputWarehouseService{
    @Autowired
    IInputWarehouseResponsitory iInputWarehouseResponsitory;
    @Override
    public List<InputWarehouse> findAll(String nameSupplier,String nameMedicine) {
        return iInputWarehouseResponsitory.findAll("%" + nameSupplier + "%", "%" + nameMedicine + "%");
    }

    @Override
    public List<InputWarehouse> findAll() {
        return iInputWarehouseResponsitory.findAll();
    }

    @Override
    public void save(InputWarehouse inputWarehouse) {
        iInputWarehouseResponsitory.save(inputWarehouse);
    }

    @Override
    public InputWarehouse findById(Integer id) {
        return iInputWarehouseResponsitory.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iInputWarehouseResponsitory.deleteById(id);
    }
}
