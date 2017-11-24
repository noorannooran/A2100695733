package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nooran on 2017-11-23.
 * Entity class for Test
 */

@Entity(foreignKeys = @ForeignKey(entity = Patient.class,
                                    parentColumns = "patientId",
                                    childColumns = "patientId"))
public class Test {

    @PrimaryKey
    private int testId;

    @ColumnInfo
    private String testType;

    @ColumnInfo
    private int patientId;

    @ColumnInfo
    private int bpl;

    @ColumnInfo
    private int bph;

    @ColumnInfo
    private float temperature;

    @ColumnInfo
    private float redBloodCount;

    @ColumnInfo
    private float whiteBloodCount;

    @ColumnInfo
    private float hemoglobin;

    @ColumnInfo
    private String comment;

    //overloaded constructor
    public Test(int testId, String testType, int patientId, int bpl, int bph,
                float temperature, float redBloodCount, float whiteBloodCount,
                float hemoglobin, String comment) {
        this.testId = testId;
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
    public Test(String testType, int patientId, int bpl, int bph,
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
    public Test(String testType, int patientId, int bpl, int bph, float temperature, String comment) {
        this.testType = testType;
        this.patientId = patientId;
        this.bpl = bpl;
        this.bph = bph;
        this.temperature = temperature;
        this.comment = comment;
    }

    //getters and setters
    public int getTestId() {
        return testId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
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
        return "Test{" +
                "testId=" + testId +
                ", testType='" + testType + '\'' +
                ", patientId=" + patientId +
                ", bpl=" + bpl +
                ", bph=" + bph +
                ", temperature=" + temperature +
                ", redBloodCount=" + redBloodCount +
                ", whiteBloodCount=" + whiteBloodCount +
                ", hemoglobin=" + hemoglobin +
                ", comment='" + comment + '\'' +
                '}';
    }
}

