package com.spring.cg.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.utils.ElectionUtil;
import com.spring.cg.utils.PartyUtil;
import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.entity.PartysEntity;
import com.spring.cg.json.Election;
import com.spring.cg.json.Partys;
import com.spring.cg.repo.ElectionRepo;
import com.spring.cg.repo.PartyRepo;

@Service
public class PartyServiceImpl implements PartyService {

		@Autowired
		private PartyRepo partyrepo;
		
		@Autowired
		private ElectionRepo electionrepo;
		
		
	@Override
	public Partys createParty(Partys party) {
		// TODO Auto-generated method stub
		
		
		PartysEntity partysEntity = PartyUtil.convertPartyIntoPartysEntity(party);
		
		partysEntity=partyrepo.save(partysEntity);
		return ElectionUtil.convertPartysEntityIntoParty(partysEntity);
		
	}


	@Override
	public List<Partys> getAllParties() {
		// TODO Auto-generated method stub
		return   PartyUtil.convertPartysEntityListIntoPartyList(partyrepo.findAll());
	}


	@Override
	public List<Election> UpdateElection(@Valid Partys party) {
		// TODO Auto-generated method stub
		
		String p= party.getParty_name();
		
		System.out.println("PartyName :"+p);
		List<ElectionEntity> electionParty = new ArrayList<ElectionEntity>();
		
		List<ElectionEntity> electionEntityOp = electionrepo.findAll();
		
		System.out.println("all election.... "+electionEntityOp);
		
			//ElectionEntity electionEntity = electionEntityOp.get();
			
	
			Set<PartysEntity> parties = new HashSet<PartysEntity>();
			parties.add(ElectionUtil.convertPartyIntoPartysEntity(party));
			for(ElectionEntity e:  electionEntityOp)
			{
				e.setParty(parties);
				electionParty.add(electionrepo.save(e));
			}
			

			
			return PartyUtil.convertElectionEntityListIntoElectionList(electionParty);	
		
	
		
		
		
		
	}

	
	

	
	/*Optional<ElectionEntity> electionEntityOp = Partyrepo.findByPartyName();
	
	
	
	if(electionEntityOp.isPresent())
	{
		
		ElectionEntity electionEntity = electionEntityOp.get();
		
		ElectionUtil.convertPartyIntoPartysEntity(party) ;
		Set<PartysEntity> parties = new HashSet<PartysEntity>();
		parties.add(ElectionUtil.convertPartyIntoPartysEntity(party));
		electionEntity.setParty(parties);

		electionEntity=electionrepo.save(electionEntity);
		return PartyUtil.convertElectionEntityIntoElection(electionEntity);	
		
	}
	
	else
		return null;
	
	*/
	
	
	
	
	
	

	
	
}
