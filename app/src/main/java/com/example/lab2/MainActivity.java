package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.iv1);
        TextView tv = findViewById(R.id.tv1);
        EditText et = findViewById(R.id.et1);
        Button btn = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);

        btn8.setOnClickListener(v->{
            Intent intent =  new Intent(this, RecyclerView.class);
            startActivity(intent);
        });
        btn7.setOnClickListener(v->{
            Intent intent =  new Intent(this, FragmentActivity.class);
            startActivity(intent);
        });
        btn6.setOnClickListener(v->{
            Intent intent =  new Intent(this, Menus.class);
            startActivity(intent);
        });
        btn5.setOnClickListener(v->{
            Intent i = new Intent(this, InputControls.class);
            startActivity(i);
        });
        btn4.setOnClickListener(v -> {
            Intent i  = new Intent(this, IntentsLab.class);
            startActivity(i);
        });
        btn3.setOnClickListener(v -> {
            Intent i = new Intent(this, SplashScreen.class);
            startActivity(i);
        });
        btn2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(this, Program2.class);
                startActivity(intent);

            } catch (Exception e) {
                Log.d("TAG", "onCreate: " + e.getLocalizedMessage());
            }
        });
        btn.setOnClickListener(v -> {
            String name = et.getText().toString();
            if (name.equals("") || name.length() < 4) {
                Toast toast = new Toast(this);
                toast.setGravity(Gravity.TOP, 0, 30);
                TextView view = new TextView(this);
                view.setBackgroundColor(Color.GREEN);
                view.setTextColor(Color.RED);
                view.setText("Please enter a valid name.");
                view.setPadding(20, 20, 20, 20);
                toast.setView(view);
                toast.show();

            } else {
                tv.setText(et.getText());
            }
        });
    }
}