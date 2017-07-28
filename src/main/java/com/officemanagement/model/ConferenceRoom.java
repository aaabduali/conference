package com.officemanagement.model;

import javax.persistence.*;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Entity
@Table(name="conference_room")
public class ConferenceRoom  {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
        @Column(name="location")
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
