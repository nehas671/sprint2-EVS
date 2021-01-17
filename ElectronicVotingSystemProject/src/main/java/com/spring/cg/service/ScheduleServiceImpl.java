package com.spring.cg.service;



import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.json.Election;
import com.spring.cg.json.Schedule;
import com.spring.cg.Myproperties;
import com.spring.cg.controller.ScheduleController;
import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.exception.ScheduleNotFound;
import com.spring.cg.repo.ScheduleRepo;
import com.spring.cg.utils.ScheduleUtil;


@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleRepo scheduleRepo;
	private static final Logger logger = LogManager.getLogger(ScheduleServiceImpl.class);

	@Autowired
	Myproperties properties;


	/*@Override
	public Schedule addSchedule(Schedule schedule) {
		ScheduleEntity scheduleEntity=
				scheduleRepo.save(new ScheduleEntity(schedule.getDate(), schedule.getElectionId(),schedule.getElectionName(),schedule.getState(),schedule.getConstituency()));
		return new Schedule(scheduleEntity.getDate(),scheduleEntity.getElectionId(),scheduleEntity.getElectionName(),scheduleEntity.getState(),scheduleEntity.getConstituency());
	}*/
	
	//finding schedule for elections for particular state 
	@Override
	public List<Schedule> viewByState(String state,LocalDate date) throws ScheduleNotFound{
		
		
		List<ElectionEntity> scheduleList=scheduleRepo.findByState(state,date);
		if(scheduleList.isEmpty() || scheduleList==null) {
			logger.error("Schedule " + properties.getLog().getNotFound() + " for state "+ state);
			throw new ScheduleNotFound("No elections scheduled for state:"  + state);				
		}
		else
		{
			logger.info(scheduleList);
			logger.info(properties.getLog().getFound());
			return ScheduleUtil.convertElectionEntityIntoScheduleList(scheduleRepo.findByState(state,date));
		}
	}
	
	//finding all scheduled elections
	@Override
	public List<Schedule> viewSchedule(LocalDate date) throws ScheduleNotFound{
		
		List<ElectionEntity> scheduleList=scheduleRepo.findAll(date);
		if(scheduleList.isEmpty() || scheduleList==null) {
			logger.error("Schedule " + properties.getLog().getNotFound());
			throw new ScheduleNotFound("Election not found");				
		}
		else
		{
			logger.info(scheduleList);
			logger.info(properties.getLog().getFound());
			return ScheduleUtil.convertElectionEntityIntoScheduleList(scheduleRepo.findAll(date));
		}
		
	}


	//finding list of all states
	@Override
	public List<String> viewAllStates() throws ScheduleNotFound {
		
		List<String> stateList = scheduleRepo.findAllStates();
		if(stateList.isEmpty() || stateList==null) {
			logger.error("No states found in list");
			throw new ScheduleNotFound("state list not found");
		}
		else {
			logger.info(stateList);
			logger.info(properties.getLog().getFound());
			return stateList;
		}
	}

	//finding schedule for elections within specific date range
	@Override
	public List<Schedule> viewByDateRange(LocalDate startdate,LocalDate enddate) throws ScheduleNotFound {
		
		List<ElectionEntity> scheduleList=scheduleRepo.findByDateRange(startdate,enddate);
		if(scheduleList.isEmpty() || scheduleList==null) {
			logger.error("Schedule " + properties.getLog().getNotFound() + " between "+ startdate +" and " + enddate);
			throw new ScheduleNotFound("No Elections scheduled between" + startdate + "and" + enddate);				
		}
		else
		{
			logger.info(scheduleList);
			logger.info(properties.getLog().getFound());
			return ScheduleUtil.convertElectionEntityIntoScheduleList(scheduleRepo.findByDateRange(startdate, enddate));
		}
		
	}

	//finding schedule for elections for particular election name
	@Override
	public List<Schedule> viewByElectionName(String electionName,LocalDate date) throws ScheduleNotFound {
		
		List<ElectionEntity> scheduleList=scheduleRepo.findByElectionName(electionName,date);
		if(scheduleList.isEmpty() || scheduleList==null) {
			logger.error("Schedule " + properties.getLog().getNotFound() + " for election name "+ electionName);
			throw new ScheduleNotFound("No Elections scheduled for given name" + electionName);				
		}
		else
		{
			logger.info(scheduleList);
			logger.info(properties.getLog().getFound());
			return ScheduleUtil.convertElectionEntityIntoScheduleList(scheduleRepo.findByElectionName(electionName,date));
		}
	}

	
	//finding schedule for elections for particular Constituency
	@Override
	public List<Schedule> viewByConstituency(String constituency,LocalDate date) throws ScheduleNotFound {
		
		List<ElectionEntity> scheduleList=scheduleRepo.findByConstituency(constituency, date);
		if(scheduleList.isEmpty() || scheduleList==null) {
			logger.error("Schedule " + properties.getLog().getNotFound() + " for constituency :" + constituency);
			throw new ScheduleNotFound("No Elections scheduled for given constituency " + constituency);				
		}
		else
		{
			logger.info(scheduleList);
			logger.info(properties.getLog().getFound());
			return ScheduleUtil.convertElectionEntityIntoScheduleList(scheduleRepo.findByConstituency(constituency, date));
		}
	}
	
	//finding schedule for elections for particular month
	@Override
	public List<Schedule> viewByMonth(String month,LocalDate date) throws ScheduleNotFound {
		
		List<ElectionEntity> scheduleList=scheduleRepo.findByMonth(month, date);
		if(scheduleList.isEmpty() || scheduleList==null) {
			logger.error("Schedule " + properties.getLog().getNotFound() + " for month " + month);
			throw new ScheduleNotFound("No Elections scheduled for given month " + month);				
		}
		else
		{
			logger.info(scheduleList);
			logger.info(properties.getLog().getFound());
			return ScheduleUtil.convertElectionEntityIntoScheduleList(scheduleRepo.findByMonth(month, date));
			
		}
		
	}

	@Override
	public List<String> findAllElectionNames() throws ScheduleNotFound {
		List<String> stateList = scheduleRepo.findAllElectionNames();
		if(stateList.isEmpty() || stateList==null) {
			logger.error("No election name found in list");
			throw new ScheduleNotFound("election name list not found");
		}
		else {
			logger.info(stateList);
			logger.info(properties.getLog().getFound());
			return stateList;
		}
	}

	@Override
	public List<String> findAllconstituency() throws ScheduleNotFound {
		List<String> stateList = scheduleRepo.findAllconstituency();
		if(stateList.isEmpty() || stateList==null) {
			logger.error("No constituencies found in list");
			throw new ScheduleNotFound("constituencies list not found");
		}
		else {
			logger.info(stateList);
			logger.info(properties.getLog().getFound());
			return stateList;
		}
	}

	@Override
	public List<LocalDate> findAllDate() throws ScheduleNotFound {
		List<LocalDate> stateList = scheduleRepo.findAllDate();
		if(stateList.isEmpty() || stateList==null) {
			logger.error("No dates found in list");
			throw new ScheduleNotFound("date list not found");
		}
		else {
			logger.info(stateList);
			logger.info(properties.getLog().getFound());
			return stateList;
		}
	}

	@Override
	public List<Schedule> findByDate(LocalDate date) throws ScheduleNotFound {
		List<ElectionEntity> scheduleList=scheduleRepo.findByDate(date);
		if(scheduleList.isEmpty() || scheduleList==null) {
			logger.error("Schedule " + properties.getLog().getNotFound() + " for date " + date);
			throw new ScheduleNotFound("No Elections scheduled for given date " + date);				
		}
		else
		{
			logger.info(scheduleList);
			logger.info(properties.getLog().getFound());
			return ScheduleUtil.convertElectionEntityIntoScheduleList(scheduleRepo.findByDate(date));
			
		}
	}

	@Override
	public List<String> findAllMonth() throws ScheduleNotFound {
		List<String> stateList = scheduleRepo.findAllMonth();
		if(stateList.isEmpty() || stateList==null) {
			logger.error("No months found in list");
			throw new ScheduleNotFound("month list not found");
		}
		else {
			logger.info(stateList);
			logger.info(properties.getLog().getFound());
			return stateList;
		}
	}




	
}
