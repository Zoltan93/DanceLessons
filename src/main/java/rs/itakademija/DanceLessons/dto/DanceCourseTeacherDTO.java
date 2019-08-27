package rs.itakademija.DanceLessons.dto;

import java.io.Serializable;
import java.util.Set;

public class DanceCourseTeacherDTO implements Serializable {

	private static final long serialVersionUID = -8848410433207542122L;
	
	private Integer id;
	private String teacherName;
	private String teacherSurname;
	private String teacherEmail;
	private Set<Integer> danceCourseIds;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherSurname() {
		return teacherSurname;
	}
	public void setTeacherSurname(String teacherSurname) {
		this.teacherSurname = teacherSurname;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public Set<Integer> getDanceCourseIds() {
		return danceCourseIds;
	}
	public void setDanceCourseIds(Set<Integer> danceCourseIds) {
		this.danceCourseIds = danceCourseIds;
	}
    
}
