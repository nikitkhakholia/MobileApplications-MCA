package com.example.lab2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputControls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_controls);


//        FloatingActionButton
        FloatingActionButton homeBtn = findViewById(R.id.fab_home);
        homeBtn.setOnClickListener(v -> {
//            Snackbar
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Going to home", Snackbar.LENGTH_INDEFINITE)
//                    .setAction("Action", null)
                    .show();
            finish();
        });

//        RatingBar
        RatingBar ratingBar = findViewById(R.id.rating);
        ratingBar.setRating(5);
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
            Snackbar.make(findViewById(R.id.inputcontrols), "Rated " + rating + " starts.", Snackbar.LENGTH_LONG)
                    .show();
        });

//        ToggleButton
        ToggleButton togBtn = findViewById(R.id.tog_btn);
        LinearLayout linearLayout = findViewById(R.id.form);
        togBtn.setOnClickListener(v -> {
            if(togBtn.isChecked()){
                linearLayout.setVisibility(View.VISIBLE);
            }else{
                linearLayout.setVisibility(View.GONE);
            }
        });
//        CheckBox
        CheckBox osChk = findViewById(R.id.chk_os);
        CheckBox smChk = findViewById(R.id.chk_sm);
        CheckBox dsChk = findViewById(R.id.chk_dm);
        CheckBox rsChk = findViewById(R.id.chk_rs);


//        RadioGroup/RadioButton
        RadioGroup timeUsed = findViewById(R.id.time_rg);

//        Spinner
        Spinner productSpinner = findViewById(R.id.product_spinner);
        List<String> products = new ArrayList<>();
        products.add("Bikaneri Bhujia");
        products.add("Tana Tan Aloo Bhujia");
        products.add("Sidha Sadha Bhujia");
        products.add("Boondi Bhujia");
        products.add("Makhan Malai Bhujia");
        products.add("Special Marwari Bhujia");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, products);
        dataAdapter.setDropDownViewResource(R.layout.custom_spinner);
        productSpinner.setAdapter(dataAdapter);

//        Switch
        Switch aSwitch = findViewById(R.id.confirm);
        aSwitch.setChecked(true);
        Button button = findViewById(R.id.submit);
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                button.setVisibility(View.VISIBLE);
            }else{
                button.setVisibility(View.GONE);
            }
        });
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, BrandWebpage.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
//        AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes",
                new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        finish();
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}