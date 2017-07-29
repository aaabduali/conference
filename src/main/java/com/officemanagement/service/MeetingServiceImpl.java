package com.officemanagement.service;



import com.officemanagement.model.ConferenceRoom;
import com.officemanagement.model.Meeting;
import com.officemanagement.model.Users;
import com.officemanagement.repository.MeetingRepository;
import com.officemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Service("meetingService")
public class MeetingServiceImpl  implements MeetingService {


    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private UserServiceImpl userService;
    @Override
    public void upload(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }





    @Override
    public void saveMeeting(Meeting meeting) {
        SimpleDateFormat parser=new SimpleDateFormat("");
        System.out.print(meeting.getEnd_time());
        System.out.print(meeting.getStart_time());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByEmail(auth.getName());
        ConferenceRoom conferenceRoom=new ConferenceRoom();
        conferenceRoom.setId(1);
        meeting.setCalled_by(user);
        meeting.setConferenceRoom(conferenceRoom);
        meeting.setDepartment(meeting.getDepartment());
        meeting.setStart_time(meeting.getStart_time());
        meeting.setEnd_time(meeting.getEnd_time());
        meeting.setSubject(meeting.getSubject());
        meetingRepository.save(meeting);
    }
}
