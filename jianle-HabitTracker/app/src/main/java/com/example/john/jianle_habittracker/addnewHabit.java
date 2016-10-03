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

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

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
    private EditText dateText;
    private ListView oldTweetsList;
    private ArrayList<habitItem> tweetList = new ArrayList<>();
    private ArrayAdapter<habitItem> adapter;
    SharedPreferences somedata;//
    EditText sharedData;//
    TextView dataResult;//

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
        //somedata=getSharedPreferences(FILENAME,0);//
        nameText=(EditText)findViewById(R.id.addnewHabit);
        dateText=(EditText)findViewById(R.id.dateAdded);
    }

    protected void onStart(){

        super.onStart();
        //loadFromFile();
        adapter = new ArrayAdapter<habitItem>(this, R.layout.habit_item, tweetList);
//      oldTweetsList.setAdapter(adapter);
    }
    /*
    public void backtoMainactivityadd(View view){ //adding habit and storing data
        String text1=nameText.getText().toString();
        nameText.setText("");
        saveInFile();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        done();
    }
    */

    public void backtoMainactivityadd(View view){ //adding habit and storing data
        //String data2=sharedData.getText().toString();
        //SharedPreferences.Editor editor=somedata.edit();
        //editor.putString("string1", data2);
        //editor.commit();
        String text = nameText.getText().toString();
        habitItem newHabit = new habitItem(text);
        tweetList.add(newHabit);
        adapter.notifyDataSetChanged();

        //saveInFile();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        done();
    }

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
            gson.toJson(tweetList, out);
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



/*
    private void saveInFile() {
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(FILENAME, 0));

            out.write(nameText.getText().toString());

            out.close();
            Toast.makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG).show();
        }

        catch (Throwable t) {
            Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
        }
    }

*/
