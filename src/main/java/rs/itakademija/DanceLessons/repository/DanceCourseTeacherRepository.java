package rs.itakademija.DanceLessons.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.itakademija.DanceLessons.entity.DanceCourseTeacher;

@Repository
public interface DanceCourseTeacherRepository extends JpaRepository<DanceCourseTeacher, Integer> {
	
}
