package com.example.nooran.a2100695733.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nooran.a2100695733.models.Doctor;
import com.example.nooran.a2100695733.models.Nurse;
import com.example.nooran.a2100695733.models.Patient;
import com.example.nooran.a2100695733.models.Test;
import com.example.nooran.a2100695733.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nooran on 2017-11-26.
 * wrapper class for database
 */

public class MedicDataSource {

    private static final String TAG = MedicDataSource.class.getSimpleName();

    private SQLiteDatabase db;
    private MedicDatabaseHelper dbHelper;

    public MedicDataSource(Context context) {
        this.dbHelper = new MedicDatabaseHelper(context);

    }

    //access database
    public void open() {
        this.db = dbHelper.getWritableDatabase();

        Log.d(TAG, "database is open");
    }

    //close method
    public void close() {
        dbHelper.close();

        Log.d(TAG, "database is closed");
    }

    //insert database methods
    public void createUser(User user) {
        ContentValues userValues = new ContentValues();
        userValues.put(MedicContract.UserEntry.COLUMN_USERNAME, user.getUserName());
        userValues.put(MedicContract.UserEntry.COLUMN_PASSWORD, user.getPassword());
        userValues.put(MedicContract.UserEntry.COLUMN_USER_TYPE, user.getUserType());

        long rowId = db.insert(MedicContract.UserEntry.TABLE_NAME, null, userValues);

        Log.d(TAG, "user with id: " + rowId + " inserted");
    }

    public void createDoctor(Doctor doctor) {
        ContentValues doctorValues = new ContentValues();
        doctorValues.put(MedicContract.DoctorEntry.COLUMN_FIRST_NAME, doctor.getFirstName());
        doctorValues.put(MedicContract.DoctorEntry.COLUMN_LAST_NAME, doctor.getLastName());
        doctorValues.put(MedicContract.DoctorEntry.COLUMN_DEPARTMENT, doctor.getDepartment());

        long rowId = db.insert(MedicContract.DoctorEntry.TABLE_NAME, null, doctorValues);

        Log.d(TAG, "doctor with id: " + rowId + " inserted");
    }

    public void createNurse(Nurse nurse) {
        ContentValues nurseValues = new ContentValues();
        nurseValues.put(MedicContract.NurseEntry.COLUMN_FIRST_NAME, nurse.getFirstName());
        nurseValues.put(MedicContract.NurseEntry.COLUMN_LAST_NAME, nurse.getLastName());
        nurseValues.put(MedicContract.NurseEntry.COLUMN_DEPARTMENT, nurse.getDepartment());

        long rowId = db.insert(MedicContract.NurseEntry.TABLE_NAME, null, nurseValues);

        Log.d(TAG, "nurse with id: " + rowId + " inserted");
    }

    public void createPatient(Patient patient) {
        ContentValues patientValues = new ContentValues();
        patientValues.put(MedicContract.PatientEntry.COLUMN_FIRST_NAME, patient.getFirstName());
        patientValues.put(MedicContract.PatientEntry.COLUMN_LAST_NAME, patient.getLastName());
        patientValues.put(MedicContract.PatientEntry.COLUMN_DEPARTMENT, patient.getDepartment());
        patientValues.put(MedicContract.PatientEntry.COLUMN_DOCTOR_ID, patient.getDoctorId());
        patientValues.put(MedicContract.PatientEntry.COLUMN_ROOM, patient.getRoom());

        long rowId = db.insert(MedicContract.PatientEntry.TABLE_NAME, null, patientValues);

        Log.d(TAG, "patient with id: " + rowId + " inserted");
    }

    public void createTest(Test test) {
        ContentValues testValues = new ContentValues();
        testValues.put(MedicContract.TestEntry.COLUMN_TEST_TYPE, test.getTestType());
        testValues.put(MedicContract.TestEntry.COLUMN_PATIENT_ID, test.getPatientId());
        testValues.put(MedicContract.TestEntry.COLUMN_BPL, test.getBpl());
        testValues.put(MedicContract.TestEntry.COLUMN_BPH, test.getBph());
        testValues.put(MedicContract.TestEntry.COLUMN_TEMPERATURE, test.getTemperature());
        testValues.put(MedicContract.TestEntry.COLUMN_RED_BLOOD_COUNT, test.getRedBloodCount());
        testValues.put(MedicContract.TestEntry.COLUMN_WHITE_BLOOD_COUNT, test.getWhiteBloodCount());
        testValues.put(MedicContract.TestEntry.COLUMN_HEMOGLOBIN, test.getHemoglobin());
        testValues.put(MedicContract.TestEntry.COLUMN_COMMENT, test.getComment());

        long rowId = db.insert(MedicContract.TestEntry.TABLE_NAME, null, testValues);

        Log.d(TAG, "test with id " + rowId + "inserted");

    }

