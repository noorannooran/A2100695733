package com.example.nooran.a2100695733.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nooran on 2017-11-23.
 * class for Test
 */

public class Test {

    private long id;
    private String testType;
    private long patientId;
    private int bpl;
    private int bph;
    private float temperature;
    private float redBloodCount;
    private float whiteBloodCount;
    private float hemoglobin;
    private String comment;

    //constructors
    //default
    public Test(){}

    //overloaded constructor
    public Test(long testId, String testType, long patientId, int bpl, int bph,
                float temperature, float redBloodCount, float whiteBloodCount,
                float hemoglobin, String comment) {
        this.id = testId;
        this.testType = testType;
        this.patientId = patientId;
        this.bpl = bpl;
        this.bph = bph;
        this.temperature = temperature;
        this.redBloodCount = redBloodCount;
        this.whiteBloodCount = whiteBloodCount;
        this.hemoglobin = hemoglobin;
        this.comment = comment;
    }
    //constructor without testId
    public Test(String testType, long patientId, int bpl, int bph,
                float temperature, float redBloodCount, float whiteBloodCount,
                float hemoglobin, String comment) {
        this.testType = testType;
        this.patientId = patientId;
        this.bpl = bpl;
        this.bph = bph;
        this.temperature = temperature;
        this.redBloodCount = redBloodCount;
        this.whiteBloodCount = whiteBloodCount;
        this.hemoglobin = hemoglobin;
        this.comment = comment;
    }
    //constructor without testId and without blood count
    public Test(String testType, long patientId, int bpl, int bph, float temperature, String comment) {
        this.testType = testType;
        this.patientId = patientId;
        this.bpl = bpl;
        this.bph = bph;
        this.temperature = temperature;
        this.comment = comment;
    }

    //getters and setters
    public long getTestId() {
        return id;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public int getBpl() {
        return bpl;
    }

    public void setBpl(int bpl) {
        this.bpl = bpl;
    }

    public int getBph() {
        return bph;
    }

    public void setBph(int bph) {
        this.bph = bph;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getRedBloodCount() {
        return redBloodCount;
    }

    public void setRedBloodCount(float redBloodCount) {
        this.redBloodCount = redBloodCount;
    }

    public float getWhiteBloodCount() {
        return whiteBloodCount;
    }

    public void setWhiteBloodCount(float whiteBloodCount) {
        this.whiteBloodCount = whiteBloodCount;
    }

    public float getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(float hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Test" + id;
    }

    public String testString() {
        return "Test " + id + "\n" +
                "Test Type: " + testType + "\n" +
                "Patient Id: " + patientId + "\n" +
                "Blood Pressure: " + bph+ "\" + bpl \n" +
                "Temperature: " + temperature + " F \n" +
                "Red Blood Count: " + redBloodCount + "x1,000,000 \n" +
                "White Blood Count: " + whiteBloodCount + "x1000 \n" +
                "Hemoglobin: " + hemoglobin + "g/dL \n" +
                "Comment: " + comment;
    }
}

