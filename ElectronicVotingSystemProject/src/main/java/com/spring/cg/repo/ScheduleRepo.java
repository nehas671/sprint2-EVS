package com.spring.cg.repo;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.cg.entity.ElectionEntity;



//public interface ScheduleRepo extends JpaRepository<ScheduleEntity, Long>{
public interface ScheduleRepo extends JpaRepository<ElectionEntity, Long>{
	//finding schedule for elections for particular state order by date
	@Query("SELECT e FROM ElectionEntity e WHERE e.state=?1 AND e.date>?2 ORDER BY e.date")
	List<ElectionEntity> findByState(String state,LocalDate date);
	
	//finding schedule for elections for particular election order by date
	@Query("SELECT e FROM ElectionEntity e WHERE e.electionName=?1 AND e.date>?2 ORDER BY e.date")
	List<ElectionEntity> findByElectionName(String electionName,LocalDate date);
	
	//finding schedule for all scheduled elections order by date
	@Query("SELECT e FROM ElectionEntity e WHERE e.date>?1 ORDER BY e.date")
	List<ElectionEntity> findAll(LocalDate date);
	
	//finding list of all states
	@Query("SELECT DISTINCT(e.state) FROM ElectionEntity e")
	List<String> findAllStates();
	
	//finding list of all election names
	@Query("SELECT DISTINCT(e.electionName) FROM ElectionEntity e")
	List<String> findAllElectionNames();
	
	//finding list of all constitueny
		@Query("SELECT DISTINCT(e.constituency) FROM ElectionEntity e")
		List<String> findAllconstituency();
		
		//finding list of all date
				@Query("SELECT DISTINCT(e.date) FROM ElectionEntity e")
				List<LocalDate> findAllDate();
				
		//finding list of all date
		@Query("SELECT DISTINCT(TRIM(to_char(e.date,'MONTH') ))  FROM ElectionEntity e")
		List<String> findAllMonth();
	
	//finding schedule for elections within specific date range
	@Query("SELECT e FROM ElectionEntity e WHERE e.date BETWEEN :startdate AND :enddate ORDER BY e.date")
	List<ElectionEntity> findByDateRange(LocalDate startdate,LocalDate enddate);
	
	//finding schedule for elections for particular constituency order by date
	@Query("SELECT e FROM ElectionEntity e WHERE e.constituency=?1 AND e.date>?2 ORDER BY e.date")
	List<ElectionEntity> findByConstituency(String constituency,LocalDate date);
	
	//finding schedule for elections for particular month
	@Query("SELECT e FROM ElectionEntity e WHERE TRIM(to_char(e.date,'MONTH'))=?1 AND e.date>?2")
	List<ElectionEntity> findByMonth(String month,LocalDate date);
	
	//finding by date
	@Query("SELECT e FROM ElectionEntity e WHERE e.date=:date")
	List<ElectionEntity> findByDate(LocalDate date);
	
}
