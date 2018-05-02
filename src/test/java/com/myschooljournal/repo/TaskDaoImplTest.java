package com.myschooljournal.repo;

import com.myschooljournal.dao.TaskDao;
import com.myschooljournal.entity.Task;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TaskDaoImplTest {

    private static final boolean DONE =true ;
    private TaskDao taskDao=new TaskDaoImpl();

    @Before
    public void setUp(){
        TaskDaoImpl.clean();
    }

    @Test
    public void shouldReturnTaskForSuccesfulSaving(){//конструктор в таск
        Task expectedTask=new Task();
        Task actualTask=taskDao.save(expectedTask);
        assertEquals(expectedTask,actualTask);

    }

    @Test
    public void shouldReturnNullIfWeSavingNull(){
        assertNull(taskDao.save(null));
    }

    @Test
    public void shouldReturnTaskById(){
        Task expectedTask=taskDao.save(new Task());
        expectedTask.setId(1L);//?
        assertEquals(expectedTask,taskDao.getById(1L));
    }

    @Test
    public void shouldReturnTaskByIdWhichWasRemoved(){
        Task expectedTask=taskDao.save(new Task());
        assertEquals(expectedTask,taskDao.remove(1L));

    }

    @Test
    public void shouldReturnAllTasks(){
        taskDao.save(new Task());
        taskDao.save(new Task());
        Collection<Task> tasks=taskDao.getAll();
        assertEquals(2,tasks.size());

    }

    @Test
    public void shouldReturnNewTaskInformationWhichWasUpdate(){
        Task expectedTask=taskDao.save(new Task());
        Task actualTask=taskDao.update(1L,expectedTask);
        assertEquals(expectedTask,actualTask);

    }

    @Test
    public void shouldReturnListOfTasksByInterval(){
        Task task1=taskDao.save(new Task());
        Task task2=taskDao.save(new Task());
        task1.setDeadLine(LocalDate.of(2018,01,31));
        task2.setDeadLine(LocalDate.of(2018,01,31));
        assertEquals(2, taskDao
                .getByDeadLine(LocalDate.of(2018,01,31),
                        LocalDate.of(2017,12,01)).size());


    }

    @Test
    public void shouldReturnListOfTasksByIntervalWhichWasDone(){
        Task task1=new Task();
        task1.setDeadLine(LocalDate.of(2018,01,31));
        Task task2=new Task();
        task2.setDeadLine(LocalDate.of(2018,01,31));
        task1.setDone(DONE);
        task2.setDone(DONE);
        taskDao.save(task1);
        taskDao.save(task2);
        assertEquals(2,taskDao.getByDeadLine(LocalDate.
                of(2018,01,31),LocalDate
                .of(2017,12,01),DONE).size());
        }
}