package com.employee.service.model;

import java.util.List;

public class EmployeeVersion1 {
	private int empId;
	private String employeeName;
	private String phoneNumber;
	private List<Address> address;
	private String designation;
	private String reportingManager;
	private String shiftTimings;
//	private String socialSecurityNumber;
	
	public EmployeeVersion1(int empId, String employeeName, String phoneNumber, List<Address> address, String designation, String reportingManager, String shiftTimings) {
		this.setEmpId(empId);
		this.setEmployeeName(employeeName);
		this.setPhoneNumber(phoneNumber);
		this.setAddress(address);
		this.setDesignation(designation);
		this.setReportingManager(reportingManager);
		this.setShiftTimings(shiftTimings);
	}
	
//	public EmployeeVersion1(int empId, String employeeName, String phoneNumber, List<Address> address, String designation, String reportingManager, String shiftTimings, String socialSecurityNumber) {
//		this.setEmpId(empId);
//		this.setEmployeeName(employeeName);
//		this.setPhoneNumber(phoneNumber);
//		this.setAddress(address);
//		this.setDesignation(designation);
//		this.setReportingManager(reportingManager);
//		this.setShiftTimings(shiftTimings);
//		this.setSocialSecurityNumber(socialSecurityNumber);
//	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
		
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	
	public void setShiftTimings(String shiftTimings) {
		this.shiftTimings = shiftTimings;
	}

//	public void setSocialSecurityNumber(String socialSecurityNumber) {
//		this.socialSecurityNumber = socialSecurityNumber;
//	}	
	
	public long getEmpId() {
		return this.empId;
	}
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public List<Address> getAddress() {
		return this.address;
	}
	
	public String getDesignation() {
		return this.designation;
	}
	
	public String getReportingManager() {
		return this.reportingManager;
	}
	
	public String getShiftTimings() {
		return this.shiftTimings;
	}
	
//	public String getSocialSecurityNumber() {
//		return this.socialSecurityNumber;
//	}
}
