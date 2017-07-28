package com.officemanagement.controller;


import com.officemanagement.model.Meeting;
import com.officemanagement.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@RestController
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @RequestMapping(path = "/meeting/load")
            public List<Meeting> getMeetings()

    {
        return meetingService.findAll();
    }

}
