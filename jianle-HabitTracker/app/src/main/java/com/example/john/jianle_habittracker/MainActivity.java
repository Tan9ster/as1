package com.example.john.jianle_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

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
    private EditText bodyText;
    private ArrayList<habitItem> tweetList = new ArrayList<habitItem>();
    private ArrayAdapter<habitItem> adapter;
    private ListView oldlistHabits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bodyText = (EditText) findViewById(R.id.body);
        oldlistHabits = (ListView) findViewById(R.id.listHabits);

    }

    public void addnewHabit(View view) {
        Intent intent = new Intent(this, addnewHabit.class);
        startActivity(intent);

    }

    protected void onStart(){
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<habitItem>(this,
                R.layout.activity_main, tweetList);
        oldlistHabits.setAdapter(adapter);
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<habitItem>>(){}.getType();

            tweetList = gson.fromJson(in,listType);

        } catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file. */
            tweetList = new ArrayList<habitItem>();
        }
    }
}

    /*
    private void loadFromFile() { //load gson file where data on habits are going to be kept at
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

    public class ListClickHandler implements OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            // TODO Auto-generated method stub
            TextView listText = (TextView) view.findViewById(R.id.listText);
            String text = listText.getText().toString();
            Intent intent = new Intent(MainActivity.this, eachHabit.class);
            intent.putExtra("selected-item", text);
            startActivity(intent);

        }
        /*

}

/*on start()
    do stuff
    loadfile() this is for starting a file that will contain the history of a habit
    button add() do stuff

 */