package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BrandWebpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_webpage);

        //        WebView
        WebView view = findViewById(R.id.feedback_wv);
        WebSettings webSettings = view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        view.loadUrl("https://www.bikaji.com");
    }
}