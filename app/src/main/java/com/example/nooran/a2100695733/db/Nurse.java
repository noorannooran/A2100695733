package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nooran on 2017-11-23.
 * Entity class for Nurse
 */

@Entity
public class Nurse {
    @PrimaryKey
    private int nurseId;

    @ColumnInfo
    private String firstName;

    @ColumnInfo
    private String lastName;

    @ColumnInfo
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

    //toString method returns "Nurse LastName"
    @Override
    public String toString() {
        return "Nurse " + lastName;
    }
}
