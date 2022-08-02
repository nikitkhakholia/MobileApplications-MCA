package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IntentsLab1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_lab1);
        Bundle bundle = getIntent().getExtras();

        String username;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                username = null;
            } else {
                username = extras.getString("username");
            }
        } else {
            username = (String) savedInstanceState.getSerializable("username");
        }
        TextView usernametv = findViewById(R.id.tv_username);
        if (username != null) {
            usernametv.setText(username);
            Toast.makeText(this, "Username received from login screen: " + username, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Rec: " + username, Toast.LENGTH_SHORT).show();
        }
        Button button = findViewById(R.id.btn_continue);
        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, ImplicitIntents.class);
            startActivity(intent1);
        });

    }
}