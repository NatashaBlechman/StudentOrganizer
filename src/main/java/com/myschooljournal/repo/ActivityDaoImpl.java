package com.myschooljournal.repo;

import com.myschooljournal.dao.ActivityDao;
import com.myschooljournal.entity.Activity;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.workservice.DateWorkService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.myschooljournal.workservice.Validator.idValidation;

public class ActivityDaoImpl implements ActivityDao {

    private static Map<Long, Activity> activityRepo = new HashMap<>();
    private static Long idGen = 1L;

    @Override
    public Activity save(Activity activity) {
        if (activity == null) {
            return null;
        }
        activity.setId(idGen);
        activityRepo.put(idGen, activity);
        return activityRepo.get(idGen++);
    }

    @Override
    public Activity getById(Long id) {
        idValidation(id);
        return activityRepo.get(id);
    }

    @Override
    public Activity remove(Long id) {

        return activityRepo.remove(id);
    }

    @Override
    public Collection<Activity> getAll() {

        return activityRepo.values();
    }

    @Override
    public Activity update(Long id, Activity activity) {
        if (activity == null) {
            //TODO:massage!
            throw new IllegalArgumentException("wrong! activity unillegal!");
        }
        activity.setId(id);
        activityRepo.put(id, activity);
        return activityRepo.get(id);
    }

    @Override
    public List<Activity> getByLesson(Lesson lesson) {

        return activityRepo.values().stream()
                .filter(activity -> lesson.equals(activity.getLesson()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Activity> getByDate(LocalDate date) {
        return activityRepo.values()
                .stream()
                .filter(activity -> date.equals(activity.getStart().toLocalDate())).collect(Collectors.toList());
    }

    @Override
    public List<Activity> getByInterval(LocalDate from, LocalDate to) {

        return activityRepo.values().stream()
                .filter(activity -> (DateWorkService.isDateInInterval(from, to, activity.getFinish().toLocalDate())))
                .collect(Collectors.toList());
    }

    public static  void clean(){
        activityRepo=new HashMap<>();
        idGen=1L;
    }

}
