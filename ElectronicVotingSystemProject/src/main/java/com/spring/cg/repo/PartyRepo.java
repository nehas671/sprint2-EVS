package com.spring.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.cg.entity.PartysEntity;


public interface PartyRepo extends JpaRepository<PartysEntity,String>{

	List<PartysEntity> findBysymbol(String symbol);

	
	@Query("select new com.spring.cg.entity.PartysEntity(s.party_name,s.leader,s.symbol) from PartysEntity s where s.leader=?1")
	List<PartysEntity> findByleader(String leader);

	@Query("Select distinct c.party_name from PartysEntity c")
	List<String> getByParty_name();

	@Query("Select distinct c.symbol from PartysEntity c")
	List<String> getBySymbol();

	@Query("Select distinct c.leader from PartysEntity c")
	List<String> getByleader();
	
	
}
