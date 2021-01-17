package com.spring.cg.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.DistrictEntity;
import com.spring.cg.repo.DistrictRepo;

@Service
public class DistrictServiceImpl implements DistrictService {

	private static final Logger logger = LogManager.getLogger(DistrictServiceImpl.class);
	
	@Autowired
	DistrictRepo districtRepo;

	@Override
	public List<DistrictEntity> getAllDistrict() {
		List<DistrictEntity> entityList = districtRepo.findAll();
		return entityList;
	}
	
	
}
