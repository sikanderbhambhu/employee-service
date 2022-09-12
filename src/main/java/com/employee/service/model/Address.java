package com.employee.service.model;

public class Address {
	private String addressLine1;
	private String city;
	private String state;
	private int pinCode;
	
	public Address(String addressLine1, String city, String state, int pinCode) {
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public String getAddressLine1() {
		return this.addressLine1;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public int getPinCode() {
		return this.pinCode;
	}
}
