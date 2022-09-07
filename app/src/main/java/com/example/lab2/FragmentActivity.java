package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab2.Fragment.Fragment1;
import com.example.lab2.Fragment.Fragment2;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Button btnVB = findViewById(R.id.btn_vb);
        Button btnVS = findViewById(R.id.btn_vs);

        btnVS.setOnClickListener(v -> {
            Fragment1 fragment1 = new Fragment1();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.productFrame, fragment1);
            fragmentTransaction.addToBackStack("VB");
            fragmentTransaction.commit();
        });

        btnVB.setOnClickListener(v -> {
            Fragment2 fragment2 = new Fragment2();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.productFrame, fragment2);
            fragmentTransaction.addToBackStack("VS");
            fragmentTransaction.commit();
        });

    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        for(int i = 0; i < count; ++i) {
            fm.popBackStackImmediate();
        }
        super.onBackPressed();
    }
}