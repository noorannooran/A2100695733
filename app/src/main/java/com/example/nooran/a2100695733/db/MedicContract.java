package com.example.nooran.a2100695733.db;

import android.provider.BaseColumns;

/**
 * Created by nooran on 2017-11-26.
 */

final class MedicContract {

    private MedicContract(){}

    static final String CREATE_USER_ENTRY_TABLE =
            "CREATE TABLE " + UserEntry.TABLE_NAME +
                    " ( " +
                    UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    UserEntry.COLUMN_USERNAME + " TEXT NOT NULL, " +
                    UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL, " +
                    UserEntry.COLUMN_USER_TYPE + " TEXT, " +
                    "UNIQUE ( " + UserEntry.COLUMN_USERNAME + ", " + UserEntry._ID + "))";

    static final String CREATE_DOCTOR_ENTRY_TABLE =
            "CREATE TABLE " + DoctorEntry.TABLE_NAME +
                " ( " +
                DoctorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DoctorEntry.COLUMN_FIRST_NAME + " TEXT, " +
                DoctorEntry.COLUMN_LAST_NAME + " TEXT, " +
                DoctorEntry.COLUMN_DEPARTMENT + " TEXT, " +
                    "UNIQUE ( " + DoctorEntry._ID + ") ON CONFLICT REPLACE)";

    static final String CREATE_NURSE_ENTRY_TABLE =
            "CREATE TABLE " + NurseEntry.TABLE_NAME +
                    "( " +
                    NurseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NurseEntry.COLUMN_FIRST_NAME + " TEXT, " +
                    NurseEntry.COLUMN_LAST_NAME + " TEXT, " +
                    NurseEntry.COLUMN_DEPARTMENT + " TEXT, " +
                    " UNIQUE ( " + NurseEntry._ID + ") ON CONFLICT REPLACE)";

    static final String CREATE_PATIENT_ENTRY_TABLE =
            "CREATE TABLE " + PatientEntry.TABLE_NAME +
            " ( " +
                    PatientEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PatientEntry.COLUMN_FIRST_NAME + " TEXT, " +
            PatientEntry.COLUMN_LAST_NAME + " TEXT, " +
            PatientEntry.COLUMN_DEPARTMENT + " TEXT, " +
            PatientEntry.COLUMN_DOCTOR_ID + " INTEGER NOT NULL " +
                    "REFERENCES " + DoctorEntry.TABLE_NAME + "," +
            PatientEntry.COLUMN_ROOM + " TEXT," +
            "UNIQUE ( " + PatientEntry._ID + ") ON CONFLICT REPLACE)";

    static final String CREATE_TEST_ENTRY_TABLE =
            "CREATE TABLE " + TestEntry.TABLE_NAME + "( " +
            TestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TestEntry.COLUMN_TEST_TYPE + " TEXT, " +
                    TestEntry.COLUMN_PATIENT_ID + " INTEGER NOT NULL " +
                    "REFERENCES " + PatientEntry.TABLE_NAME + "," +
                    TestEntry.COLUMN_BPL + " INTEGER, " +
                    TestEntry.COLUMN_BPH + " INTEGER, " +
                    TestEntry.COLUMN_TEMPERATURE + " FLOAT, " +
                    TestEntry.COLUMN_RED_BLOOD_COUNT + " FLOAT, " +
                    TestEntry.COLUMN_WHITE_BLOOD_COUNT + " FLOAT, " +
                    TestEntry.COLUMN_HEMOGLOBIN + " FLOAT, " +
                    TestEntry.COLUMN_COMMENT  + " TEXT, " +
                    "UNIQUE ( " + TestEntry._ID + ") ON CONFLICT REPLACE)";

    public static class UserEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_USERNAME="username";
        public static final String COLUMN_PASSWORD="password";
        public static final String COLUMN_USER_TYPE="user_type";
    }
    public static class DoctorEntry implements BaseColumns
    {
        public static final String TABLE_NAME="doctor";
        public static final String COLUMN_FIRST_NAME="first_name";
        public static final String COLUMN_LAST_NAME="last_name";
        public static final String COLUMN_DEPARTMENT="department";
    }
    public static class NurseEntry implements BaseColumns
    {
        public static final String TABLE_NAME="nurse";
        public static final String COLUMN_FIRST_NAME="first_name";
        public static final String COLUMN_LAST_NAME="last_name";
        public static final String COLUMN_DEPARTMENT="department";

    }
    public static class PatientEntry implements BaseColumns
    {
        public static final String TABLE_NAME="patient";
        public static final String COLUMN_FIRST_NAME="first_name";
        public static final String COLUMN_LAST_NAME="last_name";
        public static final String COLUMN_DEPARTMENT="department";
        public static final String COLUMN_DOCTOR_ID="doctor_id";
        public static final String COLUMN_ROOM="room";
    }
    public static class TestEntry implements BaseColumns
    {
        public static final String TABLE_NAME="test";
        public static final String COLUMN_TEST_TYPE="test_type";
        public static final String COLUMN_PATIENT_ID= "patient_id";
        public static final String COLUMN_BPL="bpl";
        public static final String COLUMN_BPH="bph";
        public static final String COLUMN_TEMPERATURE="temperature";
        public static final String COLUMN_RED_BLOOD_COUNT="red_blood_count";
        public static final String COLUMN_WHITE_BLOOD_COUNT="white_blood_count";
        public static final String COLUMN_HEMOGLOBIN="hemoglobin";
        public static final String COLUMN_COMMENT="comment";
    }
}
