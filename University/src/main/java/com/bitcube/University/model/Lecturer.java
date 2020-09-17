	package com.bitcube.University.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="lecturer")
@Getter
@Setter
public class Lecturer {

	@Id
    @GeneratedValue(generator = "lecturerId-generator")
    @GenericGenerator(name = "lecturerId-generator", 
      				  parameters = @Parameter(name = "prefix", value = "L"), 
      				  strategy = "com.bitcube.University.model.GenerateId")
	@Column(name="lecturer_id")
	private String lecturerId;
	
	private String forenames;
	private String surname;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@OneToMany(mappedBy="lecturer")
    Set<Degree> setOfDegrees = new HashSet<Degree>();
	
	public void setFirstName() {
		this.firstName = this.forenames.split(" ")[0];
	}
	
	public void setFullName() {
		this.fullName = this.forenames + " " + this.surname;
	}

}
