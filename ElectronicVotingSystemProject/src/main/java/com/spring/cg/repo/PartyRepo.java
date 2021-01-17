package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.PartysEntity;


public interface PartyRepo extends JpaRepository<PartysEntity,String>{
	
	
}
