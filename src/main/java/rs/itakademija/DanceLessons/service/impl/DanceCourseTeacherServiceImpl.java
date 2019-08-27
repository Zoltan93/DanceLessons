package rs.itakademija.DanceLessons.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.itakademija.DanceLessons.dto.DanceCourseTeacherDTO;
import rs.itakademija.DanceLessons.entity.DanceCourseTeacher;
import rs.itakademija.DanceLessons.mapper.DanceCourseTeacherMapper;
import rs.itakademija.DanceLessons.repository.DanceCourseTeacherRepository;
import rs.itakademija.DanceLessons.service.DanceCourseTeacherService;

@Service
public class DanceCourseTeacherServiceImpl implements DanceCourseTeacherService {
	
	@Autowired
	private DanceCourseTeacherRepository danceCourseTeacherRepository;
	
	@Autowired
	private DanceCourseTeacherMapper mapper;

	@Transactional
	@Override
	public DanceCourseTeacherDTO findOne(Integer id) {
		Optional<DanceCourseTeacher> danceCourseTeacher = danceCourseTeacherRepository.findById(id);
		if(!danceCourseTeacher.isPresent()) {
			throw new IllegalArgumentException
				("Dance course teacher with the following id = " + id + " is not found.");
		}
		return mapper.transform(danceCourseTeacher.get());
	}
	
	@Override
	public List<DanceCourseTeacherDTO> findAll() {
		return danceCourseTeacherRepository.findAll().stream().map(i -> mapper.transform(i)).collect(Collectors.toList());
	}

	@Override
	public DanceCourseTeacherDTO save(DanceCourseTeacher danceCourseTeacher) {
		return mapper.transform(danceCourseTeacherRepository.save(danceCourseTeacher));
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException {
		Optional<DanceCourseTeacher> danceCourseTeacher = danceCourseTeacherRepository.findById(id);
		if(!danceCourseTeacher.isPresent()) {
			throw new IllegalArgumentException
				("Dance course teacher with the following id = " + id + " is not found.");
		}
		danceCourseTeacherRepository.deleteById(id);
	}

	@Override
	public DanceCourseTeacherDTO update(Integer id, DanceCourseTeacher danceCourseTeacher) {
		Optional<DanceCourseTeacher> oldDanceCourseTeacher = danceCourseTeacherRepository.findById(id);
		if(!oldDanceCourseTeacher.isPresent()) {
			throw new IllegalArgumentException
				("Dance course teacher with the following id = " + id + " is not found.");
		}
		oldDanceCourseTeacher.get().setTeacherName(danceCourseTeacher.getTeacherName());
		oldDanceCourseTeacher.get().setTeacherSurname(danceCourseTeacher.getTeacherSurname());
		oldDanceCourseTeacher.get().setTeacherEmail(danceCourseTeacher.getTeacherEmail());
		oldDanceCourseTeacher.get().setDanceCourses(danceCourseTeacher.getDanceCourses());
		danceCourseTeacherRepository.save(oldDanceCourseTeacher.get());
		return mapper.transform(oldDanceCourseTeacher.get());
	}
	
}
