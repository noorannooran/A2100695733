package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nooran on 2017-11-23.
 */

@Entity(forgeignKeys = @ForeignKey(entity = Doctor.class,
                                    parentColumns = "patientId",
                                    childColumns="doctorId" ))
public class Patient {
    @PrimaryKey (autoGenerate = true)
    private int patientId;

    @ColumnInfo
    private String firstName;

    @ColumnInfo
    private String lastName;

    @ColumnInfo
    private String department;

    @ColumnInfo(name="doctorId")
    public int doctorId;

    @ColumnInfo
    public String room;

    //constructor without patientId
    public Patient(String firstName, String lastName, String department, int doctorId, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.doctorId = doctorId;
        this.room = room;
    }
    //constructor without doctorId
    public Patient(int patientId, String firstName, String lastName, String department, String room) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.room = room;
    }
    //constructor without patient Id or doctor Id
    public Patient(String firstName, String lastName, String department, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.room = room;
    }

    //overloaded constructor
    public Patient(int patientId, String firstName, String lastName, String department, int doctorId, String room) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.doctorId = doctorId;
        this.room = room;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
