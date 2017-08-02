package com.officemanagement.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
/*import java.util.Date;*/
import java.util.List;
import java.util.Set;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Entity
@Table(name="meetings")
@NamedQuery(name = "Meeting.fetchAllForCalendar",
        query="SELECT new Map(m.subject as title,concat( m.date,'T',m.start_time) as start,concat(m.date,'T',m.end_time) as end) from Meeting m" )
/*query = "SELECT subject as title,concat(date,'T',start_time)as start,concat(date,'T',end_time) as end FROM Meeting"*/
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

    @Column
    private Date date;

    @Column(name="start_time")
    private Time start_time;

    @Column(name="end_time")
    private Time end_time;

    @ManyToOne
    private Users called_by;

    @ManyToMany
    private List<Users> attendees;

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

    public Users getCalled_by() {
        return called_by;
    }

    public void setCalled_by(Users called_by) {
        this.called_by = called_by;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public List<Users> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Users> attendees) {
        this.attendees = attendees;
    }
}
