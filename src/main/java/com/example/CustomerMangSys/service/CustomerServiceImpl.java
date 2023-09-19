package com.example.CustomerMangSys.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerMangSys.dto.CustomerDto;
import com.example.CustomerMangSys.dto.Hobbies;
import com.example.CustomerMangSys.entity.CustomerEntity;
import com.example.CustomerMangSys.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void addCustomer(CustomerDto customerDto) {
		
		//Convert dto to entity class
		CustomerEntity  entity = new CustomerEntity();
		entity.setName(customerDto.getCustomerName());
		entity.setAddress(customerDto.getCustomerAddress());
		entity.setCountry(customerDto.getCustomerCountry());
		entity.setGender(customerDto.getCustomerGender());
		entity.setHobbies(customerDto.getCustomerHobbies());
		customerRepository.save(entity);
	}

	@Override
	public List<CustomerDto> searchCustomer(String keyword) {
		List<CustomerEntity> allSearchCustomer =  customerRepository.findByName(keyword);
		
		List<CustomerDto> dto = new ArrayList<>();
		for(CustomerEntity entity : allSearchCustomer)
		{
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerId(entity.getCustomerId());
			customerDto.setCustomerAddress(entity.getAddress());
			customerDto.setCustomerName(entity.getName());
			customerDto.setCustomerCountry(entity.getCountry());
			customerDto.setCustomerGender(entity.getGender());
			customerDto.setCustomerHobbies(entity.getHobbies());
			dto.add(customerDto);
		}
		
		
		return dto;
	}

	@Override
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public CustomerDto getCustomerById(long id) {
		CustomerEntity entity = customerRepository.getReferenceById(id);
		if (entity != null) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerId(entity.getCustomerId());
			customerDto.setCustomerAddress(entity.getAddress());
			customerDto.setCustomerName(entity.getName());
			customerDto.setCustomerCountry(entity.getCountry());
			customerDto.setCustomerGender(entity.getGender());
			customerDto.setCustomerHobbies(entity.getHobbies());
			return customerDto;
		}
		return null;
	}

	@Override
	public List<Hobbies> getDefaultHobbiesList() {
		 //Pass default hobbies
        //Get all hobbies from master table will do in next version
        List<Hobbies> defaultHobbies =  Arrays.asList(
        		new Hobbies(1,"Sport",false),
        		new Hobbies(2,"Swimming",false),
        		new Hobbies(3,"Cricket",false)
        		);
		return defaultHobbies;
	}

}
