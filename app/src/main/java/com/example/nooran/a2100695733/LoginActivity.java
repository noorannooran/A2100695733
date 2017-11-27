package com.example.nooran.a2100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.nooran.a2100695733.db.MedicDataSource;

public class LoginActivity extends Activity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private MedicDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dataSource = new MedicDataSource(this);
    }

    public void buttonClickHandler() {
        //validate input
        //if input matches
        Intent intent = new Intent(this, MainMenuActivity.class);

        //send userType to next activity

        //start activity
        startActivity(intent);

        //else: toast
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
