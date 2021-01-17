package com.spring.cg.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.VoterRequestEntity;
import com.spring.cg.json.VoterRequest;

public interface VoterRequestRepo extends JpaRepository<VoterRequestEntity, Integer >{

	Optional<VoterRequestEntity> findByEmailId(String emailId);
}
