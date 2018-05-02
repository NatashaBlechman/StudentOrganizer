package com.myschooljournal.service;


import com.myschooljournal.dao.ActivityDao;
import com.myschooljournal.entity.Activity;
import com.myschooljournal.entity.Lesson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ActivityServiceTest {


    @Mock
    private ActivityDao activityDao;

    @InjectMocks
    private ActivityService activityService;

    @Test
    public void shouldReturnActivityForSaving(){

        Activity expected=new Activity();
        when(activityDao.save(expected)).thenReturn(expected);
        Activity actual = activityService.save(expected);
        Assert.assertEquals(expected,actual);
        }

    @Test
    public void shouldReturnActivityById(){
        Activity expected=new Activity();
        when(activityDao.getById(1L)).thenReturn(expected);
        Activity actual=activityService.getById(1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnActivityByIdWhichWasRemoved(){
        Activity expected=new Activity();
        when(activityDao.remove(1L)).thenReturn(expected);
        Activity actual=activityService.remove(1L);
        Assert.assertEquals(expected,actual);


    }


    @Test
    public void shouldReturnAllActivity(){
       // Collection<Activity> expected=new ArrayList<>();
        //Activity activity=new Activity();
        //expected.add(activity);//
        Collection<Activity> expected= Collections.singleton(new Activity());
        when(activityDao.getAll()).thenReturn(expected);
        Collection<Activity> actual=activityService.getAll();
       Assert.assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnListActivitiesByLesson(){
        Lesson lesson=new Lesson();
        Activity activity=new Activity();
        activity.setLesson(lesson);
        List<Activity> expectedList= Arrays.asList(activity,activity);

        when(activityDao.getByLesson(lesson)).thenReturn(expectedList);

        List<Activity> actual=activityService.getByLesson(lesson);
        Assert.assertEquals(expectedList,actual);

    }

    @Test
    public void shouldUpdateActivityByIdAndActivity(){
        Activity expected=new Activity();
        when(activityDao.update(1L,expected)).thenReturn(expected);
        Activity actual=activityService.update(1L,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnListActivitiesByDate(){
        LocalDateTime date=LocalDateTime.of(2018,01,01,8,00);
        Activity activity=new Activity();
        activity.setStart(date);
        List<Activity> expected=Arrays.asList(activity,activity);

        when(activityDao.getByDate(date.toLocalDate())).thenReturn(expected);

        List<Activity> actual=activityService.getByDate(date.toLocalDate());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnListActivityByDateInterval(){
        LocalDateTime from=LocalDateTime.of(2018,01,01,12,00);
        LocalDateTime to=LocalDateTime.of(2018,02,01,13,00);
        Activity activity=new Activity();
        activity.setStart(from);
        activity.setFinish(to);
        List<Activity> expected=Collections.singletonList(activity);

        when(activityDao.getByInterval(from.toLocalDate(),to.toLocalDate())).thenReturn(expected);
        List<Activity> actual=activityService.getByInterval(from.toLocalDate(),to.toLocalDate());
        Assert.assertEquals(expected,actual);
    }

}