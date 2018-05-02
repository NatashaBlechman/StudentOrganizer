package com.myschooljournal.dao;



import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;

public interface TeacherDao extends CommonDao<Teacher> {
	
	Teacher getByName(String name);
	Teacher getByEmail(String email);
	Teacher getByLesson(Lesson lesson);
}
