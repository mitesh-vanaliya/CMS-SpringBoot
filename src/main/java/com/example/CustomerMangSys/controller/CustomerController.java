package com.example.CustomerMangSys.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.CustomerMangSys.dto.CustomerDto;
import com.example.CustomerMangSys.dto.Hobbies;
import com.example.CustomerMangSys.entity.CustomerEntity;
import com.example.CustomerMangSys.service.CustomerService;

@Validated
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/index")
	public String home()
	{
		return "home";
	}

	
    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
    	CustomerDto customer = new CustomerDto();
        model.addAttribute("customer", customer);
        
        List<Hobbies> defaultHobbies = customerService.getDefaultHobbiesList();
        model.addAttribute("defaultHobbies", defaultHobbies);
        return "addCustomer";
    }
    
    @GetMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") long customerId, Model model) {
    	
    	CustomerDto customer = customerService.getCustomerById(customerId);
    	if (customer != null) {
    		model.addAttribute("customer", customer);
		}
        List<Hobbies> defaultHobbies = customerService.getDefaultHobbiesList();
        //update hobbies as per selected customer
        for(Hobbies hobbies : defaultHobbies)
        {
        	
        }
        model.addAttribute("defaultHobbies", defaultHobbies);
        return "addCustomer";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable final long id, final RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("MSG_INFO", "Product deleted succesful!");
        return "searchCustomer";
    }
    
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") CustomerDto customerEntity, BindingResult result, Model model) {
    	
    	if (result.hasErrors()) {
    		return "addCustomer";
		}
    	customerService.addCustomer(customerEntity);
    	return "registrationSuccess";
    }
    
    
    @GetMapping("/registrationSuccess")
	public String success()
	{
		return "registrationSuccess";
	}
    
    @GetMapping("/search")
    public String searchCustomer(CustomerDto customerDto, Model model, String keyword) {
		if (keyword != null) {
			List<CustomerDto> searchCustomer =  customerService.searchCustomer(keyword);
			model.addAttribute("list",searchCustomer);
		}
		return "searchCustomer";
	}
    
    //search customer
    @GetMapping("/searchCustomer")
	public String searchCustomer(Model model)
	{
    	//By default load all customer
    	List<CustomerDto> searchCustomer =  customerService.searchCustomer("");
		model.addAttribute("list",searchCustomer);
		
		return "searchCustomer";
	}
    
}
