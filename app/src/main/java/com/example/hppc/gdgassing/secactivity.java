package com.example.hppc.gdgassing;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class secactivity extends AppCompatActivity {
    TextView em;
    TextView nm;
    TextView coll;

    TextView mob;
    Spinner year;
    RadioButton m,f;
    SeekBar age;
    Button nxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("GDG");
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        nxt = (Button)findViewById(R.id.button2);
        em = (EditText)findViewById(R.id.email2);
        coll = (EditText)findViewById(R.id.college2);
        mob = (EditText)findViewById(R.id.mobile2);
        nm = (EditText)findViewById(R.id.name2);
        year = (Spinner)findViewById(R.id.year2);
        age=(SeekBar)findViewById(R.id.seekBar);
        m=(RadioButton)findViewById(R.id.male);
        f=(RadioButton)findViewById(R.id.female);
       final ArrayList<String> info = new ArrayList<String>();

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nm.getText().toString();
                String email = em.getText().toString();
                String college = coll.getText().toString();
                String number =mob.getText().toString();
                String yeaar =year.getSelectedItem().toString();
                String gender=null;
                if(m.isChecked()){
                    gender="male";

                }
                else gender="female";
                int aage = age.getProgress();
                Intent i = new Intent(secactivity.this,thirdactivity.class);
                /*i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("college",college);
                i.putExtra("number",number);
                i.putExtra("year",yeaar);
                i.putExtra("gender",gender);
                i.putExtra("age",aage);startActivity(i);*/
                info.add(name);
                info.add(email);info.add(college);info.add(number);
                info.add(yeaar);info.add(gender);info.add(aage+"");
                i.putStringArrayListExtra("info",info);
                startActivity(i);

            }
        });


    }
}
