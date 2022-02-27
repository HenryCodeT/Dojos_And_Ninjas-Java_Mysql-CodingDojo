package com.codingdojo.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="ninjas")
public class Ninja {
	
	// //// VARIABLES ////
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@NotBlank(message = "ldap field should not be empty")
	private String firstName;
	
	@NotNull
	@NotBlank(message = "ldap field should not be empty")
	private String lastName;
	
	@NotNull
	@Min(value=1, message="Agrege una edad valida")
	private Long age;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	// //// MANY TO ONE ////
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
	@NotNull(message = "agregar un dojo")
    private Dojo dojo;

	// //// CONTRUCTORS ////
    public Ninja() {

    }
    // //// GETTERS AND SETTERS

    public Long getId() {
    	return id;
    }

	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Long getAge() {
		return age;
	}



	public void setAge(Long age) {
		this.age = age;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	// //// CONFIGURATION CREATED AT UPDATED AT ////////
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
		
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
}
