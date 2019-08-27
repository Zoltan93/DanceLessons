package rs.itakademija.DanceLessons.dto;

import java.io.Serializable;

public class DanceCourseDTO implements Serializable {
	
	private static final long serialVersionUID = -3281767997444105832L;
	
	private Integer danceCourseTeacherId;
    private String danceStyleName;
    private Integer costPerClass;
    private Integer classesPerWeek;
    
    public DanceCourseDTO() {}
    
    public String getDanceStyleName() {
    	return this.danceStyleName;
    }
    
    public void setDanceStyleName(String danceStyleName) {
    	this.danceStyleName = danceStyleName;
    }
    
    public Integer getCostPerClass() {
    	return this.costPerClass;
    }
    
    public void setCostPerClass(Integer costPerClass) {
    	this.costPerClass = costPerClass;
    }
    
    public Integer getClassesPerWeek() {
    	return this.classesPerWeek;
    }
    
    public void setClassesPerWeek(Integer classesPerWeek) {
    	this.classesPerWeek = classesPerWeek;
    }

	public Integer getDanceCourseTeacherId() {
		return danceCourseTeacherId;
	}

	public void setDanceCourseTeacherId(Integer danceCourseTeacherId) {
		this.danceCourseTeacherId = danceCourseTeacherId;
	}
    
}
