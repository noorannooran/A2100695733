package com.example.nooran.a2100695733.models;



/**
 * Created by nooran on 2017-11-23.
 *
 */


public class Doctor {

    private long id;
    private String firstName;
    private String lastName;
    private String department;

    //default
    public Doctor()
    {

    }
    //overloaded constructor
    public Doctor(long doctorId, String firstName, String lastName, String department) {
        this.id = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }
    //constructor without primary key doctorId
    public Doctor(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
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

    //toString method returns "Doctor LastName"
    @Override
    public String toString() {
        return "Doctor " + lastName;

    }
}
