package com.tp.lms.model;

import com.tp.lms.model.enums.Presenty;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 * 
 @author RAHUL */

@Entity
public class StaffAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "staff_attendance_id")
    private int id;

    @Column(name= "check_in")
    private Date checkIn;

    @Column(name= "check_out")
    private Date checkOut;



    
    @Enumerated(EnumType.STRING)
    @Column(name= "presenty")
    private Presenty presenty;

    // Getters and Setters
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Presenty getPresenty() {
        return presenty;
    }

    public void setPresenty(Presenty presenty) {
        this.presenty = presenty;
    }

    
}


    

