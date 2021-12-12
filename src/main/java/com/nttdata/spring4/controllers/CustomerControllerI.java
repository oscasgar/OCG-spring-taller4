package com.nttdata.spring4.controllers;

import org.springframework.ui.Model;

import com.nttdata.spring4.persistence.NttdataCustomer;

public interface CustomerControllerI {

	public String showCustomers(Model model);
	
	public String addCustomer(NttdataCustomer customer);

	public String homeCustomers();

	String updateCustomer(NttdataCustomer customer);

	String deleteCustomer(NttdataCustomer customer);

	String searchCustomers(Model model, NttdataCustomer customer);

	
}
