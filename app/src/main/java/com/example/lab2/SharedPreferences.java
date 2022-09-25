package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        EditText tts = findViewById(R.id.tts);
        Button save = findViewById(R.id.save);
        Button rs = findViewById(R.id.rs);


        save.setOnClickListener(v -> {
            if(tts.getText().toString().trim().length()==0){
                Toast.makeText(this, "Enter a valid data.", Toast.LENGTH_SHORT).show();
                return;
            }
            android.content.SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            android.content.SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("key", tts.getText().toString());
            myEdit.commit();
        });
        rs.setOnClickListener(v -> {
            android.content.SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            String s1 = sh.getString("key", "");
            if(s1.equals("")){
                Toast.makeText(this, "Please save first before retrieving.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "The saved data is - "+s1, Toast.LENGTH_SHORT).show();
            }

        });
    }
}