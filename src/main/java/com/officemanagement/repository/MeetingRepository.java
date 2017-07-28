package com.officemanagement.repository;


import com.officemanagement.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Repository("meetingRepository")
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}
