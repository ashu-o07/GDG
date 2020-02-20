package com.example.hppc.gdgassing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adp extends RecyclerView.Adapter<adp.FeedBackViewHolder> {
    ArrayList<ArrayList<String>> arr =new ArrayList<ArrayList<String>>();
    Context context;
    public adp(ArrayList<ArrayList<String>> ar){
        arr=ar;
        ArrayList<String> g= new ArrayList<String>();
        g.add("ashish");g.add("ashish@xyz.com");g.add("IIIT Bhopal");g.add("000000000");g.add("2nd year");g.add("Male");g.add("20");
        arr.add(g);


    }
    class FeedBackViewHolder extends  RecyclerView.ViewHolder{

        TextView name,email,collg,year,age,gender;
        public FeedBackViewHolder( View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.n);
            email=(TextView)itemView.findViewById(R.id.e);
            collg=(TextView)itemView.findViewById(R.id.c);
            year=(TextView)itemView.findViewById(R.id.y);
            age=(TextView)itemView.findViewById(R.id.a);
            gender=(TextView)itemView.findViewById(R.id.g);


        }
    }

    @NonNull
    @Override
    public FeedBackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new FeedBackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedBackViewHolder holder, int position) {
        ArrayList<String> print=arr.get(position);
        holder.gender.setText(print.get(5));
        holder.year.setText(print.get(4));
        holder.collg.setText(print.get(2));
        holder.name.setText(print.get(0));
        holder.email.setText(print.get(1));
        holder.age.setText(print.get(6));

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }



}
