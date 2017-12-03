package com.example.nooran.a2100695733;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nooran.a2100695733.db.MedicDataSource;
import com.example.nooran.a2100695733.models.Doctor;
import com.example.nooran.a2100695733.models.Patient;
import com.example.nooran.a2100695733.utilities.TextValidator;
import com.example.nooran.a2100695733.utilities.Validator;

import java.util.List;

public class EnterPatientActivity extends Activity {

    private MedicDataSource dataSource;

    public final Validator val = new Validator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_patient);

        dataSource = new MedicDataSource(this);
        dataSource.open();

        //get all doctors from database
        List<Doctor> doctors = dataSource.getAllDoctors();

        //add doctors to dropdown list for doctors
        Spinner doctorSpinner = (Spinner)findViewById(R.id.doctorSpinner);
        ArrayAdapter<Doctor> adapter = new ArrayAdapter<Doctor>(this, R.layout.support_simple_spinner_dropdown_item, doctors);
        doctorSpinner.setAdapter(adapter);

        //add listeners
        addListeners();

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        dataSource.open();
    }
    @Override
    protected void onPause()
    {
        super.onPause();

        //close connection to database
        dataSource.close();
    }
    /*
        On button click -> enter data in database
        toast message with success or failure
     */
    public void buttonClickHandler(View view)
    {
        //create patient object
        Patient patient = createPatientObj(view);

        //call database method createPatient
        dataSource.createPatient(patient);

        //display success toast
        CharSequence text = "Patient added";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }
    public Patient createPatientObj(View view)
    {
        //get views
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText)findViewById(R.id.lastName);
        EditText department = (EditText)findViewById(R.id.department);
        //doctor spinner
        Spinner doctorSpinner = (Spinner) findViewById(R.id.doctorSpinner);
        EditText room = (EditText)findViewById(R.id.room);

        String first = val.stringVal(firstName);
        String last = val.stringVal(lastName);
        String depart = val.stringVal(department);
        Doctor doctor = (Doctor)doctorSpinner.getSelectedItem();
        long doctorId = doctor.getId();
        String roomNo = val.stringVal(room);

        Patient patient = new Patient(first, last, depart, doctorId, roomNo);
        return patient;

    }

    public void addListeners()
    {
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText)findViewById(R.id.lastName);
        EditText department = (EditText)findViewById(R.id.department);
        EditText room = (EditText)findViewById(R.id.room);

        firstName.addTextChangedListener(new TextValidator(firstName){
            @Override
            public void validate(TextView textView, String s){
                if(val.isEmpty(s))
                    textView.setError("required");
                else
                    textView.setError(null);
            }

        });
        lastName.addTextChangedListener(new TextValidator(lastName){
            @Override
            public void validate(TextView textView, String s){
                if(val.isEmpty(s))
                    textView.setError("required");
                else
                    textView.setError(null);
            }

        });
        department.addTextChangedListener(new TextValidator(department){
            @Override
            public void validate(TextView textView, String s){
                if(val.isEmpty(s))
                    textView.setError("required");
                else
                    textView.setError(null);
            }

        });
        room.addTextChangedListener(new TextValidator(room){
            @Override
            public void validate(TextView textView, String s){
                if(val.isEmpty(s))
                    textView.setError("required");
                else
                    textView.setError(null);
            }

        });

    }
}
