package com.spring.cg.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cg.entity.DistrictEntity;

public interface DistrictRepo extends JpaRepository<DistrictEntity , String> {

}
