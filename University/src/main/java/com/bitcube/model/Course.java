package com.bitcube.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name="courseIdSeq", initialValue=1, allocationSize=2)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="courseIdSeq")
	private long courseId;
	
	private String courseName;
	
	private int courseDurationInMonths;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "courses")
	private Degree degree;
}
