package com.bitcube.University.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetailsDao {
	
	public StudentDetailsDao(String studentId, String fullName)
	{
		this.fullName=fullName;
		this.studentId=studentId;
	}

	private String studentId;
	private String fullName;
}
