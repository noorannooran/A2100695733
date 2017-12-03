package com.example.nooran.a2100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nooran.a2100695733.db.MedicDataProvider;
import com.example.nooran.a2100695733.db.MedicDataSource;
import com.example.nooran.a2100695733.models.Doctor;
import com.example.nooran.a2100695733.models.Nurse;
import com.example.nooran.a2100695733.models.User;

public class LoginActivity extends Activity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private MedicDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dataSource = new MedicDataSource(this);

        dataSource.open();
        for (User user : MedicDataProvider.userList) {
            dataSource.createUser(user);
        }
        for(Doctor doctor: MedicDataProvider.doctorList){
            dataSource.createDoctor(doctor);
        }
        for(Nurse nurse: MedicDataProvider.nurseList){
            dataSource.createNurse(nurse);
        }

    }

    public void buttonClickHandler(View view) {
        //get input
        EditText userName = (EditText) findViewById(R.id.textUsername);
        EditText passWord = (EditText) findViewById(R.id.textPassword);

        String username = userName.getText().toString();
        String password = passWord.getText().toString();

        //get user from database
        User user = dataSource.getUser(username);

        //compare passwords
        if(user.getPassword().equals(password)) {
            //init intent
            Intent intent = new Intent(this, MainMenuActivity.class);

            //send userType to next activity
            intent.putExtra("user_type", user.getUserType());

            //start activity
            startActivity(intent);
        }
        else
        {
            CharSequence text = "username or password does not match";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }
    @Override
    protected void onResume()
    {
        super.onResume();

        //open connection to database
        dataSource.open();


    }
    @Override
    protected void onPause()
    {
        super.onPause();

        //close connection to database
        dataSource.close();
    }

}
