package com.example.tsuki.germaninnutshell;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView mCountLabel;
    private TextView mQuestionLabel;
    private Button mAnswerBtn1;
    private Button mAnswerBtn2;
    private Button mAnswerBtn3;
    private Button mAnswerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    private static final int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            //{"Pytanie", "Poprawna", "Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3"}
            {"\"Godziny pracy\" po niemiecku to:", "Arbeitsstunden", "Taschenlampe", "Versammlungsfreiheit", " Verpflichtungen"},
            {"\"Ich habe eine tolle Nachricht.\" to po polsku:", " Mam wspaniałą wiadomość.", "Nie mogę tego znieść.", "Pocę się i drżę na całym ciele.", "Jestem tak przerażony."},
            {"2.osoba l.poj czasownika \"sein\" w czasie teraźniejszym to:", "bist", "bin", "sind", "sein"},
            {"\"Gewinn\" to po polsku:", "zysk", "krawat", "teczka", "długopis"},
            {"3. osoba l.poj. czasownika \"haben\" to:", "hat", "haben", "hast", "hab"},
            {"\"Haltestelle\" to po polsku:", "przystanek", "kwiatek", "parapet", "analiza"},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mCountLabel = (TextView) findViewById(R.id.countLabel);
        mQuestionLabel = (TextView) findViewById(R.id.questionLabel);
        mAnswerBtn1 = (Button) findViewById(R.id.answerBtn1);
        mAnswerBtn2 = (Button) findViewById(R.id.answerBtn2);
        mAnswerBtn3 = (Button) findViewById(R.id.answerBtn3);
        mAnswerBtn4 = (Button) findViewById(R.id.answerBtn4);


        for (int i = 0; i < quizData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        mCountLabel.setText("Pytanie " + quizCount);

        Random random = new Random();
        int randomNumber = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNumber);

        mQuestionLabel.setText(quiz.get(0));

        rightAnswer = quiz.get(1);
        quiz.remove(0);

        Collections.shuffle(quiz);

        mAnswerBtn1.setText(quiz.get(0));
        mAnswerBtn2.setText(quiz.get(1));
        mAnswerBtn3.setText(quiz.get(2));
        mAnswerBtn4.setText(quiz.get(3));

        quizArray.remove(randomNumber);

    }

    public void checkAnswer(View view) {

        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)) {
            alertTitle = "Poprawnie!";
            rightAnswerCount ++;
        } else {
            alertTitle = "Błąd :c";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Poprawna odpowiedź: " + rightAnswer);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(quizCount == QUIZ_COUNT) {
                    Intent intent = new Intent(QuizActivity.this, QuizResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                    finish();
                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}