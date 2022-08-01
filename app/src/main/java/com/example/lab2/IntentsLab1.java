package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class IntentsLab1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_lab1);
        Intent intent = getIntent();

//        String username = intent.getStringExtra("username");

        TextView usernametv = findViewById(R.id.tv_username);
//        usernametv.setText(username);

        Button button = findViewById(R.id.btn_continue);
        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, ImplicitIntents.class);
            startActivity(intent1);
        });

    }
}