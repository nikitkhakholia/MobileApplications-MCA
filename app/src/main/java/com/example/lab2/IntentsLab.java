package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class IntentsLab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_lab);

        EditText username = findViewById(R.id.et_username);
        Button loginBtn=findViewById(R.id.login_btn);
        TextView forgotPassword =  findViewById(R.id.fp_tv);






        forgotPassword.setOnClickListener(v->{
            Toast toast = Toast.makeText(this, "This feature is coming soon.", Toast.LENGTH_LONG);
            toast.show();
        });
        loginBtn.setOnClickListener(v->{
            String un = username.getText().toString();
            ProgressBar progressBar = findViewById(R.id.progrss);
            progressBar.setVisibility(View.VISIBLE);
            Intent intent = new Intent(this, IntentsLab1.class);
            intent.putExtra("username", un);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(intent);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }, 2000);

        });


    }
}