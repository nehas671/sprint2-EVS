package com.spring.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.cg.entity.CandidateEntity;

public interface CandidateRepo extends JpaRepository<CandidateEntity, Integer>{

	
	
	List<CandidateEntity> findByCandidateName(String candidate_name);

	List<CandidateEntity> findByEmail(String email);

	List<CandidateEntity> findByContactNumber(String contact_number);

	@Query("Select distinct c.email from CandidateEntity c")
	List<String> getByEmail();

	@Query("Select distinct c.contactNumber from CandidateEntity c")
	List<String> getByContactNumber();
	
	@Query("Select distinct c.candidateName from CandidateEntity c")
	List<String> getByCandidateName();

	

}
 