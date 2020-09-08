package com.bitcube.University.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcube.University.model.Student;
import com.bitcube.University.repository.StudentRepository;

@Service
public class LecturerService {

	@Autowired
	private StudentRepository studentRepository;
	
	public String saveStudentDetails() {
		
		Student student=new Student();
		
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        
		student.setDateOfBirth(date);
		student.setDegreeId(null);
		student.setEmailId("amal@gmail.com");
		student.setForenames("amal alex");
		student.setSurname("arackanatil");
		student.setFullName();
		student.setFirstName();
		
		System.out.println(student.getFullName());
		System.out.println(student.getFirstName());
		studentRepository.save(student);
		
		return "Perfect";
	}
}
