package com.myschooljournal.repo;

import com.myschooljournal.dao.ActivityDao;
import com.myschooljournal.entity.Activity;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.entity.Mark;
import com.myschooljournal.entity.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ActivityDaoImplTest {

    private static final Long ID = 2L;
    private static final Lesson LESSON = lessonInit();
    private static final String LESSON_NAME = "Math";
    private static final String NUM_CLASS = "503";
    private static final Teacher TEACHER = teacherInit();
    private static final String TEACHER_NAME = "John";
    private static final String EMAIL = "john@com";
    private static final Mark MARK = markInit();
    private static final LocalDate DATE = LocalDate.of(2017, 12, 12);
    private static final LocalDateTime FROM= LocalDateTime.of(2017,12,12,13,20);
    private static final LocalDateTime TO=LocalDateTime.of(2017,12,13,14,10);
    private static final Activity ACTIVITY = activityInit();

    private ActivityDao activityDao=new ActivityDaoImpl();

    @Before
    public void setUp() {
        ActivityDaoImpl.clean();
    }

    @Test
    public void shouldReturnActivityForSuccessfulSave() {
        assertEquals(ACTIVITY, activityDao.save(ACTIVITY));
    }

    @Test
    public void returnNullIfWeSavingNull() {
        assertNull(activityDao.save(null));
    }

    @Test
    public void shouldReturnActivityById() {
        Activity expectedActivity = activityDao.save(ACTIVITY);
        assertEquals(expectedActivity, activityDao.getById(expectedActivity.getId()));
    }

    @Test
    public void checkRemovingActivitiEntityById() {
        Activity expectedActivity = activityDao.save(ACTIVITY);
        long id = expectedActivity.getId();
        assertEquals(expectedActivity, activityDao.remove(id));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIlligalArgumentExceptionForNullId() {
        activityDao.getById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIlligalArgumentExceptionForNegativeId() {
        activityDao.getById(-1L);
    }

    @Test
    public void shouldRemoveObjectWithChoiceId() {
        Activity expectedActivity = activityDao.save(ACTIVITY);
        Long id = expectedActivity.getId();
        assertEquals(expectedActivity, activityDao.remove(id));
        assertNull(activityDao.remove(id));
    }

    @Test
    public void shouldReturnUpdateActivity() {
        Long id = activityDao.save(ACTIVITY).getId();
        Activity expectedActivity = new Activity();
        expectedActivity.setLesson(LESSON);
        expectedActivity.setMark(new Mark(5L, LESSON, DATE));
        Activity actualActivity = activityDao.update(id, expectedActivity);
        assertEquals(expectedActivity, actualActivity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalUrgumentExceptionForUpdateMethod() {
        try {
            activityDao.update(2L, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Activity is null!", e.getMessage());
            throw e;
        }

    }

    @Test
    public void shouldReturnListActivityByLesson() {
        activityDao.save(ACTIVITY);
        activityDao.save(ACTIVITY);
        activityDao.save(ACTIVITY);
        List<Activity> activities = activityDao.getByLesson(LESSON);
        assertEquals(3,activities.size());

    }

    @Test
    public void shouldReturnListActivityByDay(){
        activityDao.save(ACTIVITY);
        activityDao.save(ACTIVITY);
        activityDao.save(ACTIVITY);
        List<Activity> activities=activityDao.getByDate(DATE);
        assertEquals(3,activities.size());
    }

    @Test
    public void shouldReturnListActivityByInterval(){
        activityDao.save(ACTIVITY);
        activityDao.save(ACTIVITY);
        List<Activity> activities=activityDao.getByInterval(FROM.toLocalDate(),TO.toLocalDate());
        assertEquals(2,activities.size());
    }


    private static Activity activityInit() {
        Activity activity = new Activity();
        activity.setLesson(LESSON);
        activity.setMark(MARK);
        activity.setStart(FROM);
        activity.setFinish(TO);
        return activity;
    }

    private static Mark markInit() {
        return new Mark(10L, LESSON, DATE);

    }

    private static Teacher teacherInit() {
        Teacher teacher = new Teacher(TEACHER_NAME);
        teacher.setId(ID);
        teacher.setEmail(EMAIL);
        return teacher;
    }

    private static Lesson lessonInit() {
        Lesson lesson = new Lesson(LESSON_NAME);
        lesson.setId(ID);
        lesson.setNumClass(NUM_CLASS);
        lesson.setTeacher(TEACHER);
        return lesson;
    }

}