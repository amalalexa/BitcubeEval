package com.bitcube.University.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcube.University.service.LecturerService;


@RestController
@RequestMapping("/api/lecturer")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@GetMapping("/savestudent")
	public ResponseEntity<?> saveStudent()
	{
		try
		{
			String message = lecturerService.saveStudentDetails();
			return ResponseEntity.ok().body(message);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
