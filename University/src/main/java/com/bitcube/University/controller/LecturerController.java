package com.bitcube.University.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcube.University.service.LecturerService;
import com.bitcube.University.view.InputStudentDetails;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/lecturer")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@PostMapping("/savestudent")
	public ResponseEntity<String> saveStudent(@RequestBody InputStudentDetails inputStudentDetails )
	{
		try
		{
			String message = lecturerService.saveStudentDetails(inputStudentDetails);
			return ResponseEntity.ok().body(message);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/removestudent")
	public ResponseEntity<String> removeStudent(@RequestHeader("studentId") String studentId)
	{
		try
		{
			String message = lecturerService.removeStudentDetails(studentId);
			return ResponseEntity.ok().body(message);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@GetMapping("/students")
	public ResponseEntity<?> listOfStudents(@RequestHeader("lecturerId") String lecturerId, @RequestHeader("degreeId") String degreeId ){
		
		try {
			return ResponseEntity.ok().body(lecturerService.listOfStudents(lecturerId,degreeId));
		}
		catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/degrees")
	public ResponseEntity<?> listOfDegrees(@RequestHeader("lecturerId") String lecturerId){
		
		try {
			return ResponseEntity.ok().body(lecturerService.listOfDegrees(lecturerId));
		}
		catch(Exception e){
			
			return ResponseEntity.status(500).body(e.getMessage());
			
		}
	}
	
	@GetMapping("/degree/courses")
	public ResponseEntity<?> listOfCourses(@RequestHeader("degreeId") String degreeId){
		
		try {
			return ResponseEntity.ok().body(lecturerService.listOfCourses(degreeId));
		}catch (Exception e) {
			
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
