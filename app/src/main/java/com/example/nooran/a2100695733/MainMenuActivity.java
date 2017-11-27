package com.example.nooran.a2100695733;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.R.id.list;

public class MainMenuActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //get intent extra from login activity
        String userType = getIntent().getStringExtra("user_type");

        ListView listView = getListView();

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = getListView();
                String selection = (String)listView.getItemAtPosition(position);
                Intent intent = null;

                switch(selection)
                {
                    case "Enter Test":
                        intent = new Intent(getApplicationContext(), EnterTest.class);
                        startActivity(intent);
                        break;
                    case "Enter Patient":
                        intent = new Intent(getApplicationContext(), EnterPatient.class);
                        startActivity(intent);
                        break;
                    case "Display Test":
                        intent = new Intent(getApplicationContext(), DisplayInformation.class);
                        intent.putExtra("info", "test");
                        startActivity(intent);
                        break;
                    case "Display Patient":
                        intent = new Intent(getApplicationContext(), DisplayInformation.class);
                        intent.putExtra("info", "patient");
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
