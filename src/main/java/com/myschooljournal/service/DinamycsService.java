package com.myschooljournal.service;

import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.dao.MarkDao;
import com.myschooljournal.entity.Lesson;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class DinamycsService {
	
	private MarkDao markDao;
	private LessonDao lessonDao;
	
	public DinamycsService() {
		super();
	}

public DinamycsService(MarkDao markDao, LessonDao lessonDao) {
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
//	Collection<Lesson> collection=lessonDao.getAll();
//	Map<String,Double> map=new HashMap<>();
//		for(Lesson lesson:collection){
//			map.put(lesson.getName(), markDao.getAverageMarkByLesson(from, to, lesson));
//		}
//		return map;
	
		
			return lessonDao
					.getAll()
					.stream()
					.collect(Collectors.groupingBy(Lesson::getName,
							Collectors.averagingDouble(l->markDao.getAverageMarkByLesson(from, to, l))));
				//.collect(Collectors.toMap(Lesson::getName,l->markDao.getAverageMarkByLesson(from, to, l)));
					
								

				
}
	

}
