package com.nttdata.spring4.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nttdata.spring4.persistence.NttdataCustomerRepository;
import com.nttdata.spring4.persistence.NttdataCustomer;

/**
 * Dual - Spring - Taller 3
 * 
 * @author Oscasgar
 *
 */
@Service
public class NttdataCustomerManagementServiceImpl implements NttdataCustomerManagementServiceI {

	@Autowired
	private NttdataCustomerRepository customerRepo;

	@Override
	public NttdataCustomer insertNewCustomer(final NttdataCustomer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Insercción del nuevo cliente.
			customerRepo.save(newCustomer);
	
			return newCustomer;
		}
		return null;

	}

	@Override
	public NttdataCustomer updateCustomer(final NttdataCustomer updatedCustomer) {

		// Verificación de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Actualización del cliente.
			customerRepo.save(updatedCustomer);
			return updatedCustomer;
		}
		return null;
	}

	@Override
	public NttdataCustomer deleteCustomer(final NttdataCustomer deletedCustomer) {

		// Verificación de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Eliminación del cliente.
			customerRepo.delete(deletedCustomer);
			return deletedCustomer;
		}
		
		return null;
	}

	@Override
	public NttdataCustomer searchById(final Long customerId) {

		// Resultado.
		NttdataCustomer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del cliente por ID.
			customer = customerRepo.getById(customerId);
		}

		return customer;
	}

	@Override
	public List<NttdataCustomer> searchByFullName(final String name, final String surname1, final String surname2) {

		// Resultado.
		List<NttdataCustomer> customersList = new ArrayList<NttdataCustomer>();

		// Verificación de nulidad.
		if (StringUtils.hasText(name) && StringUtils.hasText(surname1) && StringUtils.hasText(surname2)) {

			// Obtención del cliente por nombre completo.
			customersList = customerRepo.findByNameAndSurName1AndSurName2(name, surname1, surname2);
		}

		return customersList;
	}

	@Override
	public List<NttdataCustomer> searchAll() {

		// Resultado.
		List<NttdataCustomer> customersList = new ArrayList<NttdataCustomer>();

		// Obtención de clientes.
		customersList = customerRepo.findAll();

		return customersList;
	}

	@Override
	public List<NttdataCustomer> searchByName(String name) {
		// Resultado.
				List<NttdataCustomer> customersList = new ArrayList<NttdataCustomer>();

				// Verificación de nulidad.
				if (StringUtils.hasText(name)) {

					// Obtención del cliente por nombre completo.
					customersList = customerRepo.findByName(name);
				}

				return customersList;
	
	}

}
