package com.bitcube.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name="studentIdSeq", initialValue=1, allocationSize=1)
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="studentIdSeq")
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
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="degree_id")
	private Degree degree;
	
	public void setFirstName() {
		this.firstName = this.forenames.split(" ")[0];
	}
	
	public void setFullName() {
		this.fullName = this.forenames+" "+this.surname;
	}
}

