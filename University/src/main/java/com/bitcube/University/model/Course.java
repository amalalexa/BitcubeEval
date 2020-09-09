package com.bitcube.University.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="course")
@Getter
@Setter
public class Course {

	@Id
    @GeneratedValue(generator = "courseId-generator")
    @GenericGenerator(name = "courseId-generator", 
      				  parameters = @Parameter(name = "prefix", value = "C"), 
      				  strategy = "com.bitcube.University.model.GenerateId")
	@Column(name="course_id")
	private String courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	
	@Column(name="course_duration_in_months")
	private int courseDurationInMonths;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="degree_id", referencedColumnName = "degree_id")
	private Degree degreeId;
	
}
