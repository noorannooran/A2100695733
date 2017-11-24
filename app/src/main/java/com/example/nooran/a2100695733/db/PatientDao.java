package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by nooran on 2017-11-23.
 * DAO for patient table
 */

public interface PatientDao {
    @Query("SELECT * FROM patient")
    List<Patient> getAll();

    @Query("SELECT * FROM patient WHERE patientId IN (:patientIds)")
    List<Patient> loadAllByIds(int[]patientIds);

    @Insert
    void insertAll(Patient... patients);

    //update statement? update patient with doctor id and room id?
    //@Update
    //update method here

    @Delete
    void delete(Patient patient);
}
