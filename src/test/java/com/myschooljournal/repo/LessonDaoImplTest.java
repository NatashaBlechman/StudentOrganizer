package com.myschooljournal.repo;

import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LessonDaoImplTest {

    private static final String LESSON_NAME="Math";
    private static final Long ID = 1L;
    private static final String NUM_CLASS = "209";
    private static final Teacher TEACHER = teacherUnit();
    private static final String TEACHER_NAME = "John";
    private static final String EMAIL = "JohnSmith@gmail.com";


    private LessonDao lessonDao=new LessonDaoImpl();


    @Before
    public void setUp(){
        LessonDaoImpl.clean();
    }

    @Test
    public void shouldReturnLessonForSuccsessfulSaving(){
        Lesson expectedLesson=new Lesson("Math");
        Lesson actualLesson=lessonDao.save(expectedLesson);
        assertEquals(expectedLesson,actualLesson);
    }
    @Test
    public void shouldReturnNullIfWeSavingNull(){
        assertNull(lessonDao.save(null));
    }

    @Test
    public void shouldReturnLessonById(){
        Lesson expectedLesson=new Lesson("Math");
        //expectedLesson.setId(ID);
        //expectedLesson.setTeacher(TEACHER);
        //expectedLesson.setNumClass(NUM_CLASS);
        lessonDao.save(expectedLesson);
        Lesson actualLesson=lessonDao.getById(1L);
        assertEquals(expectedLesson,actualLesson);
    }

    @Test
    public void shouldReturnLessonWhichWasRemovedById(){
        Lesson expectedLesson=new Lesson("Math");
        lessonDao.save(expectedLesson);
        assertEquals(expectedLesson,lessonDao.remove(1L));
    }

    @Test
    public void shouldReturnAllLessons(){
        lessonDao.save(new Lesson("Math"));
        lessonDao.save(new Lesson("Music"));
        Collection<Lesson> actualLesson=lessonDao.getAll();
        assertEquals(2,actualLesson.size());
    }

    @Test
    public void shouldReturnAllInformationAfterUpdate(){
        Lesson lesson1=new Lesson("Math");
        lessonDao.save(lesson1);
        Lesson lesson2=new Lesson("Music");
        Lesson actuallesson=lessonDao.update(1L,lesson2);
        assertEquals(lesson2,actuallesson);
    }

    @Test
    public void shouldReturnListOfLessonForTheTeacher(){
        Lesson lesson1=new Lesson("Math");
        lesson1.setTeacher(TEACHER);
        lessonDao.save(lesson1);
        Lesson lesson2=new Lesson("Music");
        lesson2.setTeacher(TEACHER);
        lessonDao.save(lesson2);
        List<Lesson> lessons=lessonDao.getByTeacher(TEACHER);
        assertEquals(2,lessons.size());
    }

    @Test
    public void shouldReturnLessonByNameOfTeacher(){
        Lesson expectedLesson=new Lesson("Math");
        expectedLesson.setName(TEACHER_NAME);
        lessonDao.save(expectedLesson);
        assertEquals(expectedLesson,lessonDao.getByName(TEACHER_NAME));
    }



    private static Teacher teacherUnit() {
        Teacher teacher = new Teacher();
        teacher.setPhoneNumber("234598");
        teacher.setName(TEACHER_NAME);
        teacher.setId(ID);
        teacher.setEmail(EMAIL);
        return teacher;
    }





}