package com.bitcube.University;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bitcube.University.view.InputStudentDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversityApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	ObjectMapper om = new ObjectMapper();
	
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testSaveStudent() throws Exception {
		
		InputStudentDetails inputStudentDetails = new InputStudentDetails();
		inputStudentDetails.setForename("Raj Kumar");
		inputStudentDetails.setSurname("Shenoy");
		inputStudentDetails.setEmailId("amal.alex24@gmail.com");
		inputStudentDetails.setDegreeId("D-1");
		inputStudentDetails.setDateOfBirth("2020-03-03");
		
		String jsonRequestBody = om.writeValueAsString(inputStudentDetails);
		
		MvcResult result = mockMvc.perform(
						   MockMvcRequestBuilders.post("/api/lecturer/savestudent").content(jsonRequestBody)
						   .contentType(MediaType.APPLICATION_JSON_VALUE))
					       .andExpect(MockMvcResultMatchers.status().isOk())
					       .andReturn();
		
		String resultResponse = result.getResponse().getContentAsString();
		System.out.println(resultResponse);
		assertEquals("Student Saved Successfully !!", resultResponse);
			
	}
	
	@Test
	public void testremoveStudent() throws Exception {
		
		
		MvcResult result = mockMvc.perform(
						   MockMvcRequestBuilders.delete("/api/lecturer/removestudent")
						   .header("studentId", "S-11"))
					       .andExpect(MockMvcResultMatchers.status().isOk())
					       .andReturn();
		
		String resultResponse = result.getResponse().getContentAsString();
		System.out.println(resultResponse);
		assertEquals("Student Deleted Successfully", resultResponse);
			
	}
	
	

}
