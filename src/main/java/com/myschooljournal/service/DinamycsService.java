package com.myschooljournal.service;

import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.dao.MarkDao;
import com.myschooljournal.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@Service("dinamycsService")
public class DinamycsService {
	
	private MarkDao markDao;
	private LessonDao lessonDao;

	public DinamycsService() {
		super();
	}

	@Autowired
public DinamycsService(@Qualifier("markDao") MarkDao markDao, LessonDao lessonDao) {
		super();
		this.markDao = markDao;
		this.lessonDao = lessonDao;
	}

public MarkDao getMarkDao() {
	return markDao;
}

public void setMarkDao(MarkDao markDao) {
	this.markDao = markDao;
}

public LessonDao getLessonDao() {
	return lessonDao;
}

public void setLessonDao(LessonDao lessonDao) {
	this.lessonDao = lessonDao;
}

public Map<String, Double> getDynamicsByPeriod(LocalDate from, LocalDate to) {
		return lessonDao
					.getAll()
					.stream()
					.collect(Collectors.groupingBy(Lesson::getName,
							Collectors.averagingDouble(l->markDao.getAverageMarkByLesson(from, to, l))));
		}
}
