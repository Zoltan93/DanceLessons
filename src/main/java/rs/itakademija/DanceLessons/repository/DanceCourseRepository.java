package rs.itakademija.DanceLessons.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.itakademija.DanceLessons.entity.DanceCourse;

@Repository
public interface DanceCourseRepository extends JpaRepository<DanceCourse, Integer> {
	
	@Query("select dc.danceStyleName, dc.costPerClass, dc.classesPerWeek "
			+ "from DanceCourse as dc where dc.id = :id")
	public Optional<DanceCourse> findDanceCourseById(@Param("id")Integer id);
	
}
