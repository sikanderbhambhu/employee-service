package com.employee.service.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.service.model.EmployeeVersion1;
import com.employee.service.model.EmployeeVersion2;
import com.employee.service.service.EmployeeServiceVersion1;
import com.employee.service.service.EmployeeServiceVersion2;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceVersion1 employeeServiceVersion1;
	
	@Autowired
	private EmployeeServiceVersion2 employeeServiceVersion2;
	
	@GetMapping("v1/employee/getEmployee")
    public EmployeeVersion1 getEmployeeVersion1(){
        return employeeServiceVersion1.retrieveEmployeeVersion1();
    }
	
	@GetMapping("v1/employee/getEmployees")
    public List<EmployeeVersion1> getAllEmployeesVersion1(){
        return employeeServiceVersion1.retrieveAllEmployeesVersion1();
    }
	
    @PostMapping(value = "v1/employee/createEmployee", produces = MediaType.APPLICATION_JSON_VALUE) //, params = "version=1")
    public ResponseEntity<EmployeeVersion1> createEmployeeVersion1(@RequestBody EmployeeVersion1 employee){
        EmployeeVersion1 newEmployee = employeeServiceVersion1.createEmployeeVersion1(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("EmpId", newEmployee.getEmpId()).build().toUri();
        return ResponseEntity.created(location).body(newEmployee);
    }

	@GetMapping("v2/employee/getEmployee")
    public EmployeeVersion2 getEmployeeVersion2(){
        return employeeServiceVersion2.retrieveEmployeeVersion2();
    }
    
	@GetMapping("v2/employee/getEmployees")
    public List<EmployeeVersion2> getAllEmployeesVersion2(){
        return employeeServiceVersion2.retrieveAllEmployeesVersion2();
    }

    @PostMapping(value = "v2/employee/createEmployee", produces = MediaType.APPLICATION_JSON_VALUE) //, params = "version=2")
    public ResponseEntity<EmployeeVersion2> createEmployeeVersion2(@RequestBody EmployeeVersion2 employee){
    	EmployeeVersion2 newEmployee = employeeServiceVersion2.createEmployeeVersion2(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("EmpId", newEmployee.getEmpId()).build().toUri();
        return ResponseEntity.created(location).body(newEmployee);
    }
}