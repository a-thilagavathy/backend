package com.project1.shop.dao;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project1.shop.entity.User;

@Component
public interface UserRepository extends JpaRepository<User , Integer > {
	Optional<User> findByUsername(String username);
}
