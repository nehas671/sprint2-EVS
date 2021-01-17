package com.spring.cg.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByEmailId(String emailId);
	
}
