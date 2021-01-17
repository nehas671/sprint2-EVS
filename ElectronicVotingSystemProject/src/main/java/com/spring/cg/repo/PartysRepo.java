package com.spring.cg.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.cg.entity.PartyEntity;

public interface PartysRepo extends JpaRepository<PartyEntity, String>{

	
	Optional<PartyEntity> findByPartyName(String name);

	@Query("Select p.partyName from PartyEntity p")
	List<String> getByPartyName();
	
	
}