package rs.itakademija.DanceLessons.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CustomerHasDanceCourseDTO {
	
	private Integer id;
	private Set<Integer> customerId;
	private Set<Integer> danceCourseId;
	private Integer classesBought;
	
    public Integer getId() {
    	return this.id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
	
	public Set<Integer> getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Set<Integer> customerId) {
		this.customerId = customerId;
	}
	
	public Set<Integer> getDanceCourseId() {
		return danceCourseId;
	}
	
	public void setDanceCourseId(Set<Integer> danceCourseId) {
		this.danceCourseId = danceCourseId;
	}
	
	public Integer getClassesBought() {
		return classesBought;
	}
	
	public void setClassesBought(Integer classesBought) {
		this.classesBought = classesBought;
	}
	
}
