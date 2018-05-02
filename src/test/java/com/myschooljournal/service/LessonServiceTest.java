package com.myschooljournal.service;

import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LessonServiceTest {

    @Mock
    private LessonDao lessonDao;

    @InjectMocks
    private LessonService lessonService;


    @Test
    public void shouldReturnLessonForSaving(){
        Lesson expected=new Lesson();
        when(lessonDao.save(expected)).thenReturn(expected);
        Lesson actual=lessonService.save(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnLessonById(){
        Lesson expected=new Lesson();expected.setId(1L);
       when(lessonDao.getById(1L)).thenReturn(expected);
        Lesson actual=lessonService.getById(1L);
        Assert.assertEquals(expected,actual);
        }



        @Test
    public void shouldReturnLessonWhichWasRemovedById(){
        Lesson expected=new Lesson();
        expected.setId(1L);
        when(lessonDao.remove(1L)).thenReturn(expected);
        Lesson actual=lessonService.remove(1L);
        Assert.assertEquals(expected,actual);
        }

    @Test
    public void shouldReturnAllLessons(){
        Collection<Lesson> expected= Collections.singleton(new Lesson());
        when(lessonDao.getAll()).thenReturn(expected);
        Collection<Lesson> actual=lessonService.getAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnLessonWhichWasUpdateById(){
        Lesson expected=new Lesson();
        expected.setId(1L);
        when(lessonDao.update(1L,expected)).thenReturn(expected);
        Lesson actual=lessonService.update(1L,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnListOfLessonByTeacher(){
        Lesson lesson=new Lesson();
        List<Lesson> expected= Arrays.asList(lesson,lesson);
        Teacher teacher=new Teacher();
        when(lessonDao.getByTeacher(teacher)).thenReturn(expected);
        List<Lesson> actual=lessonService.getByTeacher(teacher);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnLessonByName(){
        Lesson expected=new Lesson();
        expected.setName("Music");
        when(lessonDao.getByName("Music")).thenReturn(expected);
        Lesson actual=lessonService.getByName("Music");
        Assert.assertEquals(expected,actual);
    }

    }



