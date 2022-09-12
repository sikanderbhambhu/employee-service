package com.employee.service.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.service.model.Address;
import com.employee.service.model.EmployeeVersion1;

@Component
public class EmployeeServiceVersion1 {
	private static ArrayList<EmployeeVersion1> listOfEmployees = new ArrayList<>();
	private static EmployeeVersion1 employeeDetails;

	static {
		Address addressFroEmp1 = new Address("15 Foreshore Road", "Philadelphia", "PA", 19101);
		Address addressFroEmp2 = new Address("25 Market Street", "Philadelphia", "PA", 19101);

		 EmployeeVersion1 employee1 = new EmployeeVersion1(101007, "John Smart", "1624958216", Arrays.asList(addressFroEmp1), "QA Manager", "Mike Nebula", "09:00 AM");
		 EmployeeVersion1 employee2 = new EmployeeVersion1(101008, "Simon Dumb", "1313549658", Arrays.asList(addressFroEmp2), "Automation Lead", "Mike Nebula", "08:30 AM");
		
//		EmployeeVersion1 employee1 = new EmployeeVersion1(101007, "John Smart", "1624958216", Arrays.asList(addressFroEmp1), "QA Manager", "Mike Nebula", "09:00 AM", "9844563645");
//		EmployeeVersion1 employee2 = new EmployeeVersion1(101008, "Simon Dumb", "1313549658", Arrays.asList(addressFroEmp2), "Automation Lead", "Mike Nebula", "08:30 AM", "9844563645");
		listOfEmployees.addAll(Arrays.asList(employee1, employee2));
		
		 employeeDetails = new EmployeeVersion1(101007, "John Smart", "1624958216", Arrays.asList(addressFroEmp1), "QA Manager", "Mike Nebula", "09:00 AM");
//		employeeDetails = new EmployeeVersion1(101007, "John Smart", "1624958216", Arrays.asList(addressFroEmp1), "QA Manager", "Mike Nebula", "09:00 AM", "9844563645");
	}

	public EmployeeVersion1 createEmployeeVersion1(EmployeeVersion1 employee) {
		int employeeId = (int) (Math.floor(Math.random() * (9 * Math.pow(10, 3))) + Math.pow(10, 3));
		employee.setEmpId(employeeId);
		listOfEmployees.add(employee);
		return employee;
	}

	public EmployeeVersion1 retrieveEmployeeVersion1() {
		return employeeDetails;
	}

	public List<EmployeeVersion1> retrieveAllEmployeesVersion1() {
		return listOfEmployees;
	}
}