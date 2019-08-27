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

import rs.itakademija.DanceLessons.dto.DanceCourseTeacherDTO;
import rs.itakademija.DanceLessons.entity.DanceCourseTeacher;
import rs.itakademija.DanceLessons.service.DanceCourseTeacherService;

@RestController
@RequestMapping(value = "/danceCourseTeacher")
public class DanceCourseTeacherController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DanceCourseTeacherController.class);
	
	@Autowired
	private DanceCourseTeacherService danceCourseTeacherService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DanceCourseTeacherDTO selectDanceCourseTeacher(@PathVariable("id")Integer id) {
		return danceCourseTeacherService.findOne(id);
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DanceCourseTeacherDTO> listAll() {
		return danceCourseTeacherService.findAll();
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DanceCourseTeacherDTO updateDanceCourseTeacher(@PathVariable("id")Integer id, @RequestBody DanceCourseTeacher danceCourseTeacher) {
		return danceCourseTeacherService.update(id, danceCourseTeacher);
	}
	
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DanceCourseTeacherDTO insertDanceCourseTeacher(@RequestBody DanceCourseTeacher oldDanceCourseTeacher) {
		return danceCourseTeacherService.save(oldDanceCourseTeacher);
	}
	
	@DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteDanceCourseTeacher(@PathVariable("id")Integer id) {
		danceCourseTeacherService.remove(id);
	}
	
}
