package com.spring.cg.controller;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.exception.ScheduleNotFound;
import com.spring.cg.json.Schedule;
import com.spring.cg.service.ElectionService;
import com.spring.cg.service.ScheduleService;
import com.spring.cg.service.ScheduleServiceImpl;

@SpringBootTest
public class ScheduleControllerTest {
	@Autowired
	private ScheduleService scheduleService;
	private static final Logger logger = LogManager.getLogger(ScheduleController.class);
	
	@Autowired
	Myproperties properties;
	
	//Testing  the method view by state by entering state present in DB
	@Test
	void testfindByState() {
		logger.info("[START] Test to get data by entering correct state");
		RestTemplate restTemplate = new RestTemplate();
		Schedule schedule[]= restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/state/Kerala",Schedule[].class);
		assertNotNull(schedule);
		logger.info("[END] Test to get data by entering correct state");
	}
	
	//Testing  the method view by state by entering state not present in DB-expected to throw ScheduleNotFound exception
	@Test
	void testfindByIncorrectState() {
		logger.info("[START] Test to get data by entering incorrect state");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/state/Rajasthan",Schedule[].class);
		});
		logger.info("[END] Test to get data by entering incorrect state");		
	}
	
	//Testing  the method view by name by entering name present in DB
	@Test
	void testfindByElectionName() {
		logger.info("[START] Test to get data by entering correct election name");
		RestTemplate restTemplate = new RestTemplate();
		Schedule schedule[]= restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/name/loksabha",Schedule[].class);
		assertNotNull(schedule);
		logger.info("[END] Test to get data by entering correct election name");
	}
	
	//Testing  the method view by name by entering name not present in DB-expected to throw ScheduleNotFound exception
	@Test
	void testfindByIncorrectElectionName() {
		logger.info("[START] Test to get data by entering incorrect election name");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/name/vidhansabha",Schedule[].class);
		});
		logger.info("[END] Test to get data by entering incorrect election name");		
	}
	
	//Testing  the method view by constituency by entering constituency present in DB
	@Test
	void testfindByConstituency() {
		logger.info("[START] Test to get data by entering correct constituency");
		RestTemplate restTemplate = new RestTemplate();
		Schedule schedule[]= restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/constituency/Kannur",Schedule[].class);
		assertNotNull(schedule);
		logger.info("[END] Test to get data by entering correct constituency");
	}
	
	//Testing  the method view by constituency by entering constituency not presnt in DB-expected to throw ScheduleNotFound exception
	@Test
	void testfindByIncorrectConstituency() {
		logger.info("[START] Test to get data by entering incorrect constituency");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/constituency/Karanpur",Schedule[].class);
		});
		logger.info("[END] Test to get data by entering incorrect constituency");	
	}
	
	//Testing  the method view by date by entering date range present in DB
	@Test
	void testfindByDate() {
		logger.info("[START] Test to get data by entering correct date range");
		RestTemplate restTemplate = new RestTemplate();
		Schedule schedule[]= restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/date/2021-01-01/2021-06-10",Schedule[].class);
		assertNotNull(schedule);
		logger.info("[END] Test to get data by entering correct date range");
	}
	
	//Testing  the method view by date by entering date range not present in DB-expected to throw ScheduleNotFound exception
	
	@Test
	void testfindByIncorrectDate() {
		logger.info("[START] Test to get data by entering incorrect date range");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/date/2021-10-01/2021-12-10",Schedule[].class);
		});
		logger.info("[END] Test to get data by entering incorrect date range");		
	}
	
	//Testing  the method view by month by entering month present in DB
	@Test
	void testfindByMonth() {
		logger.info("[START] Test to get data by entering correct month");
		RestTemplate restTemplate = new RestTemplate();
		Schedule schedule[]= restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/month/3",Schedule[].class);
		assertNotNull(schedule);
		logger.info("[END] Test to get data by entering correct month");
	}
	
	//Testing  the method view by month by entering month not present in DB-expected to throw ScheduleNotFound exception
		@Test
		void testfindByIncorrectMonth() {
			logger.info("[START] Test to get data by entering incorrect month");
			RestTemplate restTemplate = new RestTemplate();
			Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
				restTemplate.getForObject(properties.getLog().getLocalhost()+"8080/evs/schedule/month/13",Schedule[].class);
			});
			logger.info("[END] Test to get data by entering incorrect month");		
		}
}
