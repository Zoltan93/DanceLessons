package rs.itakademija.DanceLessons.service;

import rs.itakademija.DanceLessons.dto.DanceCourseDTO;
import rs.itakademija.DanceLessons.entity.DanceCourse;

public interface DanceCourseService extends CrudService<DanceCourse, DanceCourseDTO> {
	
	public DanceCourseDTO updateDanceCourseTeacher(Integer danceCourseId, Integer teacherId);
	public DanceCourseDTO saveDanceCourse(DanceCourse danceCourse, Integer teacherId);
	
}
