package com.bitcube.University.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="student")
public class Student {
	
	@Id
    @GeneratedValue(generator = "studentId-generator")
    @GenericGenerator(name = "studentId-generator", 
      				  parameters = @Parameter(name = "prefix", value = "S"), 
      				  strategy = "com.bitcube.University.model.GenerateId")
	@Column(name="student_id")
	private String studentId;
	
	private String forenames;
	private String surname;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "degree_id", referencedColumnName = "degree_id")
	private Degree degreeId;
	
	public void setFirstName() {
		this.firstName = this.forenames.split(" ")[0];
	}
	
	public void setFullName() {
		this.fullName = this.forenames+" "+this.surname;
	}
}

