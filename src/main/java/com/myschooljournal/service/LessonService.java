package com.myschooljournal.service;

import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service("lessonService")
public class LessonService {
	
	public LessonDao lessonDao;

	@Autowired
	public LessonService(@Qualifier("lessonDao") LessonDao lessonDao) {
		super();
		this.lessonDao = lessonDao;
	}

	public LessonService() {
		super();
	}

	public LessonDao getLessonDao() {
		return lessonDao;
	}

	public void setLessonDao(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
	}


	public Lesson save(Lesson lesson) {
		return lesson==null?null:lessonDao.save(lesson);
		
		}

	public Lesson getById(Long id) {
		return id==null?null: lessonDao.getById(id);
		
	}

	public Lesson remove(Long id) {
		return  lessonDao.remove(id);
	}


	public Collection<Lesson> getAll() {
		return lessonDao.getAll();
		
	}

	public Lesson update(Long id, Lesson lesson) {
		return lesson.getId()==null || lesson==null?null:lessonDao.update(id, lesson);
		
	}

	
	public List<Lesson> getByTeacher(Teacher teacher) {// продумать логику с null
		return lessonDao.getByTeacher(teacher);	
	}
 
	
	public Lesson getByName(String name) {
		return lessonDao.getByName(name);
	}


}
