package com.spring.cg.repo;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.cg.entity.ElectionEntity;

public interface ElectionRepo extends JpaRepository<ElectionEntity,Long>{

	//Query To get All election By State
	@Query("select new com.spring.cg.entity.ElectionEntity(s.electionId,s.electionName,s.state,s.constituency,s.date) from ElectionEntity s where s.state=?1")
	List<ElectionEntity> findAllByState(String state);

	
	//Query To get All election By ElectionName
	@Query("select new com.spring.cg.entity.ElectionEntity(s.electionId,s.electionName,s.state,s.constituency,s.date) from ElectionEntity s where s.electionName=?1")
	List<ElectionEntity> findAllByElectionName(String electionName);

	
	//Query To get All election By Date
	@Query("select new com.spring.cg.entity.ElectionEntity(s.electionId,s.electionName,s.state,s.constituency,s.date) from ElectionEntity s where s.date=:date")
	List<ElectionEntity> findAllByDate(LocalDate date);

	//Query To get All election By Constituency
	@Query("select new com.spring.cg.entity.ElectionEntity(s.electionId,s.electionName,s.state,s.constituency,s.date) from ElectionEntity s where s.constituency=?1")
	List<ElectionEntity> findAllByConstituency(String constituency);

   @Query("Select distinct e.electionName from ElectionEntity e")
	public List<String> getAllElectionName();
   
   @Query("Select distinct e.state from ElectionEntity e")
	public List<String> getAllElectionState();
   
   @Query("Select distinct e.constituency from ElectionEntity e")
	public List<String> getAllConstituency();
   
   @Query("Select distinct e.date from ElectionEntity e")
  	public List<LocalDate> getAllDate();

	
	
}
