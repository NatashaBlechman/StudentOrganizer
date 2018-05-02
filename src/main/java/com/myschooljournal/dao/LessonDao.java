package com.myschooljournal.dao;


import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;

import java.util.List;

public interface LessonDao extends CommonDao<Lesson>{
	
	List<Lesson> getByTeacher(Teacher teacher);
	Lesson getByName(String name);
	
}
