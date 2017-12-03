package com.example.nooran.a2100695733;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nooran.a2100695733.db.MedicDataSource;
import com.example.nooran.a2100695733.db.MedicDatabaseHelper;
import com.example.nooran.a2100695733.models.Doctor;
import com.example.nooran.a2100695733.models.Patient;
import com.example.nooran.a2100695733.models.Test;

import java.util.List;

public class DisplayInfoActivity extends Activity {

    private MedicDataSource dataSource;
    private List<Patient> patients;
    private List<Test> tests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_information);

        dataSource = new MedicDataSource(this);
        dataSource.open();

        patients = dataSource.getAllPatients();
        tests = dataSource.getAllTests();
        //set on checked change listener + spinner item selected
        addRadioListener();


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
        on radio button selected, populate spinner with either patient
        or test data from database
     */
    public void addRadioListener()
    {
        RadioGroup radioSelection = (RadioGroup)findViewById(R.id.radioSelection);
        radioSelection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton button = (RadioButton)findViewById(checkedId);
                String text = button.getText().toString();
                if(text.equalsIgnoreCase("patient"))
                    setSpinnerPatient();
                else if(text.equalsIgnoreCase("test"))
                    setSpinnerTest();

            }
        });
    }
    /*
       on patient selected, set text to patient string
    */
    public void addPatientListener(Spinner spinner)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            TextView info = (TextView)findViewById(R.id.textInfo);
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l )
            {
                Patient patient = (Patient)adapterView.getItemAtPosition(i);
                info.setText(patient.patientString());
            }
            public void onNothingSelected(AdapterView<?>adapterView)
            {
                info.setText("");
            }

        });

    }
    /*
       on test selected, display test string
    */
    public void addTestListener(Spinner spinner)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            TextView info = (TextView)findViewById(R.id.textInfo);
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l )
            {
                Test test = (Test)adapterView.getItemAtPosition(i);
                info.setText(test.testString());
            }
            public void onNothingSelected(AdapterView<?>adapterView)
            {
                info.setText("");
            }

        });
    }
    //set spinner to patients, set listener
    public void setSpinnerPatient()
    {
        Spinner spinner = (Spinner)findViewById(R.id.spinnerData);
        ArrayAdapter<Patient> adapter = new ArrayAdapter<Patient>(this, R.layout.support_simple_spinner_dropdown_item, patients);
        spinner.setAdapter(adapter);

        addPatientListener(spinner);
    }
    //set spinner to tests, set listener
    public void setSpinnerTest()
    {
        Spinner spinner = (Spinner)findViewById(R.id.spinnerData);
        ArrayAdapter<Test> adapter = new ArrayAdapter<Test>(this, R.layout.support_simple_spinner_dropdown_item, tests);
        spinner.setAdapter(adapter);

        addTestListener(spinner);
    }


}
