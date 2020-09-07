package com.bitcube.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name="degreeIdSeq", initialValue=1, allocationSize=1)
public class Degree {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="degreeIdSeq")
	@Column(name="degree_id")
	private long degreeId;
	
	@Column(name="degree_name")
	private String degreeName;
	
	@Column(name="degree_duration_in_years")
	private int degreeDurationInYears;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "degree")
	@JoinColumn(name="course_id")
	private List<Course> courses;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Lecturer lecturer;
	
}
