package com.example.Shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin {

	@GetMapping("/admin/Profile")
	public String getAllServiceCenterDetails()
	{
		return "Hello World";
	}
	
	@GetMapping("/admin/getAllJobs")
	public String getTheListOfJobs()
	{
		return "Hello World";
	}
	
	@GetMapping("/admin/editJob/{id}")
	public String get()
	{
		return "Hello World";
	}
}
