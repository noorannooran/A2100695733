package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nooran on 2017-11-23.
 * Entity class User
 */
@Entity

public class User {
    @PrimaryKey (autoGenerate = true)
    private int userId;

    @ColumnInfo
    private String password;

    @ColumnInfo
    private String userType;

    //constructors
    public User(int userId, String password, String userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    //getters and setters
    public int getUserIdid() {
        return userId;
    }

    public void setUserId(int uid) {
        this.userId = uid;
    }

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
