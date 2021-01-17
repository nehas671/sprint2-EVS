package com.spring.cg.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.cg.entity.CastVoteEntity;

public interface CastVoteRepository extends JpaRepository<CastVoteEntity, Integer>
{
	@Query("select new com.spring.cg.entity.CastVoteEntity(c.candidateName, p.partyName) from PartyzEntity p JOIN p.candidate c JOIN p.election e where UPPER(e.electionName) like %:electionName% AND UPPER(e.constituency) like %:constituency% AND e.date=:date")
	
	public List<CastVoteEntity> getAllCastVote(@Param("electionName")String election_name, @Param("constituency")String constituency, @Param("date")LocalDate date);

	@Query("Select new com.spring.cg.entity.CastVoteEntity(cv.electionName, cv.state, cv.constituency, cv.date, cv.candidateName, cv.partyName, cv.voterId) from CastVoteEntity cv where UPPER(cv.electionName) like %:electionName% AND UPPER(cv.constituency) like %:constituency% AND cv.date=:date AND cv.voterId=:voterId")
	public List<CastVoteEntity> findAll(@Param("electionName")String election_name, @Param("constituency")String constituency, @Param("date")LocalDate date, @Param("voterId")int voter_id);

}