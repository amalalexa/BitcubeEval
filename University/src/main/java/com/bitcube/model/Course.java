package com.bitcube.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name="courseIdSeq", initialValue=1, allocationSize=1)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="courseIdSeq")
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	
	@Column(name="course_duration_in_months")
	private int courseDurationInMonths;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Degree degree;
}
