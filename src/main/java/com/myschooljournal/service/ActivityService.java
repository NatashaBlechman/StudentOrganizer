package com.myschooljournal.service;

import com.myschooljournal.dao.ActivityDao;
import com.myschooljournal.entity.Activity;
import com.myschooljournal.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service("activityService")
public class ActivityService {
	
	private ActivityDao activityDao;

@Autowired
	public ActivityService(@Qualifier("activityDao") ActivityDao activityDao) {
		super();
		this.activityDao = activityDao;
	}

	public ActivityService() {
		super();
	}
	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public Activity save(Activity activity) {
		return activity==null?null:activityDao.save(activity);
	}
	public Activity getById(Long id) {
		return activityDao.getById(id);
	}
	public Activity remove(Long id) {
		return activityDao.remove(id);
	}
	public Collection<Activity> getAll() {
		return activityDao.getAll();
	}
	public  Activity update(Long id, Activity activity) {
		return activityDao.update(id, activity);
		
	}
	public List<Activity> getByLesson(Lesson lesson) {
		return activityDao.getByLesson(lesson);
	}
	public List<Activity> getByDate(LocalDate date) {
		return activityDao.getByDate(date);
	}
	public List<Activity> getByInterval(LocalDate from, LocalDate to) {
		return activityDao.getByInterval(from, to);
	}

}
