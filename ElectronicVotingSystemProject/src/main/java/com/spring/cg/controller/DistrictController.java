package com.spring.cg.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.entity.DistrictEntity;
import com.spring.cg.service.DistrictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/evs")
@CrossOrigin("*")
public class DistrictController {

	private static final Logger logger = LogManager.getLogger(DistrictController.class);
	
	@Autowired
	DistrictService districtService;
	
	@ApiOperation(value = "Returns All District")
	@GetMapping(value="/districts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DistrictEntity> getAllDistrcits() {
		return districtService.getAllDistrict();
	}
	}
