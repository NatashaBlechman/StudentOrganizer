package com.myschooljournal.service;

import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;

import java.util.Collection;
import java.util.List;

public class LessonService {
	
	public LessonDao lessonDao;

	public LessonService(LessonDao lessonDao) {
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
		//if(lesson==null){
			//return null;
			//}
		//return lessonDao.save(lesson);
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
 
	
	public Lesson getByName(String name) {//null or exeption, регистр
		return lessonDao.getByName(name);
	}


	
	

}
