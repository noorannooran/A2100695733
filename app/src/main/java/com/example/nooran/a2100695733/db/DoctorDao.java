package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by nooran on 2017-11-23.
 * DAO for Doctor Entity
 */

public interface DoctorDao {
    @Query("SELECT * FROM doctor")
    List<Doctor> getAll();

    @Query("SELECT * FROM doctor WHERE doctorId IN (:doctorIds)")
    List<Doctor>loadAllByIds();

    @Insert
    void insertAll(Doctor... doctors);

    @Delete
    void delete(Doctor doctor);

}
