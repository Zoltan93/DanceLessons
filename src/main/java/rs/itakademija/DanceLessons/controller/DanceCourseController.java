package rs.itakademija.DanceLessons.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.itakademija.DanceLessons.dto.DanceCourseDTO;
import rs.itakademija.DanceLessons.entity.DanceCourse;
import rs.itakademija.DanceLessons.service.DanceCourseService;

@RestController
@RequestMapping(value = "/danceCourse")
public class DanceCourseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DanceCourseController.class);
	
	@Autowired
	private DanceCourseService danceCourseService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DanceCourseDTO selectDanceCourse(@PathVariable("id")Integer id) {
		return danceCourseService.findOne(id);
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DanceCourseDTO> listAll() {
		return danceCourseService.findAll();
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DanceCourseDTO updateDanceCourse(@PathVariable("id")Integer id, @RequestBody DanceCourse oldDanceCourse) {
		return danceCourseService.update(id, oldDanceCourse);
	}
	
	@PutMapping(value = "/{courseId}/update/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DanceCourseDTO updateDanceCourseTeacher(@PathVariable("courseId")Integer courseId, @PathVariable("teacherId")Integer teacherId) {
		return danceCourseService.updateDanceCourseTeacher(courseId, teacherId);
	}
	
	@PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DanceCourseDTO insertDanceCourse(@RequestBody DanceCourse danceCourse, @PathVariable("id")Integer id) {
		return danceCourseService.saveDanceCourse(danceCourse, id);
	}
	
	@DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteDanceCourse(@PathVariable("id")Integer id) {
		danceCourseService.remove(id);
	}

}
