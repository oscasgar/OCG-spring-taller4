package com.nttdata.spring4.services;

import java.util.List;


import com.nttdata.spring4.persistence.NttdataCustomer;

/**
 * Dual - Spring - Taller 3
 * 
 * @author Oscasgar
 *
 */
public interface NttdataCustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 * @return 
	 */
	public NttdataCustomer insertNewCustomer(final NttdataCustomer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 * @return 
	 */
	public NttdataCustomer updateCustomer(final NttdataCustomer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 * @return 
	 */
	public NttdataCustomer deleteCustomer(final NttdataCustomer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param customerId
	 */
	public NttdataCustomer searchById(final Long customerId);

	/**
	 * Obtiene un cliente por su nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<EverisCustomer>
	 */
	public List<NttdataCustomer> searchByFullName(final String name, final String surname1, final String surname2);
	
	/**
	 * Obtiene un cliente por su nombre.
	 * 
	 * @param name
	 * @return List<EverisCustomer>
	 */
	public List<NttdataCustomer> searchByName(final String name);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<EverisCustomer>
	 */
	public List<NttdataCustomer> searchAll();

}
