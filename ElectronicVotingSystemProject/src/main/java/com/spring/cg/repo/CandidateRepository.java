package com.spring.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.cg.entity.CandidatezEntity;

public interface CandidateRepository extends JpaRepository<CandidatezEntity, Integer> {

}
