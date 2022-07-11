package com.project1.shop.controller;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project1.shop.entity.Admin;
import com.project1.shop.entity.Jobs;
import com.project1.shop.entity.User;
import com.project1.shop.service.AdminService;
@Controller

public class RestController {
	
	public AdminService adminService;
	
	public RestController(AdminService theAdminService) {
		adminService = theAdminService;
	}
	
	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("http://localhost:8081");
			}
		};
	}
	
	@GetMapping("/admin/login")
	public String adminLogin(Model theModel) {
		return "";
	}
	
	@GetMapping("/admin/signup")
	public String adminReg(Model theModel) {
		return "";
	}
	
	@GetMapping("/admin/Profile")
	public String getAllServiceCenterDetails(Model theModel)
	{
		List<Admin> theAdmin;
		theAdmin = adminService.findAll();
		
		theModel.addAttribute("admin", theAdmin);
		return "employee-list";
	}
@GetMapping("/admin/addProfile")
	
	public String showFormForAdd(Model theModel) {
		
		Admin theAdmin = new Admin();
		theModel.addAttribute("admin", theAdmin);
		return "add-form";
	}
	@GetMapping("/admin/editProfile")
	
		public String showFormForUpdate(@RequestParam("id") int theId ,  Model theModel) {
		
			Admin theAdmin = adminService.findById(theId);
		
			theModel.addAttribute("admin", theAdmin);
			
			return "add-form";
		}
	
	
	@PostMapping("/admin/editProfile")

	public String save(@ModelAttribute("admin") Admin theAdmin) {
		try {
			adminService.save(theAdmin);
	
			return "redirect:/admin/Profile";
		}
		catch (Exception e) {
			return "redirect:/admin/profile";
		}
	}
	
@GetMapping("/admin/deleteProfile")
	
	public String deleteEmployee(@RequestParam("id") int theId ,Model theModel) {
		
		adminService.delete(theId);
		
		return "redirect:/admin/Profile";
	}
	
	
	
	
@GetMapping("/admin/getAllJob")
public String getJob(Model theModel)
{
	List<Jobs> theJob;
	theJob = adminService.findAllJob();
	
	theModel.addAttribute("job", theJob);
	return "cart";
}

	@GetMapping("/admin/editJob")

	public String editJob(@RequestParam("id") int theId ,  Model theModel) {

		Jobs theJob = adminService.findByJobId(theId);

		theModel.addAttribute("job", theJob);
	
		return "cart";
	}
	
	@PostMapping("/admin/editJob")

	public String saveJob(@ModelAttribute("jon") Jobs theJob) {
		try {
			adminService.save(theJob);

			return "redirect:/admin/getAllJob";
		}
		catch (Exception e) {
			return "redirect:/admin/getAllJob";
		}
	}
	
	
	@GetMapping("/admin/deleteJob")

	public String deleteJob(@RequestParam("id") int theId ,Model theModel) {
	
		adminService.deleteJob(theId);
	
		return "redirect:/admin/Profile";
	}
	
	@PostMapping("/admin/Login")
	public String Login(@ModelAttribute("admin") Admin theAdmin) {
		
		
		
		return "";
	}
}
