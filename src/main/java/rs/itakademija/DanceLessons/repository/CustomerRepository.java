package rs.itakademija.DanceLessons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.itakademija.DanceLessons.entity.Customer;

/**
 * 
 * As with the service layer, we extend JpaRepository interface, which has already defined methods.
 * We can add more methods here if needed.
 * Watch out to implement every method which is here, if you @Autowire the interface.
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Optional<Customer> findByAccountName(String accountName);

}
