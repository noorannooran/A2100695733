package com.example.nooran.a2100695733.db;

import com.example.nooran.a2100695733.models.Doctor;
import com.example.nooran.a2100695733.models.Nurse;
import com.example.nooran.a2100695733.models.Patient;
import com.example.nooran.a2100695733.models.Test;
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
    public static List<Test> testList;

    static
    {
        userList = new ArrayList<>();

        User user = new User("admin", "admin", "nurse");
        User user2 = new User("test_nurse", "password", "nurse");
        User user3 = new User("test_doctor", "password", "doctor");
        userList.add(user);
        userList.add(user2);
        userList.add(user3);

        doctorList = new ArrayList<>();

        Doctor doctor = new Doctor("J.W.", "Muller", "Psych");
        Doctor doctor2 = new Doctor("Leslie", "Thompkins", "Neurology");
        Doctor doctor3 = new Doctor("Rajko", "Neuman","GP");
        Doctor doctor4 = new Doctor("Nacio", "Kundakci","Cardiology");
        Doctor doctor5 = new Doctor("Armo", "Herczeg","Geriatrics");

        doctorList.add(doctor);
        doctorList.add(doctor2);
        doctorList.add(doctor3);
        doctorList.add(doctor4);
        doctorList.add(doctor5);

        nurseList = new ArrayList<>();

        Nurse nurse = new Nurse("Meredith", "Brun", "Psych");
        Nurse nurse2 = new Nurse("Iolanda", "Scezpanski", "Neurology");
        Nurse nurse3 = new Nurse("Zhanna", "Wolf", "GP");
        Nurse nurse4 = new Nurse("Yeong-Ho", "Acerbi", "Cardiology");
        Nurse nurse5 = new Nurse("Honoka", "Bartha", "Geriatrics");

        nurseList.add(nurse);
        nurseList.add(nurse2);
        nurseList.add(nurse3);
        nurseList.add(nurse4);
        nurseList.add(nurse5);

        patientList = new ArrayList<>();

        Patient patient1 = new Patient("Joe", "Smith", "Psych", 1, "3");
        Patient patient2 = new Patient("Sarah", "Li", "Neurology", 2, "C54");
        Patient patient3 = new Patient("Jamie", "Johnston", "GP", 3, "303");
        Patient patient4 = new Patient("Will", "Waxly","Cardiology", 4, "505");
        Patient patient5 = new Patient("Betty", "Jones", "Geriatrics", 5, "421");

        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);
        patientList.add(patient4);
        patientList.add(patient5);

        testList = new ArrayList<>();
        Test test1 = new Test("CBC", 2, 80, 120, 98.6f, 4.4f, 6.2f, 9f, "all normal");
        Test test2 = new Test("Routine", 3, 90, 100, 99.0f, 0f, 0f, 0f, "low blood pressure");
        Test test3 = new Test("Routine", 5, 120, 82, 96.4f, 0f, 0f, 0f, "all normal");
        Test test4 = new Test("BP", 4, 80, 140, 96f, 0f, 0f, 0f, "high blood pressure");
        Test test5 = new Test("BP", 1, 80, 120, 98.6f, 0f, 0f, 0f, "all normal");

        testList.add(test1);
        testList.add(test2);
        testList.add(test3);
        testList.add(test4);
        testList.add(test5);

    }




}
