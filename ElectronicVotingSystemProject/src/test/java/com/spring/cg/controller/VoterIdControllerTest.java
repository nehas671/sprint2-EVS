package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.UserNotFoundException;
import com.spring.cg.json.VoterId;
import com.spring.cg.service.VoterIdService;
import com.spring.cg.service.VoterIdServiceImpl;

@SpringBootTest
public class VoterIdControllerTest {
	private static final Logger logger = LogManager.getLogger(VoterIdServiceImpl.class);
	@Autowired
	private VoterIdService voterIdService;

	@Autowired
	Myproperties properties;

	/*
	 * To Test viewing of voter id by application id
	 */
	@Test
	void testfindById() {
		logger.info("[START] Test to view voter id by application id");
		RestTemplate restTemplate = new RestTemplate();
		VoterId result = restTemplate.getForObject(properties.getLog().getLocalhost() + "8080/evs/user/voterId/110",
				VoterId.class);
		logger.info(properties.getLog().getFound());
		assertNotNull(result);
		logger.info("[END] Test to view voter id by application id");
	}

	@Test
	void testfindByIdFail1() {
		logger.info("[START] Test to view voter id by application id");
		RestTemplate restTemplate = new RestTemplate();

		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				() -> {

					restTemplate.getForObject(properties.getLog().getLocalhost() + "8080/evs/user/voterId/-1",
							VoterId.class);

				});
		logger.info("[END] Test to view voter id by application id");
	}

	@Test
	void testfindByIdFail2() {
		logger.info("[START] Test to view voter id by application id");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				() -> {

					restTemplate.getForObject(properties.getLog().getLocalhost() + "8080/evs/user/voterId/0",
							VoterId.class);

				});
		logger.info("[END] Test to view voter id by application id");
	}

	/*
	 * To Test viewing of voter voter requests by district
	 */
	@Test
	void testfindByDistrict() {
		logger.info("[START] Test to view voter requests by district");
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/evs/admin/voterRequest/bangalore",
				String.class);
		logger.info(properties.getLog().getFound());
		assertNotNull(result);
		logger.info("[END] Test to view voter requests by district");

	}

	@Test
	void testDistrictNotFound() {
		logger.info("[START] Test to view voter requests by district");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				() -> {

					restTemplate.getForObject(properties.getLog().getLocalhost() + "8080/evs/admin/voterRequest/agra",
							VoterId.class);

				});
		logger.info("[END] Test to view voter requests by district");
	}

	/*
	 * To Test viewing of all voter requests
	 */
	@Test
	void testviewAllRequests() {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/evs/admin/voterRequest", String.class);
		logger.info(properties.getLog().getFound());
		assertNotNull(result);
	}

	/*
	 * To Test viewing of voter voter requests by application status
	 */

	@Test
	void testfindByStatus() {
		logger.info("[START] Test to view voter requests by status");
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/evs/admin/voterRequestbystatus/pending",
				String.class);
		logger.info(properties.getLog().getFound());
		assertNotNull(result);
		logger.info("[END] Test to view voter requests by status");
		}

	@Test
	void testStatustNotFound() {
		logger.info("[START] Test to view voter requests by status");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				() -> {

					restTemplate.getForObject(
							properties.getLog().getLocalhost() + "8080/evs/admin/voterRequest/Approved", VoterId.class);

				});
		logger.info("[END] Test to view voter requests by status");
	}
}
