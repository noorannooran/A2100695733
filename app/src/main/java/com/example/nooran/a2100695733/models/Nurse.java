package com.example.nooran.a2100695733.models;



/**
 * Created by nooran on 2017-11-23.
 * Entity class for Nurse
 */


public class Nurse {
    private long id;
    private String firstName;
    private String lastName;
    private String department;

    //constructors
    //default
    public Nurse()
    {}

    //overloaded constructor
    public Nurse(long nurseId, String firstName, String lastName, String department) {
        this.id = nurseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }
    //constructor without nurseId
    public Nurse(String firstName, String lastName, String department) {
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

    //toString method returns "Nurse LastName"
    @Override
    public String toString() {
        return "Nurse " + lastName;
    }
}
