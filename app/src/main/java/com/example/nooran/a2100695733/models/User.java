package com.example.nooran.a2100695733.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nooran on 2017-11-23.
 *  class User
 */

public class User {

    private long id;
    private String userName;
    private String password;
    private String userType;

    //constructors
    //default
    public User()
    {

    }

    //overloaded
    public User(long userId, String userName, String password, String userType) {
        this.id = userId;
        this.password = password;
        this.userType = userType;
    }

    //getters and setters
    public long getUserId() {
        return id;
    }

    public void setUserId(long uid) {
        this.id = uid;
    }

    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName = userName;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
