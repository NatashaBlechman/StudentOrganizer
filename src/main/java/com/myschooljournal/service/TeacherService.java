package com.myschooljournal.service;

import com.myschooljournal.dao.TeacherDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("teacherService")
public class TeacherService {
	
	
	private TeacherDao teacherDao;

@Autowired
	public TeacherService(@Qualifier("teacherDao") TeacherDao teacherDao){
		super();
		this.teacherDao=teacherDao;
	}

	private TeacherService(){
		super();
	}

	public TeacherDao getTeacherDao()
	{
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao)
	{
		this.teacherDao = teacherDao;
	}

	public Teacher save(Teacher teacher)
	{
		return teacher==null?null:teacherDao.save(teacher);
	}

	public Teacher getById(Long id){
		return teacherDao.getById(id);

	}
	public Teacher remove(Long id)
	{
		return teacherDao.remove(id);
	}

	public Collection<Teacher> getAll()
	{
		return teacherDao.getAll();
	}

	public Teacher update(Long id,Teacher teacher)
	{
		return teacherDao.update(id,teacher);
	}

	public Teacher getByName(String name)
	{
		return teacherDao.getByName(name);
	}

	public Teacher getByEmail(String email)
	{
		return teacherDao.getByEmail(email);
	}

	public Teacher getByLesson(Lesson lesson)
	{
		return teacherDao.getByLesson(lesson);
	}

}
