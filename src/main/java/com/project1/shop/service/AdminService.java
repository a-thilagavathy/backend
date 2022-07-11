package com.project1.shop.service;


import java.util.List;
import java.util.Optional;

import com.project1.shop.entity.Admin;
import com.project1.shop.entity.Jobs;

public interface AdminService {
	
	public List<Admin> findAll();
	
	public Admin findById(int theId);
	
	public void save(Admin theAdmin);
	
	public void delete(int theId);
	
	public void save(Jobs theJobs);
	
	
	public List<Jobs> findAllJob();
	
	public Jobs findByJobId(int theId);
	
	
	public void deleteJob(int theId);
	
	
	 
}
