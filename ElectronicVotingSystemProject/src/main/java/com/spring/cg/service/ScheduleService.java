package com.spring.cg.service;



import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.spring.cg.json.Election;
import com.spring.cg.json.Schedule;
import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.exception.ScheduleNotFound;




public interface ScheduleService {

	//public Election addSchedule(Election election);
	
	List<Schedule> viewByState(String state,LocalDate date) throws ScheduleNotFound ;
	List<Schedule> viewByElectionName(String electionName,LocalDate date) throws ScheduleNotFound;
	List<Schedule> viewSchedule(LocalDate date) throws ScheduleNotFound;
	List<String> viewAllStates() throws ScheduleNotFound;
	List<String> findAllElectionNames() throws ScheduleNotFound;
	List<String> findAllconstituency() throws ScheduleNotFound;
	List<LocalDate> findAllDate() throws ScheduleNotFound;
	List<Schedule> viewByDateRange(LocalDate startdate,LocalDate enddate) throws ScheduleNotFound;
	List<Schedule> viewByConstituency(String constituency, LocalDate date) throws ScheduleNotFound;
	List<Schedule> viewByMonth(String month,LocalDate date) throws ScheduleNotFound;
	List<Schedule> findByDate(LocalDate date) throws ScheduleNotFound;
	List<String> findAllMonth() throws ScheduleNotFound;
}
