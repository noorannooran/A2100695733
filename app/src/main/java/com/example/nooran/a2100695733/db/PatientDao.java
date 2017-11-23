package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by nooran on 2017-11-23.
 */

public interface PatientDao {
    @Query("SELECT * FROM patient")
    List<Patient> getAll();

    @Query("SELECT * FROM patient WHERE patientId IN (:patientIds)")
    List<Patient> loadAllByIds(int[]patientIds);

    @Insert
    void insertAll(Patient... patients);

    @Delete
    void delete(Patient patient);
}
