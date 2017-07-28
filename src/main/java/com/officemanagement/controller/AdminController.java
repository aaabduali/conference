package com.officemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Controller
public class AdminController {
    @RequestMapping(value = "/admin/calendar")
    public ModelAndView calendar()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("admin/calendar");
        return modelAndView;
    }
    @RequestMapping(value = "/admin/meeting")
    public ModelAndView meeting()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("admin/meeting");
        return modelAndView;
    }
    @RequestMapping(value = "/admin/meet")
    public ModelAndView meet()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("admin/meet");
        return modelAndView;
    }
}

