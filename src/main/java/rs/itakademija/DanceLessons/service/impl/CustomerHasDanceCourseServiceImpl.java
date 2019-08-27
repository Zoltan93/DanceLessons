package rs.itakademija.DanceLessons.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.itakademija.DanceLessons.dto.CustomerHasDanceCourseDTO;
import rs.itakademija.DanceLessons.entity.CustomerHasDanceCourse;
import rs.itakademija.DanceLessons.mapper.CustomerHasDanceCourseMapper;
import rs.itakademija.DanceLessons.repository.CustomerHasDanceCourseRepository;
import rs.itakademija.DanceLessons.service.CustomerHasDanceCourseService;

@Service
public class CustomerHasDanceCourseServiceImpl implements CustomerHasDanceCourseService {
	
	@Autowired
	private CustomerHasDanceCourseRepository customerHasDanceCourseRepository;
	
	@Autowired
	private CustomerHasDanceCourseMapper mapper;

	@Override
	public CustomerHasDanceCourseDTO findOne(Integer id) {
		Optional<CustomerHasDanceCourse> customerHasDanceCourse = customerHasDanceCourseRepository.findById(id);
		if(!customerHasDanceCourse.isPresent()) {
			throw new IllegalArgumentException
				("Customer has dance course with id = " + id + " is not found.");
		}
		return mapper.transform(customerHasDanceCourse.get());
	}

	@Override
	public List<CustomerHasDanceCourseDTO> findAll() {
		return customerHasDanceCourseRepository.findAll().stream().map(i -> mapper.transform(i)).collect(Collectors.toList());
	}

	@Override
	public CustomerHasDanceCourseDTO save(CustomerHasDanceCourse customerHasDanceCourse) {
		return mapper.transform(customerHasDanceCourseRepository.save(customerHasDanceCourse));
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException {
		Optional<CustomerHasDanceCourse> customerHasDanceCourse = customerHasDanceCourseRepository.findById(id);
		if(!customerHasDanceCourse.isPresent()) {
			throw new IllegalArgumentException
				("Customer has dance course with id = " + id + " is not found.");
		}
		customerHasDanceCourseRepository.deleteById(id);
	}

	@Override
	public CustomerHasDanceCourseDTO update(Integer id, CustomerHasDanceCourse customerHasDanceCourse) {
		Optional<CustomerHasDanceCourse> oldCustomerHasDanceCourse = customerHasDanceCourseRepository.findById(id);
		if(!oldCustomerHasDanceCourse.isPresent()) {
			throw new IllegalArgumentException
				("Customer has dance course with id = " + id + " is not found.");
		}
		oldCustomerHasDanceCourse.get().setCustomerId(customerHasDanceCourse.getCustomerId());
		oldCustomerHasDanceCourse.get().setDanceCourseId(customerHasDanceCourse.getDanceCourseId());
		oldCustomerHasDanceCourse.get().setClassesBought(customerHasDanceCourse.getClassesBought());
		return mapper.transform(oldCustomerHasDanceCourse.get());
	}

}
