package com.example.lab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyView> {
    List<String> productNames;
    public RecyclerAdapter(List<String> data){
        this.productNames = data;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.rec_card, parent, false);

        return new MyView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        String x = productNames.get(position);
        holder.textView.setText(x);
        System.out.println(x);
    }

    @Override
    public int getItemCount() {
        return productNames.size();
    }

    public class MyView extends RecyclerView.ViewHolder{

        TextView textView;
        public MyView(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rec_text);
        }
    }
}
