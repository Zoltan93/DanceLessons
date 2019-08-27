package rs.itakademija.DanceLessons.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import rs.itakademija.DanceLessons.dto.DanceCourseDTO;
import rs.itakademija.DanceLessons.entity.DanceCourse;

@Component
public class DanceCourseMapper {

	public DanceCourseDTO transform(DanceCourse src) {
		DanceCourseDTO danceCourseDTO = new DanceCourseDTO();
		BeanUtils.copyProperties(src, danceCourseDTO);
		danceCourseDTO.setDanceCourseTeacherId(src.getDanceCourseTeacher().getId());
		return danceCourseDTO;
	}
	
}
