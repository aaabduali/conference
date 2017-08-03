package com.officemanagement.controller;

import com.officemanagement.model.Meeting;
import com.officemanagement.model.Users;
import com.officemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/admin/calendar")
    public ModelAndView calendar()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName",  user.getName() + " " + user.getLastName());
        modelAndView.addObject("email",  "("+user.getEmail()+")" );
        modelAndView.setViewName("admin/calendar");
        return modelAndView;
    }
    @RequestMapping(value = "/admin/meeting")
    public ModelAndView meeting()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("meeting",new Meeting());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName",  user.getName() + " " + user.getLastName());
        modelAndView.addObject("email",  "("+user.getEmail()+")" );
        modelAndView.setViewName("admin/meeting");

        return modelAndView;
    }
    @RequestMapping(value = "/admin/meet")
    public ModelAndView meet()
    {
        ModelAndView modelAndView=new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName",  user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.setViewName("admin/meet");
        return modelAndView;
    }
}

