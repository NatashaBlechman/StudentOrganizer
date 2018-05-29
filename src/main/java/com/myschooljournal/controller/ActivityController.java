package com.myschooljournal.controller;

import com.myschooljournal.entity.Activity;
import com.myschooljournal.entity.Lesson;
import com.myschooljournal.service.ActivityService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value="/activity")
public class ActivityController {


    private ActivityService activityService;

@Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
    //  /activity/1235
    @RequestMapping(method=GET, value = "/{id}")
    public void getActivityById(@PathVariable(name="id") Long id){
        Activity activity=activityService.getById(id);
        System.out.println(activity);
    }

    @RequestMapping(method=DELETE,value="/{id}")
    public void removeById(@PathVariable(name="id") Long id){
    Activity activity=activityService.remove(id);
        System.out.println(activity);
    }
// /activity/by/date?date="14.10.2018"
    @RequestMapping(method=GET,value="/by/date")
    public void getByDate(@NotNull @RequestParam("date") String dateStr){
    List<Activity > activities=activityService.getByDate(LocalDate.parse(dateStr));
         activities.forEach(System.out::println);
    }
    @RequestMapping(method=GET,value="/by/date")
    public void getByInterval(String dateStrBeg,String dateStrFin){
    List<Activity> activities=activityService.getByInterval(LocalDate.parse(dateStrBeg),LocalDate.parse(dateStrFin));
    activities.forEach(System.out::println);

    }


}
