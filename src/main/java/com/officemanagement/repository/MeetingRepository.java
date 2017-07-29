package com.officemanagement.repository;


import com.officemanagement.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Repository("meetingRepository")
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
/*
    @Query("SELECT subject,start_time,end_time FROM meetings")
    public List<Meeting> findAll();
*/
}
