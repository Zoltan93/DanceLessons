package rs.itakademija.DanceLessons.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.itakademija.DanceLessons.dto.CustomerHasDanceCourseDTO;
import rs.itakademija.DanceLessons.entity.CustomerHasDanceCourse;
import rs.itakademija.DanceLessons.service.CustomerHasDanceCourseService;

@Controller
@RequestMapping(value = "/customerHasDanceCourse")
public class CustomerHasDanceCourseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerHasDanceCourse.class);
	
	@Autowired
	private CustomerHasDanceCourseService customerHasDanceCourseService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerHasDanceCourseDTO selectCustomerHasDanceCourse(@PathVariable("id")Integer customerId) {
		return customerHasDanceCourseService.findOne(customerId);
	}
	
	
	@PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerHasDanceCourseDTO insertCustomerHasDanceCourse
		(@RequestBody CustomerHasDanceCourse customerHasDanceCourse) {
		return customerHasDanceCourseService.save(customerHasDanceCourse);
	}

}
