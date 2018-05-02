package com.myschooljournal.entity;

import java.time.LocalDate;

public class Task extends EntityObject{
	
	private String task;
	private LocalDate deadLine;
	private boolean done;
	
	public Task(String task, LocalDate deadLine) {
		super();
		this.task = task;
		this.deadLine = deadLine;
		this.done=done;
	}
	public Task() {
		super();
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public LocalDate getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(LocalDate deadLine) {
		this.deadLine = deadLine;
	}
	@Override
	public String toString() {
		return "Task [task=" + task + ", deadLine=" + deadLine + ", done=" + done + "]";
	}
	
	

}
