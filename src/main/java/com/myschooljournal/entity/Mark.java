package com.myschooljournal.entity;

import java.time.LocalDate;

public  class Mark extends EntityObject{
	
	private Long mark;
	private Lesson lesson;
	private LocalDate date;

	public Mark(Long mark,Lesson lesson,LocalDate date) {
		super();
		this.mark = mark;
		this.lesson=lesson;
		this.date=date;
	}
	public Mark(){
		super();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getMark() {
		return mark;
	}

	public void setMark(Long mark) {
		this.mark = mark;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	@Override
	public String toString() {
		return "Mark [mark=" + mark + ", lesson=" + lesson + ", date=" + date + "]";
	}

	

}