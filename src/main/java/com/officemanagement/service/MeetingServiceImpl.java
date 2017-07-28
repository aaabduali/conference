package com.officemanagement.service;



import com.officemanagement.model.Meeting;
import com.officemanagement.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Service("meetingService")
public class MeetingServiceImpl  implements MeetingService {


    @Autowired
    private MeetingRepository meetingRepository;

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
        meeting.setCalled_by(meeting.getCalled_by());
        meeting.setConferenceRoom(meeting.getConferenceRoom());
        meeting.setDepartment(meeting.getDepartment());
        meeting.setStart_time(meeting.getStart_time());
        meeting.setEnd_time(meeting.getEnd_time());
        meeting.setSubject(meeting.getSubject());
        meetingRepository.save(meeting);
    }
}
