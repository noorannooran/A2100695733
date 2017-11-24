package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by nooran on 2017-11-23.
 */

@Database(entities = {User.class, Doctor.class, Nurse.class, Patient.class,
        Test.class}, version= 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract DoctorDao doctorDao();

    public abstract NurseDao nurseDao();

    public abstract PatientDao patientDao();

    public abstract TestDao testDao();

}
