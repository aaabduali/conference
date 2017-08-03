package com.officemanagement.repository;


import com.officemanagement.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.sql.Time;
import java.util.List;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Repository("meetingRepository")

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting>fetchAllForCalendar();


}
