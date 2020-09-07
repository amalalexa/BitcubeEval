package com.bitcube.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/lecturer")
public class LecturerController {
	
	@GetMapping("/save_offer")
	public ResponseEntity<?> set_offers_details(@RequestBody )
	{
		try
		{
			String message=adminservice.set_offer(admin_offer_ui);
			return ResponseEntity.ok().body(message);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
