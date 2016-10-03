package com.example.john.jianle_habittracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by john on 2016-09-24.
 *
 *
 *
 * start activity:
 * -open gson file, if none create a new gson file
 *
 *
 * save button save new habit to gson file
 */


public class addnewHabit extends AppCompatActivity {

    private static final String FILENAME = "datafile.json";
    private EditText nameText;
    private EditText whichdayText;
    private ArrayList<habitItem> habitList = new ArrayList<>();
    private ArrayAdapter<habitItem> adapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
        //somedata=getSharedPreferences(FILENAME,0);//
        nameText=(EditText)findViewById(R.id.addnewHabit);
        whichdayText=(EditText)findViewById(R.id.dateAdded);
    }

    protected void onStart(){

        super.onStart();
        //loadFromFile();
        adapter = new ArrayAdapter<habitItem>(this, R.layout.habit_item, habitList);
//      oldTweetsList.setAdapter(adapter);
    }

    //click on add to add new habit, close current activty, go back to main activty
    public void backtoMainactivityadd(View view){ //adding habit and storing data
        //String data2=sharedData.getText().toString();
        //SharedPreferences.Editor editor=somedata.edit();
        //editor.putString("string1", data2);
        //editor.commit();
        String text = nameText.getText().toString();

        String text2 = whichdayText.getText().toString();
        habitItem newHabit = new habitItem(text, text2);

        habitList.add(newHabit);
        adapter.notifyDataSetChanged();

        saveInFile();
        Toast.makeText(this, "Habit added!", LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        done();
    }
    //exit current activity and return to main activity
    public void backtoMainactivity(View view){ //if adding habit is cancelled
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        done();
    }
//based on sample code http://stackoverflow.com/questions/8226720/android-finish-current-activity-and-start-parent-activity
    public void done(){
        finish();
    }
//http://www.javainterviewpoint.com/read-write-json-using-gson/
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(habitList, out);
            //gson.toJson(string,out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
			/* Rethrow. */
            throw new RuntimeException(e);
        } catch (IOException e) {
			/* Rethrow. */
            throw new RuntimeException(e);
        }
    }
}


