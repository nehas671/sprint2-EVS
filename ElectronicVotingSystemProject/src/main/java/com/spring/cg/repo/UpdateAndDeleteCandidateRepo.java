package com.spring.cg.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.cg.entity.CandidateEntity;






public interface UpdateAndDeleteCandidateRepo extends JpaRepository<CandidateEntity, Integer> {
	
	
	
	//To find Candidate by Email
	CandidateEntity findByEmail(String email);						
	
	
	
	//To delete Candidate by Email
	@Query("DELETE  FROM CandidateEntity q  WHERE q.email = ?1  ")
	CandidateEntity deleteByEmail(String email);		
	
	
	
}
