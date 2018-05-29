package com.myschooljournal.dao;

import com.myschooljournal.entity.Activity;
import com.myschooljournal.entity.Lesson;

import java.time.LocalDate;
import java.util.List;

public interface ActivityDao extends CommonDao<Activity>{
	//todo alternative method
	List<Activity> getByLesson(Lesson lesson);
	List<Activity> getByDate(LocalDate date);
	List<Activity> getByInterval(LocalDate from, LocalDate to);

}
