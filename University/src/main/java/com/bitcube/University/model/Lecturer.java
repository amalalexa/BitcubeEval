package com.bitcube.University.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="lecturer")
@Getter
@Setter
@SequenceGenerator(name="lecturerIdSeq", initialValue=1, allocationSize=1)
public class Lecturer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lecturerIdSeq")
	@Column(name="lecturer_id")
	private long lecturerId;
	
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
	
	public void setFirstName() {
		this.firstName = this.forenames.split(" ")[0];
	}
	
	public void setFullName() {
		this.fullName = this.forenames + " " + this.surname;
	}

}
