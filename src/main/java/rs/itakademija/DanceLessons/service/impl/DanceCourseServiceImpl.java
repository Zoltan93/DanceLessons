package rs.itakademija.DanceLessons.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.itakademija.DanceLessons.dto.DanceCourseDTO;
import rs.itakademija.DanceLessons.entity.DanceCourse;
import rs.itakademija.DanceLessons.entity.DanceCourseTeacher;
import rs.itakademija.DanceLessons.mapper.DanceCourseMapper;
import rs.itakademija.DanceLessons.repository.DanceCourseRepository;
import rs.itakademija.DanceLessons.repository.DanceCourseTeacherRepository;
import rs.itakademija.DanceLessons.service.DanceCourseService;

@Service
public class DanceCourseServiceImpl implements DanceCourseService {
	
	@Autowired
	private DanceCourseRepository danceCourseRepository;
	
	@Autowired
	private DanceCourseTeacherRepository danceCourseTeacherRepository;
	
	@Autowired
	private DanceCourseMapper mapper;

	@Override
	public DanceCourseDTO findOne(Integer id) {
		Optional<DanceCourse> danceCourse = danceCourseRepository.findById(id);
		if(!danceCourse.isPresent()) {
			throw new IllegalArgumentException
				("Dance course with the following id = " + id + " is not found.");
		}
		return mapper.transform(danceCourse.get());
	}

	@Override
	public List<DanceCourseDTO> findAll() {
		return danceCourseRepository.findAll().stream().map(i -> mapper.transform(i)).collect(Collectors.toList());
	}

	@Override
	public DanceCourseDTO save(DanceCourse danceCourse) {
		return mapper.transform(danceCourseRepository.save(danceCourse));
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException {
		Optional<DanceCourse> danceCourse = danceCourseRepository.findById(id);
		if(!danceCourse.isPresent()) {
			throw new IllegalArgumentException
				("Dance course with the following id = " + id + " is not found.");
		}
		danceCourseRepository.deleteById(id);
	}

	@Override
	public DanceCourseDTO update(Integer id, DanceCourse danceCourse) {
		Optional<DanceCourse> oldDanceCourse = danceCourseRepository.findById(id);
		if(!oldDanceCourse.isPresent()) {
			throw new IllegalArgumentException
				("Dance course with the following id = " + id + " is not found.");
		}
		oldDanceCourse.get().setDanceStyleName(danceCourse.getDanceStyleName());
		oldDanceCourse.get().setCostPerClass(danceCourse.getCostPerClass());
		oldDanceCourse.get().setClassesPerWeek(danceCourse.getClassesPerWeek());
		danceCourseRepository.save(oldDanceCourse.get());
		return mapper.transform(oldDanceCourse.get());
	}

	@Transactional
	@Override
	public DanceCourseDTO updateDanceCourseTeacher(Integer danceCourseId, Integer teacherId) {
		Optional<DanceCourse> oldDanceCourse = danceCourseRepository.findById(danceCourseId);
		if(!oldDanceCourse.isPresent()) {
			throw new IllegalArgumentException
				("Dance course with the following id = " + danceCourseId + " is not found.");
		}
		Optional<DanceCourseTeacher> danceCourseTeacher = danceCourseTeacherRepository.findById(teacherId);
		if(!danceCourseTeacher.isPresent()) {
			throw new IllegalArgumentException
				("Dance course teacher with the following id = " + teacherId + " is not found.");
		}
		oldDanceCourse.get().setDanceCourseTeacher(danceCourseTeacherRepository.findById(teacherId).get());
		danceCourseRepository.save(oldDanceCourse.get());
		return mapper.transform(oldDanceCourse.get());
	}

	@Override
	public DanceCourseDTO saveDanceCourse(DanceCourse danceCourse, Integer teacherId) {
		Optional<DanceCourseTeacher> danceCourseTeacher = danceCourseTeacherRepository.findById(teacherId);
		if(!danceCourseTeacher.isPresent()) {
			throw new IllegalArgumentException
				("Dance course teacher with the following id = " + teacherId + " is not found.");
		}
		danceCourse.setDanceCourseTeacher(danceCourseTeacher.get());
		danceCourseRepository.save(danceCourse);
		return mapper.transform(danceCourse);
	}

}
