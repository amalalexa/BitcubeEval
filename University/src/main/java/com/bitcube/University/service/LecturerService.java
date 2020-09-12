package com.bitcube.University.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcube.University.Exception.LecturerNoDegreeException;
import com.bitcube.University.dao.DegreeDetailsDao;
import com.bitcube.University.dao.StudentDetailsDao;
import com.bitcube.University.model.Student;
import com.bitcube.University.repository.DegreeRepository;
import com.bitcube.University.repository.StudentRepository;
import com.bitcube.University.view.OutputStudentDetailsView;

@Service
public class LecturerService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DegreeRepository degreeRepository;
	
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
	
	public List<OutputStudentDetailsView> listOfStudents(String lecturerId) throws LecturerNoDegreeException{
		
		List<OutputStudentDetailsView> studentDetails=new ArrayList<OutputStudentDetailsView>();
 		List<DegreeDetailsDao> listOfDegreeId = degreeRepository.findDegreeIdBasedOnLecturerId(lecturerId);
		
		if(listOfDegreeId == null) {
			
			throw new LecturerNoDegreeException("No Degrees associated with the lecturer !!!");
		}
		System.out.println(listOfDegreeId);
		
		listOfDegreeId.stream().forEach(degreeObject -> {
			
			List<StudentDetailsDao> temp = studentRepository.findSudentDetails(degreeObject.getDegreeId());
			OutputStudentDetailsView studentDetailsView;
			
			for(StudentDetailsDao studentObject:temp){
				
				studentDetailsView=new OutputStudentDetailsView();
				
				studentDetailsView.setStudentId(studentObject.getStudentId());
				studentDetailsView.setStudentName(studentObject.getFullName());
				studentDetailsView.setDegreeName(degreeObject.getDegreeName());
				
				studentDetails.add(studentDetailsView);
			}		
		});
		
		return studentDetails;
	}
}
