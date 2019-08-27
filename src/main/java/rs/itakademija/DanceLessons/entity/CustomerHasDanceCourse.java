package rs.itakademija.DanceLessons.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer_has_dance_course", catalog = "dance_lessons_subscription")
public class CustomerHasDanceCourse implements Serializable {

	private static final long serialVersionUID = 7517405430564138897L;
	
	private Integer id;
	private Integer customerId;
	private Integer danceCourseId;
	private Integer classesBought;
	
	public CustomerHasDanceCourse() {}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
    	return this.id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
	@JoinColumn(name = "customer_id")
	public Integer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	@JoinColumn(name = "dance_course_id")
	public Integer getDanceCourseId() {
		return danceCourseId;
	}
	
	public void setDanceCourseId(Integer danceCourseId) {
		this.danceCourseId = danceCourseId;
	}
	
	@Column(name = "classes_bought", nullable = false)
	public Integer getClassesBought() {
		return classesBought;
	}
	
	public void setClassesBought(Integer classesBought) {
		this.classesBought = classesBought;
	}

}
