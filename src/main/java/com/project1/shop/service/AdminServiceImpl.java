package com.project1.shop.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project1.shop.dao.AdminRepository;
import com.project1.shop.dao.OrderRepository;
import com.project1.shop.entity.Admin;
import com.project1.shop.entity.Jobs;


@Service
public class AdminServiceImpl implements AdminService {
	
	//define field for DAO
	AdminRepository adminRepository;
	OrderRepository orderRepository;
	// constructor injection
	
	@Autowired
	public AdminServiceImpl(AdminRepository theAdminRepository, OrderRepository theOrderRepository) {
		adminRepository = theAdminRepository;
		orderRepository = theOrderRepository;
	}

	@Override
	@Transactional
	public List<Admin> findAll() {
		
		return adminRepository.findAll();
	}

	@Override
	@Transactional
	public Admin findById(int theId) {
		
		
		Optional<Admin> result = adminRepository.findById(theId);
		
		Admin theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			//do not find the employee
			throw new RuntimeException("can\'t find the employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Admin theAdmin) {
		adminRepository.save(theAdmin);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		adminRepository.deleteById(theId);

	}
	
	@Override
	@Transactional
	public void save(Jobs theJobs) {
		orderRepository.save(theJobs);
	}
	
	
	@Override
	@Transactional
	public void deleteJob(int theId) {
		orderRepository.deleteById(theId);
		
	}

	@Override
	public List<Jobs> findAllJob() {
		
		return orderRepository.findAll();
	}
	
	@Override
	public Jobs findByJobId(int theId) {
		
		Optional<Jobs> result = orderRepository.findById(theId);
		
		Jobs theJob = null;
		
		if(result.isPresent()) {
			theJob = result.get();
		}
		else {
			//do not find the employee
			throw new RuntimeException("can\'t find the employee id - " + theId);
		}
		
		return theJob;
		
	}


	
	
	

}
