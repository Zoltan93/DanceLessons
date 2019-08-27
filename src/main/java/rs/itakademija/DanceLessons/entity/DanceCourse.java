package rs.itakademija.DanceLessons.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import rs.itakademija.DanceLessons.entity.DanceCourseTeacher;

@Entity
@Table(name = "dance_course", catalog = "dance_lessons_subscription", 
	uniqueConstraints = @UniqueConstraint(columnNames="dance_style_name"))
public class DanceCourse implements Serializable {
	
	private static final long serialVersionUID = 3L;
	
	private Integer id;
    private DanceCourseTeacher danceCourseTeacher;
    private String danceStyleName;
    private Integer costPerClass;
    private Integer classesPerWeek;
    
    public DanceCourse() {
    }

    public DanceCourse(DanceCourseTeacher danceCourseTeacher, String danceStyleName, Integer costPerClass, Integer classesPerWeek) {
       this.danceCourseTeacher = danceCourseTeacher;
       this.danceStyleName = danceStyleName;
       this.costPerClass = costPerClass;
       this.classesPerWeek = classesPerWeek;
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
    
    @Column(name = "dance_style_name", nullable = false, unique = true, length = 45)
    public String getDanceStyleName() {
    	return this.danceStyleName;
    }
    
    public void setDanceStyleName(String danceStyleName) {
    	this.danceStyleName = danceStyleName;
    }
    
    @Column(name = "cost_per_class", nullable = false)
    public Integer getCostPerClass() {
    	return this.costPerClass;
    }
    
    public void setCostPerClass(Integer costPerClass) {
    	this.costPerClass = costPerClass;
    }
    
    @Column(name = "classes_per_week", nullable = false)
    public Integer getClassesPerWeek() {
    	return this.classesPerWeek;
    }
    
    public void setClassesPerWeek(Integer classesPerWeek) {
    	this.classesPerWeek = classesPerWeek;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="dance_course_teacher_fk", nullable=false)
    public DanceCourseTeacher getDanceCourseTeacher() {
        return this.danceCourseTeacher;
    }
    
    public void setDanceCourseTeacher(DanceCourseTeacher danceCourseTeacher) {
        this.danceCourseTeacher = danceCourseTeacher;
    }
    
    public void setDanceCourse(DanceCourseTeacher danceCourseTeacher, String danceStyleName, Integer costPerClass, Integer classesPerWeek) {
    	this.danceCourseTeacher = danceCourseTeacher;
        this.danceStyleName = danceStyleName;
        this.costPerClass = costPerClass;
        this.classesPerWeek = classesPerWeek;
    }
    
}
