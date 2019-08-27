package rs.itakademija.DanceLessons.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer", catalog = "dance_lessons_subscription")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String name;
    private String surname;
    private String accountName;
    private String password;
    private String email;
    private String bankCardNumber;
    
    public Customer() {}
    
    public Customer(String name, String surname, String accountName, String password, String email, String bankCardNumber) {
        this.name = name;
        this.surname = surname;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
        this.bankCardNumber = bankCardNumber;
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
    
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
    	return this.surname;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    @Column(name = "account_name", nullable = false, unique = true, length = 45)
    public String getAccountName() {
    	return this.accountName;
    }
    
    public void setAccountName(String accountName) {
    	this.accountName = accountName;
    }
    
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    @Column(name = "email", nullable = false, unique = true, length = 45)
    public String getEmail() {
    	return this.email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    @Column(name = "bank_card_number", nullable = false, length = 16)
    public String getBankCardNumber() {
    	return this.bankCardNumber;
    }
    
    public void setBankCardNumber(String bankCardNumber) {
    	this.bankCardNumber = bankCardNumber;
    }
    
    @Override
    public String toString() {
    	return "Customer's name is: " + getName() + ", surname: " + getSurname() + ", email: " + getEmail() + 
    			", account name: " + getAccountName() + ", password: " + getPassword() + " and bank card number: " 
    				+ getBankCardNumber();
    }

}
