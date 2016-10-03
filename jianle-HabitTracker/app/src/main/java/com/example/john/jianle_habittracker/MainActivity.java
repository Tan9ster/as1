package com.example.john.jianle_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/*
open gson file if exist

display from gson file

button switches activity
 */
public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "database.json";
    //private EditText bodyText;

    //private ListView oldlistHabits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bodyText = (EditText) findViewById(R.id.body);
        final ArrayList<habitItem> habitList = new ArrayList<habitItem>();
        final ArrayAdapter<habitItem> adapter;
        final ListView oldlistHabits = (ListView) findViewById(R.id.listHabits);
        adapter = new ArrayAdapter<habitItem>(this,android.R.layout.simple_list_item_1, habitList);
        oldlistHabits.setAdapter(adapter);

    }

    public void addnewHabit(View view) {
        Intent intent = new Intent(this, addnewHabit.class);
        startActivity(intent);

    }

    protected void onStart(){
        super.onStart();
        //loadFromFile();

    }


/*
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<habitItem>>(){}.getType();

            habitList = gson.fromJson(in,listType);
            Toast.makeText(this, "Employee Name    : "+habitList.get(0).getName(),Toast.LENGTH_SHORT).show();
            System.out.println("Employee Name    : "+habitList.get(0));
            System.out.println("Employee Name    : "+habitList.get(1));

        } catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file.
            habitList = new ArrayList<habitItem>();
        }
    }
            */
}

