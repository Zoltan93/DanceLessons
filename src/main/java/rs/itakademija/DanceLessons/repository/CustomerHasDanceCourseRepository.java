package rs.itakademija.DanceLessons.repository;

import org.springframework.stereotype.Repository;

import rs.itakademija.DanceLessons.entity.CustomerHasDanceCourse;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerHasDanceCourseRepository extends JpaRepository<CustomerHasDanceCourse, Integer> {

}
