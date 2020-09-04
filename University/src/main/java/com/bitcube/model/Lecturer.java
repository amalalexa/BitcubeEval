package com.bitcube.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name="lecturerIdSeq", initialValue=1, allocationSize=2)
public class Lecturer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lecturerIdSeq")
	private long lecturerId;
	private String forenames;
	private String surname;
	private String emailId;
	private String dateOfBirth;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="degree_id")
	private List<Degree> degrees;
	
	private String firstName;
	private String fullName;
	
	public void setFirstName() {
		this.firstName = this.forenames.split(" ")[0];
	}
	
	public void setFullName() {
		this.fullName = this.forenames + " " + this.surname;
	}

}
