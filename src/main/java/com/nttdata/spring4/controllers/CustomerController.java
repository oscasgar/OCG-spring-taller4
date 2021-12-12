package com.nttdata.spring4.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.spring4.persistence.NttdataCustomer;
import com.nttdata.spring4.services.NttdataCustomerManagementServiceI;

/**
 * Interfaz asociada al controlador de los clientes.
 * 
 * @author Oscasgar
 *
 */
@Controller
@RequestMapping("/home/")
public class CustomerController implements CustomerControllerI {

	
	@Autowired
	private NttdataCustomerManagementServiceI customerService;
	
	@Override
	@GetMapping
	public String homeCustomers() {
		return "/home";
	}
	
	@Override
	@GetMapping("/showCustomers")
	public String showCustomers(Model model) {

		final String viewResult = "listaCustomersV";
		
		final List<NttdataCustomer> results = customerService.searchAll();
		
		model.addAttribute("listaCustomers", results);
		
		return viewResult;
	}

	@Override
	@PostMapping("/searchCustomers")
	public String searchCustomers(Model model, NttdataCustomer customer) {

		final String viewResult = "listaCustomersV";
		
		final List<NttdataCustomer> results = customerService.searchByName(customer.getName());
		
		model.addAttribute("listaCustomers", results);
		
		return viewResult;
	}

	@Override
	@PostMapping("/addCustomer")
	public String addCustomer(final NttdataCustomer customer) {
		
		String viewResult = "erroresV";
		customer.setBirthDay(new Date());
		customer.setUpdatedDate(new Date());
		customer.setUpdatedUser("SYS NTTDATA");
		final NttdataCustomer result = customerService.insertNewCustomer(customer);
		
		if(result != null && result.getCustomerId() != null) {
			viewResult = "/home";
		}
		
		return viewResult;
	}

	@Override
	@PostMapping("/deleteCustomer")
	public String deleteCustomer(final NttdataCustomer customer) {
		
		String viewResult = "erroresV";
		NttdataCustomer customerD = customerService.searchById(customer.getCustomerId());
		final NttdataCustomer result = customerService.deleteCustomer(customerD);
		
		if(result != null && result.getCustomerId() != null) {
			viewResult = "/home";
		}
		
		return viewResult;
	}
	
	@Override
	@PostMapping("/updateCustomer")
	public String updateCustomer(final NttdataCustomer customer) {
		
		String viewResult = "erroresV";
		customer.setBirthDay(new Date());
		customer.setUpdatedDate(new Date());
		customer.setUpdatedUser("SYS NTTDATA");
		final NttdataCustomer result = customerService.updateCustomer(customer);
		
		if(result != null && result.getCustomerId() != null) {
			viewResult = "/home";
		}
		
		return viewResult;
	}
	


}
