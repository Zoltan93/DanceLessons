package rs.itakademija.DanceLessons.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import rs.itakademija.DanceLessons.dto.CustomerHasDanceCourseDTO;
import rs.itakademija.DanceLessons.entity.CustomerHasDanceCourse;

@Component
public class CustomerHasDanceCourseMapper {
	
	public CustomerHasDanceCourseDTO transform(CustomerHasDanceCourse src) {
		CustomerHasDanceCourseDTO customerHasDanceCourseDTO = new CustomerHasDanceCourseDTO();
		BeanUtils.copyProperties(src, customerHasDanceCourseDTO);
		return customerHasDanceCourseDTO;
	}

}
