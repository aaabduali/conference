package com.officemanagement.service;



import com.officemanagement.model.Meeting;

import java.sql.Time;
import java.util.List;

/**
 * Created by Abdurahman on 7/27/2017.
 */
public interface MeetingService {
    public void upload(Meeting meeting);
    public List<Meeting> findAll();

    public void saveMeeting(Meeting meeting);
}
