package com.myschooljournal.controller;


import com.myschooljournal.entity.Lesson;
import com.myschooljournal.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value="/lesson")
public class LessonController {

    private  LessonService lessonService;

@Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @RequestMapping(method=GET,value="/all")
    public ModelAndView getAll(){
        Collection<Lesson> lessons=lessonService.getAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("lessons");
        modelAndView.getModel().put("lessonsList",lessons);
        return modelAndView;
        }
}
