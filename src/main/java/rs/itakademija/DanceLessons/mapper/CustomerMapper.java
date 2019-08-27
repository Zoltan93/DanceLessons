package rs.itakademija.DanceLessons.mapper;

import rs.itakademija.DanceLessons.dto.CustomerDTO;
import rs.itakademija.DanceLessons.entity.Customer;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
	
	public CustomerDTO transform(Customer src) {
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(src, customerDTO);
		return customerDTO;
	}
	
}
