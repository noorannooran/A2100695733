package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by nooran on 2017-11-23.
 * DAO for Test Table
 */

public interface TestDao {
    @Query("SELECT * FROM test")
    List<Test> getAll();

    @Query("SELECT * FROM test WHERE testId IN (:testIds)")
    List<Test>loadAllByIds();

    @Query("SELECT * FROM test WHERE patientId IN (:patientIds)")
    List<Test>loadAllByPatientIds();

    @Insert
    void insertAll(Test tests);

    @Delete
    void delete(Test test);
}
