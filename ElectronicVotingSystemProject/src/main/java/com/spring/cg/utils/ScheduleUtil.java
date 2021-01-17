package com.spring.cg.utils;

import java.util.ArrayList;


import java.util.List;

import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.json.Schedule;

public class ScheduleUtil {
	public static Schedule convertElectionEntityIntoSchedule(ElectionEntity scheduleEntity) {
		
		return new Schedule(scheduleEntity.getElectionId(),scheduleEntity.getElection_name(),scheduleEntity.getState(),scheduleEntity.getConstituency(),scheduleEntity.getDate());
	}
	
public static List<Schedule> convertElectionEntityIntoScheduleList(List<ElectionEntity> scheduleEntityList) {
		
	List<Schedule> scheduleList = new ArrayList<Schedule>();
	for(ElectionEntity scheduleEntity: scheduleEntityList) {
		scheduleList.add(convertElectionEntityIntoSchedule(scheduleEntity));
	}
	return scheduleList;
	}

 
}
