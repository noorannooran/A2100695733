package com.example.nooran.a2100695733.db;

import com.example.nooran.a2100695733.models.Doctor;
import com.example.nooran.a2100695733.models.Nurse;
import com.example.nooran.a2100695733.models.Patient;
import com.example.nooran.a2100695733.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nooran on 2017-11-26.
 * to populate the database with dummy data
 */

public class MedicDataProvider {
    public static List<User> userList;
    public static List<Doctor> doctorList;
    public static List<Nurse> nurseList;
    public static List<Patient> patientList;

    static
    {
        userList = new ArrayList<>();

        User user = new User("admin", "admin", "nurse");
        userList.add(user);
    }




}
