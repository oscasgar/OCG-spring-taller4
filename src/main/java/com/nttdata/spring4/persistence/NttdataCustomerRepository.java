package com.nttdata.spring4.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring4.persistence.NttdataCustomer;

/**
 * Dual - Spring - Taller 3
 * 
 * @author Oscasgar
 *
 */
@Repository
public interface NttdataCustomerRepository extends JpaRepository<NttdataCustomer, Long> {

	
	/**
	 * Obtiene un cliente por nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<NttdataSCustomer>
	 */
	public List<NttdataCustomer> findByNameAndSurName1AndSurName2(final String name, final String surname1, final String surname2);
	
	
	/**
	 * Obtiene un cliente por nombre completo.
	 * 
	 * @param name
	 * @return List<NttdataSCustomer>
	 */
	public List<NttdataCustomer> findByName(final String name);

}
