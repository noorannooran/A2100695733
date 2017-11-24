package com.example.nooran.a2100695733;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nooran on 2017-11-23.
 */

public class MedicDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "medicDB";
    private static final int DB_VERSION = 1;

    MedicDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //create user table
        db.execSQL("CREATE TABLE USER("
                    + "USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "PASSWORD TEXT,"
                    + "USER_TYPE TEXT);");
        //insert users

        //create doctor table
        db.execSQL("CREATE TABLE DOCTOR(" +
                "DOCTOR_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FIRST_NAME TEXT," +
                "LAST_NAME TEXT," +
                "DEPARTMENT TEXT);");

        //insert doctors

        db.execSQL("CREATE TABLE NURSE(" +
                "NURSE_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FIRST_NAME TEXT," +
                "LAST_NAME TEXT," +
                "DEPARTMENT TEXT);");

        //insert nurses

        //create patient table
        db.execSQL("CREATE TABLE PATIENT(" +
                "PATIENT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FIRST_NAME TEXT," +
                "LAST_NAME TEXT," +
                "DEPARTMENT TEXT," +
                "DOCTOR_ID INTEGER," +
                "ROOM TEXT," +
                "FOREIGN KEY (DOCTOR_ID) REFERENCES DOCTOR(DOCTOR_ID));");

        //insert patients


        //create test table
        db.execSQL("CREATE TABLE TEST(" +
                "TEST_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TEST_TYPE TEXT," +
                "PATIENT_ID INTEGER," +
                "BPL INTEGER," +
                "BPH INTEGER," +
                "TEMPERATURE FLOAT," +
                "RED_BLOOD_COUNT FLOAT," +
                "WHITE_BLOOD_COUNT FLOAT," +
                "HEMOGLOBIN FLOAT," +
                "COMMENT TEXT" +
                "FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(PATIENT_ID));");

        //insert tests


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion)
    {

    }
    //inserts
    private static void insertUser(SQLiteDatabase db, User user)
    {
        ContentValues userValues = new ContentValues();
        userValues.put("PASSWORD", user.getPassword());
        userValues.put("USER_TYPE", user.getUserType());

        db.insert("USER", null, userValues);
    }
    private static void insertDoctor(SQLiteDatabase db, Doctor doctor)
    {
        ContentValues doctorValues = new ContentValues();
        doctorValues.put("FIRST_NAME", doctor.getFirstName());
        doctorValues.put("LAST_NAME", doctor.getLastName());
        doctorValues.put("DEPARTMENT", doctor.getDepartment());

        db.insert("DOCTOR", null, doctorValues);

    }
    private static void insertNurse(SQLiteDatabase db, Nurse nurse)
    {
        ContentValues nurseValues = new ContentValues();
        nurseValues.put("FIRST_NAME", nurse.getFirstName());
        nurseValues.put("LAST_NAME", nurse.getLastName());
        nurseValues.put("DEPARTMENT", nurse.getDepartment());

        db.insert("NURSE", null, nurseValues);

    }
    private static void insertPatient(SQLiteDatabase db, Patient patient)
    {
        ContentValues patientValues = new ContentValues();
        patientValues.put("FIRST_NAME", patient.getFirstName());
        patientValues.put("LAST_NAME", patient.getLastName());
        patientValues.put("DEPARTMENT", patient.getDepartment());
        patientValues.put("DOCTOR_ID", patient.getDoctorId());
        patientValues.put("ROOM", patient.getRoom());

        db.insert("PATIENT", null, patientValues);
    }
    private static void insertTest(SQLiteDatabase db, Test test)
    {
        ContentValues testValues = new ContentValues();
        testValues.put("TEST_TYPE", test.getTestType());
        testValues.put("PATIENT_ID", test.getPatientId());
        testValues.put("BPH", test.getBph());
        testValues.put("BPL", test.getBpl());
        testValues.put("TEMPERATURE", test.getTemperature());
        testValues.put("RED_BLOOD_COUNT", test.getRedBloodCount());
        testValues.put("WHITE_BLOOD_COUNT", test.getWhiteBloodCount());
        testValues.put("HEMOGLOBIN", test.getHemoglobin());
        testValues.put("COMMENT", test.getComment());

        db.insert("TEST", null, testValues);
    }

}
