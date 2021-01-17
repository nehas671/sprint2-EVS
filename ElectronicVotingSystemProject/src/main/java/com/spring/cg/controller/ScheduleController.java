package com.spring.cg.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.ScheduleNotFound;
import com.spring.cg.json.Election;
import com.spring.cg.json.Schedule;
import com.spring.cg.service.ScheduleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value="Schedule related REST APIs")
public class ScheduleController {
	@Autowired
	Myproperties properties;
	@Autowired
	private ScheduleService scheduleService;
	private static final Logger logger = LogManager.getLogger(ScheduleController.class);
	//@PostMapping(value="/schedule",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<Schedule> addSchedule(@Valid @RequestBody Schedule schedule/*,  @RequestHeader("authToken") String authToken*/) {
	//	return new ResponseEntity<Schedule>(scheduleService.addSchedule(schedule), HttpStatus.OK);
		
	//}
	
	@ApiOperation(value="Returns schedule for specific state")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Election is present in schedule for specific state"),
			@ApiResponse(code=404, message="state not found")
	})
	//getting list of elections scheduled for given state
	@GetMapping(value="/schedule/state/{state}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Schedule> viewScheduleByState(@PathVariable(value="state") String state) throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" Schedule for state " + state);
		return scheduleService.viewByState(state,LocalDate.now());
		
	}
	
	
	@ApiOperation(value="Returns schedule ")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="schedule retrieved successfully"),
			@ApiResponse(code=404, message="schedule not found")
	})
	//getting list of all scheduled elections
	@GetMapping(value="/schedule",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Schedule> viewSchedule() throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" Schedule");
		return scheduleService.viewSchedule(LocalDate.now());
		
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Election with specific name is present in schedule"),
			@ApiResponse(code=404, message="Election name not found")
	})
	@ApiOperation(value="Returns schedule for specific name")
	//getting list of elections scheduled for given election name
	@GetMapping(value="/schedule/name/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Schedule> viewScheduleById(@PathVariable(value="name") String electionName) throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" Schedule for election name " + electionName);
		return scheduleService.viewByElectionName(electionName,LocalDate.now());
		
	}
	
	
	@ApiOperation(value="Returns list of all states ")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="state list retrieved successfully"),
			@ApiResponse(code=404, message="state list not found")
	})
	//getting list of all states
	@GetMapping(value="/schedule/statelist", produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<String> findAllByState() throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" list of states");
		return scheduleService.viewAllStates();
	}
	
	
	@ApiOperation(value="Returns schedule for specific date ")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="schedule for date found"),
			@ApiResponse(code=404, message="schedule for date not found")
	})
	//getting list of elections scheduled within given date range
	@GetMapping(value="/schedule/date/{startdate}/{enddate}", produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<Schedule> findAllByDateRange(@PathVariable(value="startdate") @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate startdate,@PathVariable(value="enddate")  @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate enddate) throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" Schedule for date between " + startdate + " and " + "enddate");
		return scheduleService.viewByDateRange(startdate,enddate);
	}
	
	
	@ApiOperation(value="Returns schedule for specific constituency ")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="schedule for constituency found"),
			@ApiResponse(code=404, message="schedule for constituency not found")
	})
	//getting list of elections scheduled for given constituency
	@GetMapping(value="/schedule/constituency/{constituency}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Schedule> viewScheduleByConstituency(@PathVariable(value="constituency") String constituency) throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" Schedule for constituency " + constituency);
		return scheduleService.viewByConstituency(constituency,LocalDate.now() );
		
	}
	
	@ApiOperation(value="Returns schedule for specific month ")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="schedule for month found"),
			@ApiResponse(code=404, message="schedule for month not found")
	})
	//getting list of elections scheduled for given month
	@GetMapping(value="/schedule/month/{month}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Schedule> findAll(@PathVariable(value="month") String month) throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" Schedule for month " + month);
		return scheduleService.viewByMonth(month,LocalDate.now());
		
	}
	
	@ApiOperation(value="Returns list of all election names ")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="election names list retrieved successfully"),
			@ApiResponse(code=404, message="election names list not found")
	})
	//getting list of all names
	@GetMapping(value="/schedule/namelist", produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<String> findAllElectionNames() throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" list of election names");
		return scheduleService.findAllElectionNames();
	}
	
	@ApiOperation(value="Returns list of all constituency")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="constituency list retrieved successfully"),
			@ApiResponse(code=404, message="constituency list not found")
	})
	//getting list of all constituency
	@GetMapping(value="/schedule/constituencylist", produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<String> findAllconstituency() throws ScheduleNotFound{
		logger.info(properties.getLog().getView()+" list of election names");
		return scheduleService.findAllconstituency();
	}
	
	//getting list of all dates
		@GetMapping(value="/schedule/datelist", produces=MediaType.APPLICATION_JSON_VALUE)
		public  List<LocalDate> findAllDates() throws ScheduleNotFound{
			logger.info(properties.getLog().getView()+" list of election names");
			return scheduleService.findAllDate();
		}
		
		//getting list of elections scheduled for given date
		@GetMapping(value="/schedule/dates/{date}",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Schedule> findByDate(@DateTimeFormat(pattern ="yyyy-MM-dd") @PathVariable(value="date") LocalDate date) throws ScheduleNotFound{
			logger.info(properties.getLog().getView()+" Schedule for constituency " + date);
			return scheduleService.findByDate(date);
			
		}
		
		//getting list of all months
				@GetMapping(value="/schedule/monthlist", produces=MediaType.APPLICATION_JSON_VALUE)
				public  List<String> findAllMonth() throws ScheduleNotFound{
					logger.info(properties.getLog().getView()+" list of election months");
					return scheduleService.findAllMonth();
				}
}
