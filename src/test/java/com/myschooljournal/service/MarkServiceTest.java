package com.myschooljournal.service;

import com.myschooljournal.dao.MarkDao;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Mark;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MarkServiceTest {

    @Mock
    private MarkDao markDao;

    @InjectMocks
    private MarkService markService;

    @Test
    public void shouldReturnMarkForSaving(){
        Mark expected=new Mark(1L,new Lesson(),LocalDate.of(2017,01,01));
        when(markDao.save(expected)).thenReturn(expected);
        Mark actual=markService.save(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnMarkById(){
        Mark expected=new Mark();
        when(markDao.getById(4L)).thenReturn(expected);
        Mark actual=markService.getById(4L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnMarkWhichWasRemovedById(){
        Mark expected=new Mark(1L,new Lesson(),LocalDate.of(2017,01,01));
        when(markDao.remove(1L)).thenReturn(expected);
        Mark actual=markService.remove(1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnAllMarks(){
        Collection<Mark> expected= Collections.singleton(new Mark());
        when(markDao.getAll()).thenReturn(expected);
        Collection<Mark> actual=markService.getAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnMarkWhichWasUpdateByIdAndMark(){
        Mark expected=new Mark(1L,new Lesson(),LocalDate.of(2017,01,01));
        when(markDao.update(2L,expected)).thenReturn(expected);
        Mark actual=markService.update(2L,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnListOfMarksByLesson(){
        Mark mark=new Mark(1L,new Lesson(),LocalDate.of(2017,01,01));
        List<Mark> expected= Arrays.asList(mark,mark);
        Lesson lesson=new Lesson();
        when(markDao.getByLesson(lesson)).thenReturn(expected);
        List<Mark> actual=markService.getByLesson(lesson);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnListOfMarksByLessonOnInterval(){
        Lesson lesson=new Lesson();
        Mark mark=new Mark(1L,lesson,LocalDate.of(2017,01,01));
        List<Mark> expected=Arrays.asList(mark,mark);
        LocalDate from=LocalDate.of(2016,01,20);
        LocalDate to=LocalDate.of(2017,02,01);
        when(markDao.getByLessonOnInterval(from,to,lesson)).thenReturn(expected);
        List<Mark> actual=markService.getByLessonOnInterval(from,to,lesson);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnListOfBadMarks(){
        Mark mark=new Mark();
        List<Mark> expected=Arrays.asList(mark,mark);
        LocalDate from=LocalDate.of(2016,01,20);
        LocalDate to=LocalDate.of(2017,02,01);
        Long level=5L;
        when(markDao.getBadMarks(from,to,level)).thenReturn(expected);
        List<Mark> actual=markService.getBadMarks(from,to,level);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnDoubleMarkByMarksFromLesson(){
        Lesson lesson=new Lesson();
        LocalDate from=LocalDate.of(2016,01,20);
        LocalDate to=LocalDate.of(2017,02,01);
        when(markDao.getAverageMarkByLesson(from,to,lesson)).thenReturn(2.5);
        double actual=markService.getAverageMarkByLesson(from,to,lesson);
        Assert.assertEquals(2.5,actual,0.01);
    }

}
