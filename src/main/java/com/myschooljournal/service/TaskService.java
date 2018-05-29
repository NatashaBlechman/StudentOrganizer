package com.myschooljournal.service;

import com.myschooljournal.dao.TaskDao;
import com.myschooljournal.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service("taskService")
public class TaskService {
	
	private TaskDao taskDao;

@Autowired
	public TaskService(@Qualifier("taskDao") TaskDao taskDao) {
		super();
		this.taskDao = taskDao;
	}

	public TaskService() {
		super();
		
	}
	public Task save(Task task) {
		return task==null?null:taskDao.save(task);
	}
	public Task remove(Long id) {
		return id==null?null:taskDao.remove(id);
	}
	public Task getById(Long id){
		return id==null?null:taskDao.getById(id);
	}
	public Task update(Long id,Task task){
		return  taskDao.update(id, task);
	}
	public Collection<Task> getAll() {
		return taskDao.getAll();
	}
	public List<Task> getByDeadLine(LocalDate deadLine,LocalDate from){
		return taskDao.getByDeadLine(deadLine, from);
	}
	public List<Task> getByDeadLine(LocalDate deadLine,LocalDate from, boolean done){
		return taskDao.getByDeadLine(deadLine, from, done);
	}



}
