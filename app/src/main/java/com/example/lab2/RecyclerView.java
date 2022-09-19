package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class RecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        androidx.recyclerview.widget.RecyclerView view = findViewById(R.id.rec_view);

        List<String> stringList = Arrays.asList("Punjabi Tadka", "Jhal Muri", "Tana Tan Aloo Bhujia", "Soya Sticks", "Bikenari bhujia", "atta Ladoo", "Kaju Katli");
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(stringList);
        view.setLayoutManager(new LinearLayoutManager(this));

        view.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }
}