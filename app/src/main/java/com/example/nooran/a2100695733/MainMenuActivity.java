package com.example.nooran.a2100695733;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenuActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //get intent extra from login activity
        String userType = getIntent().getStringExtra("user_type");

        ListView listView = (ListView)findViewById(R.id.listMenu);

        String[] menuArray;

        if(userType.equals("doctor")) {
            //load menu using doctor array
            menuArray = getResources().getStringArray(R.array.main_menu_doctor);
        }
        else
        {
            //userType = admin || nurse
            //load menu using nurse array
            menuArray = getResources().getStringArray(R.array.main_menu_nurse);
        }
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuArray);
        listView.setAdapter(listAdapter);
    }
}
