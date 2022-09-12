package com.employee.service.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.service.model.Address;
import com.employee.service.model.EmployeeVersion2;

@Component
public class EmployeeServiceVersion2 {
	private static ArrayList<EmployeeVersion2> listOfEmployees = new ArrayList<>();
	private static EmployeeVersion2 employeeDetails;
	
	static {
		Address addressFroEmp1 = new Address("15 Foreshore Road", "Philadelphia", "PA", 19101);
		Address addressFroEmp2 = new Address("25 Market Street", "Philadelphia", "PA", 19101);
		EmployeeVersion2 employee1 = new EmployeeVersion2(101007, "John Smart", "1624958216", Arrays.asList(addressFroEmp1), "QA Manager", "Mike Nebula", "09:00 AM", "D1243879");
		EmployeeVersion2 employee2 = new EmployeeVersion2(101008, "Simon Dumb", "1313549658", Arrays.asList(addressFroEmp2), "Automation Lead", "Mike Nebula", "08:30 AM", "D1243879");
		listOfEmployees.addAll(Arrays.asList(employee1, employee2));
		employeeDetails = new EmployeeVersion2(101007, "John Smart", "1624958216", Arrays.asList(addressFroEmp1), "QA Manager", "Mike Nebula", "09:00 AM", "D1243879");
	}

	public EmployeeVersion2 createEmployeeVersion2(EmployeeVersion2 employee) {
		int employeeId = (int) (Math.floor(Math.random() * (9 * Math.pow(10, 3))) + Math.pow(10, 3));
		employee.setEmpId(employeeId);
		listOfEmployees.add(employee);
		return employee;
	}

	public EmployeeVersion2 retrieveEmployeeVersion2() {
		return employeeDetails;
	}

	public List<EmployeeVersion2> retrieveAllEmployeesVersion2() {
		return listOfEmployees;
	}
}
