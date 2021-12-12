package com.nttdata.spring4;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring4.persistence.NttdataCustomer;
import com.nttdata.spring4.services.NttdataCustomerManagementServiceI;

@SpringBootApplication
public class OcgSpringTaller4Application implements CommandLineRunner {
	
	@Autowired
	private NttdataCustomerManagementServiceI customerService;

	private Date birthDayDate = new Date(1034373600000L);
	
	public static void main(String[] args) {
		SpringApplication.run(OcgSpringTaller4Application.class, args);
		
		
	}
	
	@Override
	public void run(String... args) throws Exception {
	// Nuevo cliente 1.
			NttdataCustomer customer1 = new NttdataCustomer();
			customer1.setIdentityDocNumber("11222333A");
			customer1.setName("Alejandro");
			customer1.setSurName1("Téllez");
			customer1.setSurName2("Rubio");
			customer1.setBirthDay(birthDayDate);
			customer1.setUpdatedDate(new Date());
			customer1.setUpdatedUser("SYS NTTDATA");
			customerService.insertNewCustomer(customer1);

			// Nuevo cliente 2.
			NttdataCustomer customer2 = new NttdataCustomer();
			customer2.setIdentityDocNumber("44555666B");
			customer2.setName("Alejandro");
			customer2.setSurName1("Cabrera");
			customer2.setSurName2("Martín");
			customer2.setBirthDay(birthDayDate);
			customer2.setUpdatedDate(new Date());
			customer2.setUpdatedUser("SYS NTTDATA");
			customerService.insertNewCustomer(customer2);

			// Nuevo cliente 3.
			NttdataCustomer customer3 = new NttdataCustomer();
			customer3.setIdentityDocNumber("77888999C");
			customer3.setName("Ainara");
			customer3.setSurName1("Téllez");
			customer3.setSurName2("Campano");
			customer3.setBirthDay(birthDayDate);
			customer3.setUpdatedDate(new Date());
			customer3.setUpdatedUser("SYS NTTDATA EXTERNAL");
			customerService.insertNewCustomer(customer3);

			// Nuevo cliente 4.
			NttdataCustomer customer4 = new NttdataCustomer();
			customer4.setIdentityDocNumber("00555000D");
			customer4.setName("Emilio");
			customer4.setSurName1("García");
			customer4.setSurName2("Delgado");
			customer4.setBirthDay(birthDayDate);
			customer4.setUpdatedDate(new Date());
			customer4.setUpdatedUser("SYS NTTDATA EXTERNAL");
			customerService.insertNewCustomer(customer4);
	}

}
