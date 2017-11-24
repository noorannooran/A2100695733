package com.example.nooran.a2100695733.db;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by nooran on 2017-11-23.
 * DAO for Nurse Table
 */

public interface NurseDao {
    @Query("SELECT * FROM nurse")
    List<Nurse> getAll();

    @Query("SELECT * FROM nurse WHERE nurseId IN (:nurseIds)")
    List<Nurse>loadAllByIds();

    @Insert
    void insertAll(Nurse nurses);

    @Delete
    void delete(Nurse nurse);


}
