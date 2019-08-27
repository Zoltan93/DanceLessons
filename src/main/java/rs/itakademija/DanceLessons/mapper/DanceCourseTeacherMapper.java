package rs.itakademija.DanceLessons.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import rs.itakademija.DanceLessons.dto.DanceCourseTeacherDTO;
import rs.itakademija.DanceLessons.entity.DanceCourseTeacher;

@Component
public class DanceCourseTeacherMapper {
	
	public DanceCourseTeacherDTO transform(DanceCourseTeacher src) {
		DanceCourseTeacherDTO danceCourseTeacherDTO = new DanceCourseTeacherDTO();
		BeanUtils.copyProperties(src, danceCourseTeacherDTO);
		Set<Integer> danceCourses = src.getDanceCourses().stream().map(i -> i.getId()).collect(Collectors.toSet());
		danceCourseTeacherDTO.setDanceCourseIds(danceCourses);
		return danceCourseTeacherDTO;
	}

}
