package com.officemanagement.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Entity
@Table(name="meetings")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="subject")
    private String subject;

    @ManyToMany
    private Set<Department> department;

    @ManyToOne
    private ConferenceRoom conferenceRoom;

    @Column(name="start_time")
    private Date start_time;

    @Column(name="end_time")
    private Date end_time;

    @ManyToOne
    private Users called_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }

    public ConferenceRoom getConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Users getCalled_by() {
        return called_by;
    }

    public void setCalled_by(Users called_by) {
        this.called_by = called_by;
    }
}
