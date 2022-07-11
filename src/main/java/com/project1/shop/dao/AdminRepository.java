package com.project1.shop.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project1.shop.entity.Admin;

@Component
public interface AdminRepository extends JpaRepository<Admin, Integer> {


}
