package com.officemanagement.controller;


import com.officemanagement.model.Meeting;
import com.officemanagement.model.Users;
import com.officemanagement.repository.MeetingRepository;
import com.officemanagement.service.MeetingService;
import com.officemanagement.service.UserService;
import org.hibernate.JDBCException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PersistenceException;
import javax.validation.Valid;
import java.sql.SQLException;
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
     try {
         meetingService.saveMeeting(meeting);
         modelAndView.addObject("successMessage", "Meeting has been successfully Scheduled");
         modelAndView.addObject("meeting",new Meeting());
     }
     catch (Exception e)
     {

        bindingResult.rejectValue("start_time","error.meeting","The conference room is reserved for the time you provided");
     }
     if(bindingResult.hasErrors())
     {
            modelAndView.setViewName("admin/meeting");
     }

        modelAndView.setViewName("admin/meeting");
        return modelAndView;
    }
}
