package com.spring.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.cg.entity.VoterIdEntity;

public interface VoterIdRepo extends JpaRepository<VoterIdEntity, Long> {
	List<VoterIdEntity> findByDistrict(String district);
	
	List<VoterIdEntity> findByStatus(String status);
	
	@Query("SELECT DISTINCT (e.district) from VoterIdEntity e")
	List<String> findAllDistricts();
	
	@Query("SELECT DISTINCT (e.status) from VoterIdEntity e")
	List<String> findAllStatus();
	
	VoterIdEntity findByEmailId(String emailId);

}
