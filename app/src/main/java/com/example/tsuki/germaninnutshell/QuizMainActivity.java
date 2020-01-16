package com.example.tsuki.germaninnutshell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizMainActivity extends AppCompatActivity {

    Button backButton;
    Button easyBtn;
    Button medBtn;
    Button hardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        easyBtn = (Button) findViewById(R.id.easyBtn);
        medBtn = (Button) findViewById(R.id.medBtn);
        hardBtn = (Button) findViewById(R.id.hardBtn);
        backButton = (Button) findViewById(R.id.backButton);

//        easyBtn.setAlpha((float) 0.6);
//        medBtn.setAlpha((float) 0.6);
//        hardBtn.setAlpha((float) 0.6);

        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizMainActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });

        medBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizMainActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });

        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizMainActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizMainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
