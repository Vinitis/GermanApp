package com.example.tsuki.germaninnutshell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonWords;
    Button buttonGramm;
    Button buttonQuiz;
    Button buttonProfile;
    int accessValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonProfile = (Button) findViewById(R.id.buttonProfile);
        buttonWords = (Button) findViewById(R.id.buttonWords);
        buttonGramm = (Button) findViewById(R.id.buttonGramm);
        buttonQuiz = (Button) findViewById(R.id.buttonQuiz);

        buttonWords.setAlpha((float) 0.6);
        buttonGramm.setAlpha((float) 0.6);
        buttonProfile.setAlpha((float) 0.6);
        buttonQuiz.setAlpha((float) 0.6);

        buttonWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WordsActivity.class);
                startActivity(intent);
            }
        });

        buttonGramm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GramActivity.class);
                startActivity(intent);
            }
        });

//        buttonQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
//                startActivity(intent);
//            }
//        });

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    public void quizAccess(View view) {

        accessValue = getIntent().getIntExtra("ACCOUNT_TYPE", 2);

        System.out.println(accessValue);

        if(accessValue == 1) {
            Intent intent = new Intent(MainActivity.this, QuizMainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Tylko dla VIP'ów", Toast.LENGTH_SHORT).show();
        }

    }
}
