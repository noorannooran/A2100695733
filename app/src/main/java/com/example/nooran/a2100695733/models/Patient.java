package com.example.nooran.a2100695733.models;


/**
 * Created by nooran on 2017-11-23.

 */

public class Patient {

    private long id;
    private String firstName;
    private String lastName;
    private String department;
    private long doctorId;
    private String room;

    //constructors
    //default
    public Patient(){}

    //overloaded constructor
    public Patient(long patientId, String firstName, String lastName, String department, long doctorId, String room) {
        this.id = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.doctorId = doctorId;
        this.room = room;
    }
    //constructor without patient Id or doctor Id
    public Patient(String firstName, String lastName, String department, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.room = room;
    }
    //constructor without doctorId
    public Patient(long patientId, String firstName, String lastName, String department, String room) {
        this.id = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.room = room;
    }
    //constructor without patientId
    public Patient(String firstName, String lastName, String department, long doctorId, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.doctorId = doctorId;
        this.room = room;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id){this.id = id;}

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

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    //toString method returns "Patient FirstName LastName"
    @Override
    public String toString() {
        return "Patient " + firstName + " " + lastName;

    }
}
