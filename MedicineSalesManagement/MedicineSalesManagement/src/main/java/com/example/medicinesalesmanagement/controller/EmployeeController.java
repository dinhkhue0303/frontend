package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<Employee>> findAll(@RequestParam String name){
        List<Employee> employeeList = iEmployeeService.findEmployeeByNameContaining(name);
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = iEmployeeService.findAll();
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iEmployeeService.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> detail(@PathVariable Integer id){
        Employee employee = iEmployeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee employee){
        Employee employee1 = iEmployeeService.findById(id);
        if(employee1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Integer id){
        Employee employee = iEmployeeService.findById(id);
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.delete(id);
        return new ResponseEntity<>(employee,HttpStatus.NO_CONTENT);
    }
}
