package com.officemanagement.controller;


import com.officemanagement.model.Meeting;
import com.officemanagement.model.Users;
import com.officemanagement.repository.MeetingRepository;
import com.officemanagement.service.MeetingService;
import com.officemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@RestController
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private MeetingRepository meetingRepository;


    @RequestMapping(path = "/meeting/load", method = RequestMethod.POST,produces = "application/json")
            public List<Meeting> getMeetings()

    {
        return meetingRepository.fetchAllForCalendar();
    }

    @RequestMapping(path = "/meeting/load", method = RequestMethod.GET,produces = "application/json")
    public List<Meeting> getAllMeetings()

    {
        return meetingRepository.fetchAllForCalendar();
    }


    @RequestMapping(value = "/admin/meeting", method = RequestMethod.POST)
    public ModelAndView newMeeting(@Valid Meeting meeting, BindingResult bindingResult)
    {
        ModelAndView modelAndView=new ModelAndView();

        meetingService.saveMeeting(meeting);
        modelAndView.addObject("successMessage","Meeting has been successfully Scheduled");

        modelAndView.setViewName("admin/calendar");
        return modelAndView;
    }
}
