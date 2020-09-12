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
@Table(name="degree")
@Getter
@Setter
public class Degree {
	
	@Id
    @GeneratedValue(generator = "degreeId-generator")
    @GenericGenerator(name = "degreeId-generator", 
      				  parameters = @Parameter(name = "prefix", value = "D"), 
      				  strategy = "com.bitcube.University.model.GenerateId")
	@Column(name="degree_id")
	private String degreeId;
	
	@Column(name="degree_name")
	private String degreeName;
	
	@Column(name="degree_duration_in_years")
	private int degreeDurationInYears;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lecturer_id")
	private Lecturer lecturer;
	
}
