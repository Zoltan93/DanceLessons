package rs.itakademija.DanceLessons.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dance_course_teacher", catalog = "dance_lessons_subscription")
public class DanceCourseTeacher implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private Integer id;
    private String teacherName;
    private String teacherSurname;
    private String teacherEmail;
    private Set<DanceCourse> danceCourses = new HashSet<>();
    
    public DanceCourseTeacher() {}
	
    public DanceCourseTeacher(String teacherName, String teacherSurname, String teacherEmail) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherEmail = teacherEmail;
    }
    
    public DanceCourseTeacher(String teacherName, String teacherSurname, String teacherEmail, Set<DanceCourse> danceCourses) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherEmail = teacherEmail;
        this.danceCourses = danceCourses;
     }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
    	return this.id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    @Column(name = "teacher_name", nullable = false, unique = true, length = 45)
    public String getTeacherName() {
    	return this.teacherName;
    }
    
    public void setTeacherName(String teacherName) {
    	this.teacherName = teacherName;
    }
    
    @Column(name = "teacher_surname", nullable = false, length = 45)
    public String getTeacherSurname() {
    	return this.teacherSurname;
    }
    
    public void setTeacherSurname(String teacherSurname) {
    	this.teacherSurname = teacherSurname;
    }
    
    @Column(name = "teacher_email", nullable = false, unique = true, length = 45)
    public String getTeacherEmail() {
    	return this.teacherEmail;
    }
    
    public void setTeacherEmail(String teacherEmail) {
    	this.teacherEmail = teacherEmail;
    }
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "danceCourseTeacher")
    public Set<DanceCourse> getDanceCourses() {
    	return this.danceCourses;
    }
    
    public void setDanceCourses(Set<DanceCourse> danceCourses) {
    	this.danceCourses = danceCourses;
    }
    
    @Override
    public String toString() {
        return "DanceCourseTeacher{" + "id=" + id + ", teacherName=" + teacherName + ", teacherSurname=" 
        		+ teacherSurname + ", teacherEmail=" + teacherEmail + ", danceCourses=" + danceCourses;
    }

}
