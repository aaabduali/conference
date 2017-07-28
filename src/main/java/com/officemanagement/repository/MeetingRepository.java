package com.officemanagement.repository;


import com.officemanagement.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Repository("meetingRepository")
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    public List<Meeting> find(@Param("lastName") String lastName);
}
