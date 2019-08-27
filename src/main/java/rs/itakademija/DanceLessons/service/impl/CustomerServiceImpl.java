package rs.itakademija.DanceLessons.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.itakademija.DanceLessons.dto.CustomerDTO;
import rs.itakademija.DanceLessons.entity.Customer;
import rs.itakademija.DanceLessons.mapper.CustomerMapper;
import rs.itakademija.DanceLessons.repository.CustomerRepository;
import rs.itakademija.DanceLessons.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerMapper mapper;

	@Override
	public CustomerDTO findOne(Integer id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if(!customer.isPresent()) {
			throw new IllegalArgumentException
				("Customer with the following id = " + id + " is not found.");
		}
		return mapper.transform(customer.get());
	}

	@Override
	public List<CustomerDTO> findAll() {
		return customerRepository.findAll().stream().map(i -> mapper.transform(i)).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO save(Customer customer) {
		return mapper.transform(customerRepository.save(customer));
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException {
		Optional<Customer> customer = customerRepository.findById(id);
		if(!customer.isPresent()) {
			throw new IllegalArgumentException
				("Customer with the following id = " + id + " is not found.");
		}
		customerRepository.deleteById(id);
	}

	@Override
	public CustomerDTO update(Integer id, Customer customer) {
		Optional<Customer> oldCustomer = customerRepository.findById(id);
		if(!oldCustomer.isPresent()) {
			throw new IllegalArgumentException
				("Customer with the following id = " + id +  " is not found.");
		}
		oldCustomer.get().setName(customer.getName());
		oldCustomer.get().setSurname(customer.getSurname());
		oldCustomer.get().setAccountName(customer.getAccountName());
		oldCustomer.get().setPassword(customer.getPassword());
		oldCustomer.get().setEmail(customer.getEmail());
		oldCustomer.get().setBankCardNumber(customer.getBankCardNumber());
		customerRepository.save(oldCustomer.get());
		return mapper.transform(oldCustomer.get());
	}

	@Override
	public CustomerDTO findByAccountName(String accountName) {
		Optional<Customer> customer = customerRepository.findByAccountName(accountName);
		if(!customer.isPresent()) {
			throw new IllegalArgumentException
				("Customer with the following id = " + accountName + " is not found.");
		}
		return mapper.transform(customer.get());
	}

}
