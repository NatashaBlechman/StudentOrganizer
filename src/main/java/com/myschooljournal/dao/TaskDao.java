package com.myschooljournal.dao;

import com.myschooljournal.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskDao extends CommonDao<Task>{
	
	List<Task> getByDeadLine(LocalDate deadLine, LocalDate from);
	List<Task> getByDeadLine(LocalDate deadLine, LocalDate from, boolean done);//додумать методы


}
