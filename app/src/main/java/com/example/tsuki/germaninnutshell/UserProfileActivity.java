package com.example.tsuki.germaninnutshell;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {

    TextView usernameLabel;
    EditText passwordLabel;
    Button passwordButton;
    TextView accountTypeLabel;
    Button backButton;
    ImageView vipImg;

    String secretKey = "Kocham Programowanie";
    String userKey = "";

    User user = new User();
    UserVip vip = new UserVip();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        usernameLabel = (TextView) findViewById(R.id.usernameLabel);
        accountTypeLabel = (TextView) findViewById(R.id.accountTypeLabel);
        passwordLabel = (EditText) findViewById(R.id.passwordLabel);
        passwordButton = (Button) findViewById(R.id.passwordButton);
        backButton = (Button) findViewById(R.id.backButton);
        vipImg = (ImageView) findViewById(R.id.vipImg);

        creatingUser();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, MainActivity.class);
                intent.putExtra("ACCOUNT_TYPE", user.accountType);
                startActivity(intent);
                finish();
            }
        });
    }

    public void creatingUser() {

        user.setUsername("Happy user");
        usernameLabel.setText(user.username);
        accountTypeLabel.setText(user.userTag);
    }

    public void buttonPress(View view) {
        userKey = passwordLabel.getText().toString();
        if(userKey.equals(secretKey)) {
            user.setAccountType(1);
            vip.setUsername("Epic user");
            accountTypeLabel.setText(vip.userTag);
            usernameLabel.setText(vip.username);
            vipImg.setImageResource(R.drawable.icon_vip);
            passwordLabel.setText("");
            closeKeyboard();
            Toast.makeText(this, "Witamy VIPa", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Błędne hasło :v", Toast.LENGTH_SHORT).show();
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)  getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}