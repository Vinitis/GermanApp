package com.example.tsuki.germaninnutshell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GramActivity extends AppCompatActivity {

    Button buttonGram1;
    Button buttonGram2;
    Button buttonGram3;
    Button buttonGram4;
    Button buttonGram5;
    Button buttonGram6;
    Button buttonGram7;
    Button buttonGram8;
    Button buttonGram9;
    Button buttonGram10;
    Button buttonGram11;
    Button buttonGram12;

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gram);
        buttonGram1 = (Button) findViewById(R.id.buttonGram1);
        buttonGram2 = (Button) findViewById(R.id.buttonGram2);
        buttonGram3 = (Button) findViewById(R.id.buttonGram3);
        buttonGram4 = (Button) findViewById(R.id.buttonGram4);
        buttonGram5 = (Button) findViewById(R.id.buttonGram5);
        buttonGram6 = (Button) findViewById(R.id.buttonGram6);
        buttonGram7 = (Button) findViewById(R.id.buttonGram7);
        buttonGram8 = (Button) findViewById(R.id.buttonGram8);
        buttonGram9 = (Button) findViewById(R.id.buttonGram9);
        buttonGram10 = (Button) findViewById(R.id.buttonGram10);
        buttonGram11 = (Button) findViewById(R.id.buttonGram11);
        buttonGram12 = (Button) findViewById(R.id.buttonGram12);

        backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, CzasownikHabenActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, OdmianaCzasPrzezOsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, OdmianaCzasSeinActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, LiczebnikiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, LicznaMnogaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, RodzajnikiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, OdmianiaRodzajnikaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, ZaimekDzierzawczyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, StrukturaZdaniaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, StrukturaPytaniaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, GodzinyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGram12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GramActivity.this, BonusActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}