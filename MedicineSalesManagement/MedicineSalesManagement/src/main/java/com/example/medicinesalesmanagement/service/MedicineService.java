package com.example.medicinesalesmanagement.service;

import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.repository.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineService implements IMedicineService{
    @Autowired
    IMedicineRepository iMedicineRepository;
    @Override
    public List<Medicine> findMedicineByNameContaining(String name) {
        return iMedicineRepository.findMedicineByNameContaining(name);
    }

    @Override
    public List<Medicine> findAll() {
        return iMedicineRepository.findAll();
    }

    @Override
    public void save(Medicine medicine) {
        iMedicineRepository.save(medicine);
    }

    @Override
    public Medicine findById(Integer id) {
        return iMedicineRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iMedicineRepository.deleteById(id);
    }
}
