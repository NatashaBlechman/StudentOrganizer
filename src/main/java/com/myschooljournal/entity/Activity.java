package com.myschooljournal.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Activity extends EntityObject{
	
	private Lesson lesson;
	private List<Task> tasks;
	private LocalDateTime start;
	private LocalDateTime finish;
	private Mark mark;
	public Activity(Lesson lesson, LocalDateTime start, LocalDateTime finish) {
		super();
		this.lesson = lesson;
		this.start = start;
		this.finish = finish;
	}
	public Activity() {
		super();
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getFinish() {
		return finish;
	}
	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}
	public Mark getMark() {
		return mark;
	}
	public void setMark(Mark mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Activity [lesson=" + lesson + ", tasks=" + tasks + ", start=" + start + ", finish=" + finish + ", mark="
				+ mark + "]";
	}
	
}