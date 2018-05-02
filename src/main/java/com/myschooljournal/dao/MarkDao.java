package com.myschooljournal.dao;

import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Mark;

import java.time.LocalDate;
import java.util.List;

public interface MarkDao extends CommonDao<Mark>{
	
	List<Mark> getByLesson(Lesson lesson);
	List<Mark> getByLessonOnInterval(LocalDate from, LocalDate to, Lesson lesson);
	List<Mark> getBadMarks(LocalDate from, LocalDate to, Long level);
	Double getAverageMarkByLesson(LocalDate from, LocalDate to, Lesson lesson);
	

}
