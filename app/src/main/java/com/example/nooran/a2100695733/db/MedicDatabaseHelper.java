package com.example.nooran.a2100695733.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nooran.a2100695733.models.Doctor;
import com.example.nooran.a2100695733.models.Nurse;
import com.example.nooran.a2100695733.models.Patient;
import com.example.nooran.a2100695733.models.Test;
import com.example.nooran.a2100695733.models.User;

/**
 * Created by nooran on 2017-11-23.
 */

public class MedicDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "medicDB.db";
    private static final int DB_VERSION = 1;

    MedicDatabaseHelper(Context context)
    {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //create database tables
        db.execSQL(MedicContract.CREATE_USER_ENTRY_TABLE);
        db.execSQL(MedicContract.CREATE_DOCTOR_ENTRY_TABLE);
        db.execSQL(MedicContract.CREATE_NURSE_ENTRY_TABLE);
        db.execSQL(MedicContract.CREATE_PATIENT_ENTRY_TABLE);
        db.execSQL(MedicContract.CREATE_TEST_ENTRY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        //drop tables
        db.execSQL("DROP TABLE IF EXISTS " + MedicContract.TestEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MedicContract.PatientEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MedicContract.DoctorEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MedicContract.NurseEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MedicContract.UserEntry.TABLE_NAME);

        onCreate(db);
    }



}
