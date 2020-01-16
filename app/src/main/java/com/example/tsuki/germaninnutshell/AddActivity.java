package com.example.tsuki.germaninnutshell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    DBHelper mDBHelper;
    Button addButton;
    Button viewDataButton;
    EditText addText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addButton = (Button) findViewById(R.id.addButton);
        viewDataButton = (Button) findViewById(R.id.viewDataButton);
        addText = (EditText) findViewById(R.id.addText);

        mDBHelper = new DBHelper(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    wordCheck();
                } catch (CatchEx catchEx) {
                    catchEx.printStackTrace();
                }
            }
        });

        viewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, WordsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void addData(String newEntry) {
        boolean insertData = mDBHelper.addData(newEntry);

        if(insertData) {
            toastMessage("Data Inserted Successfully");
        } else {
            toastMessage("Fail!");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void wordCheck() throws CatchEx {

        String newEntry = addText.getText().toString();

        if(addText.length() != 0){
            addData(newEntry);
            addText.setText("");
        } else {
            CatchEx catchEx = new CatchEx();
            catchEx.setError("Pole nie moze być puste!");
            throw catchEx;
        }
    }
}
