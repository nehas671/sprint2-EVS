package com.spring.cg.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.cg.entity.ElectionsEntity;

public interface ElectionRepository extends JpaRepository<ElectionsEntity, Integer> {

	@Query("Select new com.spring.cg.entity.ElectionsEntity(e.electionName, e.state, e.constituency, e.date) from ElectionsEntity e where UPPER(e.electionName) like %:electionName% AND UPPER(e.state) like %:state% AND UPPER(e.constituency) like %:constituency% AND e.date=:date")
	List<ElectionsEntity> findAll(@Param("electionName")String election_name, @Param("state")String state, @Param("constituency")String constituency, @Param("date")LocalDate date);
	
	@Query("Select distinct UPPER(e.electionName) from ElectionsEntity e order by UPPER(e.electionName)")
	public List<String> getAllElectionName();
}

