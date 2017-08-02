package com.officemanagement.controller;


import com.officemanagement.model.Users;
import com.officemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }
    @RequestMapping(value ="/registration")
    public ModelAndView registration()
    {
        ModelAndView modelAndView=new ModelAndView();
        Users user=new Users();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public ModelAndView newUser(@Valid Users user, BindingResult bindingResult)
    {
        ModelAndView modelAndView=new ModelAndView();
        Users exist=userService.findUserByEmail(user.getEmail());
        if(exist!=null)
        {
            bindingResult.rejectValue("email","error,user","The email provided is already taken");

        }
        if(bindingResult.hasErrors())
        {
            modelAndView.setViewName("registration");
        }
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage","User has been successfully registered");
            modelAndView.addObject("user",new SecurityProperties.User());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName",  user.getName() + " " + user.getLastName());
        modelAndView.addObject("email",  "("+user.getEmail()+")" );

        modelAndView.setViewName("admin/base");
        return modelAndView;
    }

}
