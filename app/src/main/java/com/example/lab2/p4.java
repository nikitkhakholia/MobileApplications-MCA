package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class p4 extends AppCompatActivity {

    //overriding onCreate Life Cycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4);
        Button button = findViewById(R.id.btn_close);
        button.setOnClickListener(v -> {
            finish();
        });
        Toast.makeText(this, "From function: onCreate", Toast.LENGTH_LONG).show();

        //Sending debug log
        Log.d("Test100","Message: Application Started");
        Log.i("LifeCycle", "onCreate");
        try {

            //Sending warning log
            Log.w("Test100", "Divide by 0 exception");
            int x = 1/0;
        }catch (Exception e){

            //Sending error log
            Log.e("Test100", e.getLocalizedMessage());

            //Sending What a terrible failure
            Log.wtf("Test100", "Uncaught Exception");
        }
    }

    //overriding onStart Life Cycle Methods
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "From function: onStart", Toast.LENGTH_LONG).show();
        Log.i("LifeCycle", "onStart");

        //Sending info log
        Log.i("Test100", "App started");
    }

    //overriding onRestart Life Cycle Methods
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "From function: onRestart", Toast.LENGTH_LONG).show();
        Log.i("LifeCycle", "onRestart");

        //Sending verbose log
        Log.v("Test100", "App restarted");
    }

    //overriding onResume Life Cycle Methods
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "From function: onResume", Toast.LENGTH_LONG).show();
        Log.i("LifeCycle", "onResume");

        //println with Log
        Log.println(Log.INFO,"Test103","This is println from Log class.");
    }

    //overriding onPause Life Cycle Methods
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "From function: onPause", Toast.LENGTH_LONG).show();
        Log.i("LifeCycle", "onPause");
    }

    //overriding onStop Life Cycle Methods
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "From function: onStop", Toast.LENGTH_LONG).show();
        Log.i("LifeCycle", "onStop");
    }

    //overriding onDestroy Life Cycle Methods
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "From function: onDestroy", Toast.LENGTH_LONG).show();
        Log.i("LifeCycle", "onDestroy");
    }
}