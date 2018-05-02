package com.myschooljournal.repo;


import com.myschooljournal.dao.TeacherDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TeacherDaoImplTest {


    private TeacherDao teacherDao=new TeacherDaoImpl();

    @Before
    public void setUp() {
        TeacherDaoImpl.clean();
    }

    @Test
    public void shouldReturnNull() {
        assertNull(teacherDao.save(null));
    }

    @Test
    public void shouldReturnTeacherWhichWasSavedInDB() {
        Teacher expectedTeacher = new Teacher("Alex");
        Teacher actualTeacher = teacherDao.save(expectedTeacher);
        assertEquals(expectedTeacher, actualTeacher);
    }

    @Test
    public void shouldReturnTeacherById(){
        Teacher expectedTeacher=new Teacher("Alex");
        teacherDao.save(expectedTeacher);
        Teacher actualTeacher=teacherDao.getById(1L);
        assertEquals(expectedTeacher,actualTeacher);
    }

    @Test
    public void shouldReturnTeacherWhichRemovedById(){
        Teacher expectedTeacher=new Teacher("Alex");
        teacherDao.save(expectedTeacher);
        Teacher actualTeacher=teacherDao.remove(1L);
        assertEquals(expectedTeacher,actualTeacher);
        assertNull(teacherDao.remove(1L));

    }

    @Test
    public void shouldReturnAllTeachers(){
        //todo:сравнить объекты (сравнение в junit!!!)
        Teacher teacher1=new Teacher("Alex");
        Teacher teacher2=new Teacher("Dima");
        teacherDao.save(teacher1);
        teacherDao.save(teacher2);
        Collection<Teacher> actualTeachers=teacherDao.getAll();
        assertEquals(2,actualTeachers.size());
    }

    @Test
    public void shouldReturnNewInformationAfterUpdate(){
        Teacher teacher1=new Teacher("Alex");
        teacherDao.save(teacher1);
        Teacher teacher2=new Teacher("John");
        Teacher actualTeacher=teacherDao.update(1L,teacher2);
        assertEquals(teacher2,actualTeacher);
    }

    @Test
    public void shouldReturnTeacherByName(){
        Teacher expectedTeacher=new Teacher("Nata");
        teacherDao.save(expectedTeacher);
        assertEquals(expectedTeacher,teacherDao.getByName("Nata"));
    }

    @Test
    public void shouldReturnTeacherByEmail(){
        Teacher expectedTeacher=new Teacher("Boris");
        expectedTeacher.setEmail("boris@gmail.com");
        teacherDao.save(expectedTeacher);
        assertEquals(expectedTeacher,teacherDao.getByEmail("boris@gmail.com"));

    }

    @Test
    public void shouldReturnTeacherByLesson(){
        Teacher expectedTeacher=new Teacher("Masha");
        Lesson lesson=new Lesson("Math");
        expectedTeacher.setLessons(singletonList(lesson));
        teacherDao.save(expectedTeacher);
        assertEquals(expectedTeacher,teacherDao.getByLesson(lesson));

    }




}