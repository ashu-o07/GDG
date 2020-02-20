package com.example.hppc.gdgassing;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fifthactivity extends AppCompatActivity {
    adp f;
    RecyclerView rc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("GDG");
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        ArrayList<ArrayList<String>> arr =new ArrayList<ArrayList<String>>();
        ArrayList<String> info= getIntent().getExtras().getStringArrayList("info");
        ArrayList<String> i1= new ArrayList<String>();
        ArrayList<String> i2= new ArrayList<String>();
        arr.add(info);
        i1.add("ashish");i1.add("ashish@xyz.com");i1.add("IIIT Bhopal");i1.add("000000000");i1.add("2nd year");i1.add("Male");i1.add("20");
        arr.add(i1);
        i2.add("ashish");i2.add("ashish@xyz.com");i2.add("IIIT Bhopal");i2.add("000000000");i2.add("2nd year");i2.add("Male");i2.add("20");
        arr.add(i2);
        f = new adp(arr);
        rc = (RecyclerView)findViewById(R.id.recycle);
        rc.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rc.setAdapter(f);
        f.notifyDataSetChanged();

    }
}
