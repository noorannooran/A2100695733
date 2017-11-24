package com.example.nooran.a2100695733;



/**
 * Created by nooran on 2017-11-23.
 * Entity class for Nurse
 */


public class Nurse {
    private int nurseId;
    private String firstName;
    private String lastName;
    private String department;

    //constructors
    //overloaded constructor
    public Nurse(int nurseId, String firstName, String lastName, String department) {
        this.nurseId = nurseId;
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
    public int getNurseId() {
        return nurseId;
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

    //toString method returns "Nurse LastName"
    @Override
    public String toString() {
        return "Nurse " + lastName;
    }
}
