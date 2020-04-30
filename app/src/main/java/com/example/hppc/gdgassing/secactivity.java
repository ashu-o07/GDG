package com.example.hppc.gdgassing;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    SharedPreferences mypref=null;
    dbh dbHelper=null;
    final ArrayList<String> info = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("GDG");
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        mypref=getSharedPreferences("MYPREF",MODE_PRIVATE);
        //create object of Database Helper class

        dbHelper = new dbh(this);
        nxt = (Button)findViewById(R.id.button2);
        em = (EditText)findViewById(R.id.email2);
        coll = (EditText)findViewById(R.id.college2);
        mob = (EditText)findViewById(R.id.mobile2);
        nm = (EditText)findViewById(R.id.name2);
        year = (Spinner)findViewById(R.id.year2);
        age=(SeekBar)findViewById(R.id.seekBar);
        m=(RadioButton)findViewById(R.id.male);
        f=(RadioButton)findViewById(R.id.female);



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
                if(name.length()!=0 && email.length()!=0 && college.length()!=0 && number.length()!=0 && yeaar.length()!=0 && gender.length()!=0 ){
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


                    boolean isInserted = dbHelper.insertFeedback(info);

                    if(isInserted){
                        Toast.makeText(getApplicationContext(),"Saved in database successfully!!!",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Erroc occured!!!",Toast.LENGTH_LONG).show();

                    }

                    SharedPreferences.Editor editor = mypref.edit();
                    editor.putString("name",name);
                    editor.putString("email",email);
                    editor.putString("college",college);
                    editor.putString("year",yeaar);
                    editor.putString("gender",gender);
                    editor.putString("age",aage+"");
                    editor.commit();
                i.putStringArrayListExtra("info",info);
                startActivity(i);}

            }
        });


    }
}
