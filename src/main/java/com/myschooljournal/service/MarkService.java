package com.myschooljournal.service;

import com.myschooljournal.dao.MarkDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Mark;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class MarkService {

	private MarkDao markDao;



	public MarkService(MarkDao markDao){
		super();
		this.markDao=markDao;
	}

	public MarkService(){
		super();
	}

	public MarkDao getMarkDao() {
		return markDao;
	}

	public void setMarkDao(MarkDao markDao) {
		this.markDao = markDao;
	}

	public Mark save(Mark mark){
		return mark==null?null:markDao.save(mark);

	}
	public Mark getById(Long id){
		return id==null?null:markDao.getById(id);
	}

	public Mark remove(Long id){
		return markDao.remove(id);
	}

	public Collection<Mark> getAll(){
		return markDao.getAll();
		}
	public Mark update(Long id,Mark mark){
		return markDao.update(id,mark);

	}
	public List<Mark> getByLesson(Lesson lesson){
		return markDao.getByLesson(lesson);

	}
	public List<Mark> getByLessonOnInterval(LocalDate from, LocalDate to, Lesson lesson){
		return markDao.getByLessonOnInterval(from,to,lesson);
	}

	public List<Mark> getBadMarks(LocalDate from, LocalDate to, Long level){
		return markDao.getBadMarks(from,to,level);
	}

	public Double getAverageMarkByLesson(LocalDate from, LocalDate to, Lesson lesson){
		return markDao.getAverageMarkByLesson(from,to,lesson);
	}
}
