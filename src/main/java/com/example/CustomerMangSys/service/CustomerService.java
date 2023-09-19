package com.example.CustomerMangSys.service;

import java.util.List;

import com.example.CustomerMangSys.dto.CustomerDto;
import com.example.CustomerMangSys.dto.Hobbies;

public interface CustomerService {

	public void addCustomer(CustomerDto customerDto);
	public void deleteCustomer(long id);
	public CustomerDto getCustomerById(long id);
	public List<CustomerDto> searchCustomer(String keyword);
	public List<Hobbies> getDefaultHobbiesList();
}
