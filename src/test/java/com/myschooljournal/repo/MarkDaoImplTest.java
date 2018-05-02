package com.myschooljournal.repo;

import com.myschooljournal.dao.MarkDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Mark;
import com.myschooljournal.entity.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MarkDaoImplTest {

    private MarkDao markDao=new MarkDaoImpl();


    private static final Lesson LESSON = lessonInit();
    private static final LocalDate DATE = LocalDate.of(2017, 03, 12);
    private static final String LESSON_NAME = "Math";
    private static final String NUM_CLASS = "503";
    private static final Long ID = 2L;
    private static final Teacher TEACHER = teacherInit();
    private static final String TEACHER_NAME = "John";
    private static final String EMAIL = "john@com";
    private static final LocalDate FROM=LocalDate.of(2017,01,01);
    private static final LocalDate TO=LocalDate.of(2017,04,01);
    private static final Long LEVEL=8L;


    @Before
    public void setUp(){
        MarkDaoImpl.clean();
    }

    @Test
    public void shouldReturnMarkForSuccessfulSaving(){
        Mark expectedMark=new Mark(10L,LESSON,DATE);
        Mark actualMark=markDao.save(expectedMark);
        assertEquals(expectedMark,actualMark);

    }

    @Test
    public void returnNullIfWeSavingNull() {
        assertNull(markDao.save(null));
    }

    @Test
    public void shouldReturnMarkById(){
        Mark expectedMark=new Mark(10L,LESSON,DATE);
        markDao.save(expectedMark);
       assertEquals(expectedMark,markDao.getById(1L));
    }

    @Test
    public void shouldReturnMarkWhichWasRemovedById(){
        Mark expectedMark=new Mark(10L,LESSON,DATE);
        markDao.save(expectedMark);
        assertEquals(expectedMark,markDao.remove(1L));
    }

    @Test
    public void shouldReturnAllMarks(){
        Mark mark1=new Mark(10L,LESSON,DATE);
        Mark mark2=new Mark(10L,LESSON,DATE);
        markDao.save(mark1);
        markDao.save(mark2);
        Collection<Mark> marks= markDao.getAll();
        assertEquals(2,marks.size());


        }

     @Test
     public void shouldReturnNewInformationAfterUpdate(){
        Mark mark1=new Mark(10L,LESSON,DATE);
        markDao.save(mark1);
        Mark mark2=new Mark(2L,LESSON,DATE);
        Mark actualMark=markDao.update(1L,mark2);
        assertEquals(actualMark,mark2);
     }

     @Test
     public void shouldReturnListOfMarksByLesson(){
        Mark mark1=new Mark(10L,LESSON,DATE);
        Mark mark2=new Mark(9L,LESSON,DATE);
        markDao.save(mark1);
        markDao.save(mark2);
        List<Mark> marks=markDao.getByLesson(LESSON);
        assertEquals(2,marks.size());


     }

     @Test
     public void shouldReturnListOfMarksByLessonOnInterval(){
        Mark mark1=new Mark(10L,LESSON,DATE);
        Mark mark2=new Mark(5L,LESSON,DATE);
        markDao.save(mark1);
        markDao.save(mark2);
        List<Mark> marks=markDao.getByLessonOnInterval(FROM,TO,LESSON);
        assertEquals(2,marks.size());
    }

    @Test
    public void shouldReturnListOfBadMarks(){
        Mark mark1=new Mark(4L,LESSON,DATE);
        Mark mark2=new Mark(5L,LESSON,DATE);
        markDao.save(mark1);
        markDao.save(mark2);
        List<Mark> marks=markDao.getBadMarks(FROM,TO,LEVEL);
        assertEquals(2,marks.size());
    }

    @Test
    public void shouldReturnAverageGradeByLessonsForPeriod(){
        Mark mark1=new Mark(3L,LESSON,DATE);
        Mark mark2=new Mark(10L,LESSON,DATE);
        Mark mark3=new Mark(9L,LESSON,DATE);

        markDao.save(mark1);
        markDao.save(mark2);
        markDao.save(mark3);

        double cffnt=0.01;
        Double actual=markDao.getAverageMarkByLesson(FROM,TO,LESSON);
        assertEquals(7.33,actual,cffnt);


        }

        private static Lesson lessonInit() {
        Lesson lesson = new Lesson(LESSON_NAME);
        lesson.setId(ID);
        lesson.setNumClass(NUM_CLASS);
        lesson.setTeacher(TEACHER);
        return lesson;
    }

    private static Teacher teacherInit() {
        Teacher teacher = new Teacher();
        teacher.setName(TEACHER_NAME);
        teacher.setId(ID);
        teacher.setEmail(EMAIL);
        return teacher;
    }
}