package com.spring.cg.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.RegisterUserEntity;

public interface RegisterUserRepo extends JpaRepository<RegisterUserEntity, Integer > {

	Optional<RegisterUserEntity> findByEmailId(String emailId);
}

