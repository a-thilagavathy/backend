package com.project1.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSide {

	@GetMapping("/user/dashboard")
	public String getListOfJobsPosted()
	{
		return "Hello World";
	}
}