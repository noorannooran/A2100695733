package com.example.nooran.a2100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    //on button click -> intent to login activity
    public void buttonClickHandler(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }
}
