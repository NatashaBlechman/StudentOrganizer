package com.myschooljournal.controller;

import com.myschooljournal.entity.Teacher;
import com.myschooljournal.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

    private TeacherService teacherService;

@Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //{"name":"NIkola", "email": "nik@gmail.com", "lessons":[]}
    @RequestMapping(method = PUT,value="/add")
    public void save(@RequestBody String name){
    Teacher teacher=new Teacher(name);
    System.out.println( teacherService.save(teacher));

    }
}
