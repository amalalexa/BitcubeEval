package com.bitcube.University.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="degree")
@Getter
@Setter
@SequenceGenerator(name="degreeIdSeq", initialValue=1, allocationSize=1)
public class Degree {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="degreeIdSeq")
	@Column(name="degree_id")
	private int degreeId;
	
	@Column(name="degree_name")
	private String degreeName;
	
	@Column(name="degree_duration_in_years")
	private int degreeDurationInYears;
	
//	@Column(name="lecturer_id")
//	private Lecturer lecturerId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
	private Lecturer lecturerId;
	
}
