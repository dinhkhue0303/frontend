package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    IMedicineService iMedicineService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<Medicine>> findAll(@RequestParam String name){
        List<Medicine> medicineList = iMedicineService.findMedicineByNameContaining(name);
        if(medicineList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Medicine>> findAll(){
        List<Medicine> medicineList = iMedicineService.findAll();
        if(medicineList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Medicine> create(@RequestBody Medicine medicine){
        if(medicine == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iMedicineService.save(medicine);
        return new ResponseEntity<>(medicine,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> detail(@PathVariable Integer id){
        Medicine medicine = iMedicineService.findById(id);
        if (medicine == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicine,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> update(@PathVariable Integer id, @RequestBody Medicine medicine){
        Medicine medicine1 = iMedicineService.findById(id);
        if(medicine1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iMedicineService.save(medicine);
        return new ResponseEntity<>(medicine,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Medicine> delete(@PathVariable Integer id){
        Medicine medicine = iMedicineService.findById(id);
        if(medicine == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iMedicineService.delete(id);
        return new ResponseEntity<>(medicine,HttpStatus.NO_CONTENT);
    }
}
