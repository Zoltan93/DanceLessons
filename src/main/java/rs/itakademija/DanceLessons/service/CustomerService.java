package rs.itakademija.DanceLessons.service;

import rs.itakademija.DanceLessons.dto.CustomerDTO;
import rs.itakademija.DanceLessons.entity.Customer;

public interface CustomerService extends CrudService<Customer, CustomerDTO> {
	
	public CustomerDTO findByAccountName(String accountName);

}
