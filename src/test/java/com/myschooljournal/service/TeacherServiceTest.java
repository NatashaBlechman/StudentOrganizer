package com.myschooljournal.service;

import com.myschooljournal.dao.TeacherDao;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TeacherServiceTest {
    @Mock
    private TeacherDao teacherDao;
    @InjectMocks
    private TeacherService teacherService;

    @Test
    public void shouldReturnTeacherForSaving(){
        Teacher expected=new Teacher();
        when(teacherDao.save(expected)).thenReturn(expected);
        Teacher actual=teacherService.save(expected);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnTeacherById(){
        Teacher expected=new Teacher();
        when(teacherDao.getById(1L)).thenReturn(expected);
        Teacher actual=teacherService.getById(1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTeacherWhichWasRemovedById(){
        Teacher expected=new Teacher();
        when(teacherDao.remove(1L)).thenReturn(expected);
        Teacher actual=teacherService.remove(1L);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnAllTeachers(){
        Collection<Teacher> expected= Arrays.asList(new Teacher(),new Teacher());
        when(teacherDao.getAll()).thenReturn(expected);
        Collection<Teacher> actual=teacherService.getAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTeacherWhichWasUpdate(){
        Teacher expected=new Teacher();
        when(teacherDao.update(1L,expected)).thenReturn(expected);
        Teacher actual=teacherService.update(1L,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTeacherByName(){
        Teacher expected=new Teacher();
        when(teacherDao.getByName("Stella")).thenReturn(expected);
        Teacher actual=teacherService.getByName("Stella");
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnTeacherByEmail(){
        Teacher expected=new Teacher();
        when(teacherDao.getByEmail("blh@gmail.com")).thenReturn(expected);
        Teacher actual=teacherService.getByEmail("blh@gmail.com");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTeacherByLesson(){
        Teacher expected=new Teacher();
        Lesson lesson=new Lesson();
        when(teacherDao.getByLesson(lesson)).thenReturn(expected);
        Teacher actual=teacherService.getByLesson(lesson);
        Assert.assertEquals(expected,actual);
    }
}
