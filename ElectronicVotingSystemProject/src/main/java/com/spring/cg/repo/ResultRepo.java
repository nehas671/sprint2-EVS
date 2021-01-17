package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.cg.entity.ResultEntity;

import java.util.*;


public interface ResultRepo extends JpaRepository<ResultEntity, Integer>{

//Query to get the votes of the candidates in a election based on electionName and StateName
@Query("SELECT new com.spring.cg.entity.ResultEntity(c.electionName,c.state,c.date,c.constituency,c.candidateName,c.partyName,count(c.voterId)) "
		+ "from CastVoteEntity c GROUP BY c.electionName,c.state,c.date,c.constituency,c.candidateName,c.partyName "
		+ "having c.electionName=:election_name AND c.state=:state")
public List<ResultEntity> getAllResult(@Param("election_name") String electionname ,@Param("state") String statename);

//to view the result by of the Election by stateName
public List<ResultEntity> findByState(String statename );

//to view the result by of the Election by PartyName
@Query("select r from ResultEntity r where party_name=?1")
public List<ResultEntity> findByPartyName(String partyname);

//to view the result by of the Election by ElectionName
@Query("select r from ResultEntity r where election_name=?1")
public List<ResultEntity> findByElectionName(String electionname);


@Query("SELECT Distinct s.state FROM  ResultEntity s")
public List<String> findDistinctState();


@Query("SELECT Distinct e.election_name FROM  ResultEntity e")
public List<String> findDistinctElection();


@Query("SELECT Distinct p.party_name FROM  ResultEntity p")
public List<String> findDistinctParty();


@Query("SELECT Distinct c.electionName FROM  CastVoteEntity c")
public List<String> getElectionByCast();

}

