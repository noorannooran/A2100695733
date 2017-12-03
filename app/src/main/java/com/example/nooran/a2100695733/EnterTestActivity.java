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
import com.example.nooran.a2100695733.models.Patient;
import com.example.nooran.a2100695733.models.Test;
import com.example.nooran.a2100695733.utilities.Validator;
import com.example.nooran.a2100695733.utilities.TextValidator;

import java.util.ArrayList;
import java.util.List;

public class EnterTestActivity extends Activity {

    private MedicDataSource dataSource;
    public final Validator val = new Validator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_test);

        dataSource = new MedicDataSource(this);
        dataSource.open();

        //get patients in database
        List<Patient> patients = dataSource.getAllPatients();

        //add patients to spinner drop down
        Spinner spinner = (Spinner)findViewById(R.id.patientSpinner);
        ArrayAdapter<Patient> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,patients);
        spinner.setAdapter(adapter);

        //add listener to test type
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
        //create test object
        Test test = createTestObj(view);

        //call database method createTest
        dataSource.createTest(test);

        //show success message
        CharSequence text = "Test added";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    // listener for test type (required)
     public void addListeners()
     {
         EditText testTypeText = (EditText) findViewById(R.id.testType);

         testTypeText.addTextChangedListener(new TextValidator(testTypeText){
             @Override
             public void validate(TextView textView, String s){
                 if(val.isEmpty(s))
                    textView.setError("required");
                 else
                     textView.setError(null);
             }

         });

     }

    public Test createTestObj(View view)
    {
        //get views
        EditText testTypeText = (EditText) findViewById(R.id.testType);
        //patient spinner
        Spinner patientSpinner = (Spinner) findViewById(R.id.patientSpinner);
        EditText bplText = (EditText) findViewById(R.id.bpl);
        EditText bphText = (EditText) findViewById(R.id.bph);
        EditText temperatureText = (EditText)findViewById(R.id.temperature);
        EditText redBloodText = (EditText) findViewById(R.id.redBlood);
        EditText whiteBloodText = (EditText) findViewById(R.id.whiteBlood);
        EditText hemoglobinText = (EditText) findViewById(R.id.hemoglobin);
        EditText commentText = (EditText) findViewById(R.id.comment);

        //replace values with default values if empty
        String testType = val.stringVal(testTypeText);
        Patient patient = (Patient)patientSpinner.getSelectedItem();
        long patientId = patient.getId();
        int bpl = val.validInt(bplText);
        int bph = val.validInt(bphText);
        Float temp = val.validFloat(temperatureText);
        Float redBlood = val.validFloat(redBloodText);
        Float whiteBlood = val.validFloat(whiteBloodText);
        Float hemoglobin = val.validFloat(hemoglobinText);


        String comment = val.validString(commentText);

        //create Test object
        Test test = new Test(testType, patientId, bpl, bph, temp, redBlood,
                whiteBlood, hemoglobin, comment);
        return test;
    }


}
