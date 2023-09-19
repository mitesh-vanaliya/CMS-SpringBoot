package com.example.CustomerMangSys.dto;

import jakarta.validation.constraints.NotNull;

public class CustomerDto {
	
	@NotNull(message = "Id can not be empty!")
	private long customerId;
	@NotNull(message = "Name can not be null!")
	private String customerName;
	@NotNull(message = "address can not be null!")
	private String customerAddress;
	@NotNull(message = "gender can not be empty!")
	private String customerGender;
	@NotNull(message = "coutry can not be empty!")
	private String customerCountry;
	@NotNull(message = "hobbies can not be null!")
	private String customerHobbies;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	public String getCustomerHobbies() {
		return customerHobbies;
	}
	public void setCustomerHobbies(String customerHobbies) {
		this.customerHobbies = customerHobbies;
	}
	

}
