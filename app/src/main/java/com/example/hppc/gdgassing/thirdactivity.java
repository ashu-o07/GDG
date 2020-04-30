package com.example.hppc.gdgassing;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class thirdactivity extends AppCompatActivity {
    int x=0,y=0,z=0;
    CheckBox design,mark,writ,prog,manage;
    CheckBox py,js,react,ang,html;
    CheckBox wd,ad,sd,cc,ds;
    Button next;
    ArrayList<String> expert =new ArrayList<String>();
    ArrayList<String> tech= new ArrayList<String>();
    ArrayList<String> special= new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("GDG");
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        design=(CheckBox)findViewById(R.id.des);
        mark=(CheckBox)findViewById(R.id.mar);
        writ=(CheckBox)findViewById(R.id.wri);
        prog=(CheckBox)findViewById(R.id.pro);
        manage=(CheckBox)findViewById(R.id.man);
        py=(CheckBox)findViewById(R.id.py);
        js=(CheckBox)findViewById(R.id.js);
        react=(CheckBox)findViewById(R.id.react);
        ang=(CheckBox)findViewById(R.id.ang);
        html=(CheckBox)findViewById(R.id.html);
        wd=(CheckBox)findViewById(R.id.wdev);
        ad=(CheckBox)findViewById(R.id.adev);
        sd=(CheckBox)findViewById(R.id.sdev);
        cc=(CheckBox)findViewById(R.id.ccm);
        ds=(CheckBox)findViewById(R.id.ds);
        next=(Button)findViewById(R.id.button3);

        if(design.isChecked()) {expert.add("Designing");this.x++;}
        if(mark.isChecked()) {expert.add("Marketing");this.x++;}
        if(writ.isChecked()) {expert.add("writing");this.x++;}
        if(prog.isChecked()) {expert.add("Programming");this.x++;}
        if(manage.isChecked()) {expert.add("Management");this.x++;}
        if(py.isChecked()) {tech.add("Python");this.y++;}
        if(js.isChecked()) {tech.add("JavaScript");this.y++;}
        if(react.isChecked()) {tech.add("React");this.y++;}
        if(ang.isChecked()) {tech.add("Angular");this.y++;}
        if(html.isChecked()) {tech.add("HTML and CSS");this.y++;}
        if(wd.isChecked()) {special.add("Web Development");this.z++;}
        if(ad.isChecked()) {special.add("App Developmane");this.z++;}
        if(sd.isChecked()) {special.add("Software Developmane");this.z++;}
        if(cc.isChecked()) {special.add("Cloud Computing");this.z++;}
        if(ds.isChecked()) {special.add("Data science");this.z++;
            }
        next.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent i = new Intent(thirdactivity.this,fourthactivity.class);
                i.putStringArrayListExtra("info",getIntent().getExtras().getStringArrayList("info"));
                i.putStringArrayListExtra("expert",expert);
                i.putStringArrayListExtra("tech",tech);
                i.putStringArrayListExtra("special",special);
               System.out.println(z+ x+  y);

                startActivity(i);
            }
        });



    }
}
