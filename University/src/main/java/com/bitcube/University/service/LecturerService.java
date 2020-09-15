package com.bitcube.University.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcube.University.Exception.DegreeNoCourseException;
import com.bitcube.University.Exception.LecturerNoDegreeException;
import com.bitcube.University.dao.DegreeDetailsDao;
import com.bitcube.University.dao.StudentDetailsDao;
import com.bitcube.University.model.Course;
import com.bitcube.University.model.Degree;
import com.bitcube.University.model.Student;
import com.bitcube.University.repository.CourseRepository;
import com.bitcube.University.repository.DegreeRepository;
import com.bitcube.University.repository.StudentRepository;
import com.bitcube.University.util.BeanUtil;
import com.bitcube.University.view.OutputCourseDetailsView;
import com.bitcube.University.view.OutputDegreeDetailsView;
import com.bitcube.University.view.OutputStudentDetailsView;

@Service
public class LecturerService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DegreeRepository degreeRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public String saveStudentDetails() {
		
		Student student=new Student();
		
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        
		student.setDateOfBirth(date);
		student.setDegree(null);
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

	public List<OutputDegreeDetailsView> listOfDegrees(String lecturerId) {
		
		List<OutputDegreeDetailsView> degreeDetails=new ArrayList<OutputDegreeDetailsView>();
		
		List<Degree> listOfDegrees=degreeRepository.findDegreeDetails(lecturerId);
		
		
		listOfDegrees.stream().forEach(object -> {
			
			OutputDegreeDetailsView temp=new OutputDegreeDetailsView();
			
			temp.setDegreeId(object.getDegreeId());
			temp.setDegreeName(object.getDegreeName());
			temp.setDegreeDurationInYears(object.getDegreeDurationInYears());
			
			degreeDetails.add(temp);
		});
		
		return degreeDetails;
	}
	
	public List<OutputCourseDetailsView> listOfCourses(String degreeId) throws DegreeNoCourseException{
		
		List<OutputCourseDetailsView> courseDetails=new ArrayList<OutputCourseDetailsView>();
		
		List<Course> listOfCourses=this.courseRepository.findAllCourseBasedOnDegreeId(degreeId);
		
		if(listOfCourses==null)
			throw new DegreeNoCourseException("No courses associated with Degree");
		
		listOfCourses.stream().forEach(courseObject -> {
			OutputCourseDetailsView object=new OutputCourseDetailsView();
			BeanUtils.copyProperties(courseObject,object);
			courseDetails.add(object);
		});
		
		return courseDetails;
		
	}
}
