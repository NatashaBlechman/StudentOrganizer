package com.myschooljournal.service;

import com.myschooljournal.dao.TaskDao;
import com.myschooljournal.entity.Task;
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
public class TaskServiceTest {
    @Mock
    private TaskDao taskDao;
    @InjectMocks
    private TaskService taskService;

    @Test
    public void shouldReturnTaskForSaving(){
        Task expected=new Task();
        when(taskDao.save(expected)).thenReturn(expected);
        Task actual=taskService.save(expected);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnTaskWhichWasRemoved(){
        Task expected=new Task();
        when(taskDao.remove(1L)).thenReturn(expected);
        Task actual=taskService.remove(1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTaskById(){
        Task expected=new Task();
        when(taskDao.getById(1L)).thenReturn(expected);
        Task actual=taskService.getById(1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTaskWhichWasUpdate(){
        Task expected=new Task();
        when(taskDao.update(1L,expected)).thenReturn(expected);
        Task actual=taskService.update(1L,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnAllTasks(){
        Collection<Task> expected= Collections.singleton(new Task());
        when(taskDao.getAll()).thenReturn(expected);
        Collection<Task> actual=taskService.getAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTasksByInterval(){
        Task task=new Task();
        List<Task> expected= Arrays.asList(task,task);
        when(taskDao.getByDeadLine(LocalDate.of(2017,01,31),
                LocalDate.of(2017,02,28))).thenReturn(expected);
        List<Task> actual=taskService.getByDeadLine(LocalDate.of(2017,01,31),
                LocalDate.of(2017,02,28));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnTasksByIntervalWhichWasDone(){
        Task task=new Task();
        List<Task> expected=Arrays.asList(task,task);
        boolean done = true;
        when(taskDao.getByDeadLine(LocalDate.of(2017,01,31),
                LocalDate.of(2017,05,15),done)).thenReturn(expected);
        List<Task> actual=taskService.getByDeadLine(LocalDate.of(2017,01,31),
                LocalDate.of(2017,05,15),done);
        Assert.assertEquals(expected,actual);
    }

}
