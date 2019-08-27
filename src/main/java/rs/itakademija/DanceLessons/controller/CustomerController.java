package rs.itakademija.DanceLessons.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.itakademija.DanceLessons.service.CustomerService;
import rs.itakademija.DanceLessons.dto.CustomerDTO;
import rs.itakademija.DanceLessons.entity.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO selectCustomer(@PathVariable("id")Integer id) {
		return customerService.findOne(id);
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDTO> listAll() {
		return customerService.findAll();
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO updateCustomer(@PathVariable("id")Integer id, @RequestBody Customer oldCustomer) {
		return customerService.update(id, oldCustomer);
	}
	
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO insertCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCustomer(@PathVariable("id")Integer id) {
		customerService.remove(id);
	}
	
	@GetMapping(value = "/accountName/{accountName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO findByAccountName(@PathVariable("accountName")String accountName) {
		return customerService.findByAccountName(accountName);
	}

}
