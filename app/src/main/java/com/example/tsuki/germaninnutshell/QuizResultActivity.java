package com.example.tsuki.germaninnutshell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    TextView resultLabel;
    TextView totalScoreLabel;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        resultLabel = (TextView) findViewById(R.id.resultLabel);
        totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);
        backButton = (Button) findViewById(R.id.backButton);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences settings = getSharedPreferences("GermaninNutshell", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore += score;

        resultLabel.setText(score + "/5");
        totalScoreLabel.setText("Total Score: " + totalScore);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizResultActivity.this, QuizMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