    //select database methods
    public User getUser(String userName) {
        User user = new User();
        String selection = MedicContract.UserEntry.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query(MedicContract.UserEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);

        try {
            cursor.moveToFirst();

            user.setUserId(cursor.getInt(cursor.getColumnIndex(MedicContract.UserEntry._ID)));
            user.setUserName(cursor.getString(cursor.getColumnIndex(MedicContract.UserEntry.COLUMN_USERNAME)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(MedicContract.UserEntry.COLUMN_PASSWORD)));
            user.setUserType(cursor.getString(cursor.getColumnIndex(MedicContract.UserEntry.COLUMN_USER_TYPE)));


            Log.d(TAG, "user with username " + userName + "selected");

        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return user;
    }

    public Doctor getDoctor(int id) {
        Doctor doctor = new Doctor();

        String selection = MedicContract.DoctorEntry._ID + "=?";
        String[] selectionArgs = {Integer.toString(id)};

        Cursor cursor = db.query(MedicContract.DoctorEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);

        try {
            cursor.moveToFirst();


            doctor.setId(cursor.getInt(cursor.getColumnIndex(MedicContract.DoctorEntry._ID)));
            doctor.setFirstName(cursor.getString(cursor.getColumnIndex(MedicContract.DoctorEntry.COLUMN_FIRST_NAME)));
            doctor.setLastName(cursor.getString(cursor.getColumnIndex(MedicContract.DoctorEntry.COLUMN_LAST_NAME)));
            doctor.setDepartment(cursor.getString(cursor.getColumnIndex(MedicContract.DoctorEntry.COLUMN_DEPARTMENT)));

            Log.d(TAG, "doctor with id : " + id + " selected");
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }
        return doctor;

    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();

        Cursor cursor = db.query(MedicContract.DoctorEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        try {
            while (cursor.moveToNext()) {
                int doctorId = cursor.getInt(cursor.getColumnIndex(MedicContract.DoctorEntry._ID));
                String first = cursor.getString(cursor.getColumnIndex(MedicContract.DoctorEntry.COLUMN_FIRST_NAME));
                String last = cursor.getString(cursor.getColumnIndex(MedicContract.DoctorEntry.COLUMN_LAST_NAME));
                String department = cursor.getString(cursor.getColumnIndex(MedicContract.DoctorEntry.COLUMN_DEPARTMENT));

                Doctor doctor = new Doctor(doctorId, first, last, department);
                doctors.add(doctor);

                Log.d(TAG, "doctor with id: " + doctorId + " selected");
            }
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }
        return doctors;
    }

    public Nurse getNurse(int id) {
        Nurse nurse = new Nurse();
        String selection = MedicContract.NurseEntry._ID + "=?";

        String[] selectionArgs = {Integer.toString(id)};

        Cursor cursor = db.query(MedicContract.NurseEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);

        try {
            cursor.moveToFirst();

            nurse.setId(cursor.getInt(cursor.getColumnIndex(MedicContract.NurseEntry._ID)));
            nurse.setFirstName(cursor.getString(cursor.getColumnIndex(MedicContract.NurseEntry.COLUMN_FIRST_NAME)));
            nurse.setLastName(cursor.getString(cursor.getColumnIndex(MedicContract.NurseEntry.COLUMN_LAST_NAME)));
            nurse.setDepartment(cursor.getString(cursor.getColumnIndex(MedicContract.NurseEntry.COLUMN_DEPARTMENT)));

            Log.d(TAG, "nurse with id: " + id + " selected");
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }
        return nurse;
    }

    public Patient getPatient(int id) {
        Patient patient = new Patient();

        String selection = MedicContract.PatientEntry._ID + "=?";
        String[] selectionArgs = {Integer.toString(id)};

        Cursor cursor = db.query(MedicContract.PatientEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);

        try {
            cursor.moveToFirst();

            patient.setId(id);
            patient.setFirstName(cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_FIRST_NAME)));
            patient.setLastName(cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_LAST_NAME)));
            patient.setDepartment(cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_DEPARTMENT)));
            patient.setDoctorId(cursor.getInt(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_DOCTOR_ID)));
            patient.setRoom(cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_ROOM)));

            Log.d(TAG, "Patient with id: " + id + " selected");
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }

        return patient;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();

        Cursor cursor = db.query(MedicContract.PatientEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        try {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(MedicContract.PatientEntry._ID));
                int doctorId = cursor.getInt(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_DOCTOR_ID));
                String first = cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_FIRST_NAME));
                String last = cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_LAST_NAME));
                String department = cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_DEPARTMENT));
                String room = cursor.getString(cursor.getColumnIndex(MedicContract.PatientEntry.COLUMN_ROOM));

                Patient patient = new Patient(id, first, last, department, doctorId, room);
                patients.add(patient);

                Log.d(TAG, "patient with id: " + doctorId + " selected");
            }
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }
        return patients;
    }

    public Test getTest(int testId) {
        Test test = new Test();

        String selection = MedicContract.TestEntry._ID + "=?";
        String[] selectionArgs = {Integer.toString(testId)};

        Cursor cursor = db.query(MedicContract.TestEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);

        try {
            cursor.moveToFirst();

            test.setPatientId(cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_PATIENT_ID)));
            test.setTestType(cursor.getString(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_TEST_TYPE)));
            test.setBph(cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_BPH)));
            test.setBpl(cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_BPL)));
            test.setTemperature(cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_TEMPERATURE)));
            test.setRedBloodCount(cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_RED_BLOOD_COUNT)));
            test.setWhiteBloodCount(cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_WHITE_BLOOD_COUNT)));
            test.setHemoglobin(cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_HEMOGLOBIN)));
            test.setComment(cursor.getString(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_COMMENT)));


            Log.d(TAG, "test with id " + testId + " selected");
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }

        return test;

    }

    public List<Test> getAllTestsByPatient(int patientId) {
        List<Test> tests = new ArrayList<>();

        String selection = MedicContract.TestEntry.COLUMN_PATIENT_ID + "=?";
        String[] selectionArgs = {Integer.toString(patientId)};

        Cursor cursor = db.query(MedicContract.TestEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);

        try {
            while (cursor.moveToNext()) {
                int testId = cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry._ID));
                String testType = cursor.getString(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_TEST_TYPE));
                int bph = cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_BPH));
                int bpl = cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_BPL));
                float temperature = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_TEMPERATURE));
                float redBlood = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_RED_BLOOD_COUNT));
                float whiteBlood = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_WHITE_BLOOD_COUNT));
                float hem = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_HEMOGLOBIN));
                String comment = cursor.getString(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_COMMENT));

                Test test = new Test(testId, testType, patientId, bpl, bph,
                        temperature, redBlood, whiteBlood, hem, comment);

                tests.add(test);
                Log.d(TAG, "test with id " + testId + " selected");
            }
        }
        finally{
                if (cursor!= null && !cursor.isClosed())
                    cursor.close();
            }



        return tests;

    }

    public List<Test> getAllTests() {
        List<Test> tests = new ArrayList<>();

        Cursor cursor = db.query(MedicContract.TestEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        try {
            while (cursor.moveToNext()) {
                int testId = cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry._ID));
                int patientId = cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_PATIENT_ID));
                String testType = cursor.getString(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_TEST_TYPE));
                int bph = cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_BPH));
                int bpl = cursor.getInt(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_BPL));
                float temperature = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_TEMPERATURE));
                float redBlood = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_RED_BLOOD_COUNT));
                float whiteBlood = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_WHITE_BLOOD_COUNT));
                float hem = cursor.getFloat(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_HEMOGLOBIN));
                String comment = cursor.getString(cursor.getColumnIndex(MedicContract.TestEntry.COLUMN_COMMENT));

                Test test = new Test(testId, testType, patientId, bpl, bph,
                        temperature, redBlood, whiteBlood, hem, comment);

                tests.add(test);
                Log.d(TAG, "test with id " + testId + " selected");

            }
        }
        finally{
                if(cursor!=null && !cursor.isClosed())
                    cursor.close();
            }


        return tests;
    }
}
