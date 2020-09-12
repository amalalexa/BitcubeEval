package com.bitcube.University.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DegreeDetailsDao {
	
	public DegreeDetailsDao(String degreeId, String degreeName) {
		this.degreeId = degreeId;
		this.degreeName = degreeName;
	}
	private String degreeId;
	private String degreeName;

}
