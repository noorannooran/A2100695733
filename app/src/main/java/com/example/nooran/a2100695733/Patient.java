package com.example.nooran.a2100695733;


/**
 * Created by nooran on 2017-11-23.
 * Entity class Patient
 */

public class Patient {

    private int patientId;
    private String firstName;
    private String lastName;
    private String department;
    private int doctorId;
    private String room;

    //overloaded constructor
    public Patient(int patientId, String firstName, String lastName, String department, int doctorId, String room) {
        this.patientId = patientId;
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
    public Patient(int patientId, String firstName, String lastName, String department, String room) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.room = room;
    }
    //constructor without patientId
    public Patient(String firstName, String lastName, String department, int doctorId, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.doctorId = doctorId;
        this.room = room;
    }

    //getters and setters
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

    //toString method returns "Patient FirstName LastName"
    @Override
    public String toString() {
        return "Patient " + firstName + " " + lastName;

    }
}