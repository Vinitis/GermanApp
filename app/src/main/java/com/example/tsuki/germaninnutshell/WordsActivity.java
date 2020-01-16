package com.example.tsuki.germaninnutshell;

import android.content.Intent;
import android.database.Cursor;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordsActivity extends AppCompatActivity {

    private static final String TAG = "WordsActivity";

    DBHelper mDBHelper;

    private ListView mListView;
    Button addWordButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        addWordButton = (Button) findViewById(R.id.addWordButton);
        backButton = (Button) findViewById(R.id.backButton);
        mListView = (ListView) findViewById(R.id.listView);
        mDBHelper = new DBHelper(this);

        populateListView();

        addWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordsActivity.this, AddActivity.class);
                startActivity(intent);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView");
        Cursor data = mDBHelper.getData();

        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            // COL2 = 1
            //[0, 1, 2,...]
            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
