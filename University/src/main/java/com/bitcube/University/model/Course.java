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
@Table(name="course")
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
	
//	@Column(name="degree_id")
//	private Degree degreeId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="degree_id", referencedColumnName = "degree_id")
	private Degree degreeId;
	
}
