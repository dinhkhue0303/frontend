package com.example.medicinesalesmanagement.controller;
import com.example.medicinesalesmanagement.model.InputWarehouse;
import com.example.medicinesalesmanagement.service.IIputWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/inputWarehouse")
public class InputWarehouseController {
    @Autowired
    IIputWarehouseService iIputWarehouseService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<InputWarehouse>> findAll(@RequestParam String nameSupplier,
                                                        @RequestParam String nameMedicine){
        System.out.println(nameSupplier);
        System.out.println(nameMedicine);
        List<InputWarehouse> inputWarehouseList = iIputWarehouseService.findAll(nameSupplier,nameMedicine);
        if(inputWarehouseList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inputWarehouseList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<InputWarehouse>> findAll(){
        List<InputWarehouse> inputWarehouseList = iIputWarehouseService.findAll();
        if(inputWarehouseList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inputWarehouseList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<InputWarehouse> create(@RequestBody InputWarehouse inputWarehouse){
        if(inputWarehouse == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iIputWarehouseService.save(inputWarehouse);
        return new ResponseEntity<>(inputWarehouse,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InputWarehouse> detail(@PathVariable Integer id){
        InputWarehouse inputWarehouse = iIputWarehouseService.findById(id);
        if (inputWarehouse == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inputWarehouse,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InputWarehouse> update(@PathVariable Integer id, @RequestBody InputWarehouse inputWarehouse){
        InputWarehouse inputWarehouse1 = iIputWarehouseService.findById(id);
        if(inputWarehouse1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iIputWarehouseService.save(inputWarehouse);
        return new ResponseEntity<>(inputWarehouse,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<InputWarehouse> delete(@PathVariable Integer id){
        InputWarehouse inputWarehouse = iIputWarehouseService.findById(id);
        if(inputWarehouse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iIputWarehouseService.delete(id);
        return new ResponseEntity<>(inputWarehouse,HttpStatus.NO_CONTENT);
    }
}
