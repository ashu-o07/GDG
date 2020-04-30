package com.example.hppc.gdgassing;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class fourthactivity  extends AppCompatActivity {
    EditText li,fb,gh,res;
    Button next;
    ArrayList<String> profile =new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fouractivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("GDG");
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        li=(EditText) findViewById(R.id.editText);
        fb=(EditText) findViewById(R.id.editText2);
        gh=(EditText) findViewById(R.id.editText3);
        res=(EditText) findViewById(R.id.editText4);
        next=(Button)findViewById(R.id.button4);
        profile.add(li.getText().toString());
        profile.add(fb.getText().toString());
        profile.add(gh.getText().toString());
        profile.add(res.getText().toString());
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(fourthactivity.this,fifthactivity.class);
                i.putStringArrayListExtra("info",getIntent().getExtras().getStringArrayList("info"));
                i.putStringArrayListExtra("expert",getIntent().getExtras().getStringArrayList("expert"));
                i.putStringArrayListExtra("tech",getIntent().getExtras().getStringArrayList("tech"));
                i.putStringArrayListExtra("special",getIntent().getExtras().getStringArrayList("special"));
                i.putStringArrayListExtra("profile",profile);
                if(li.getText().toString().length()!=0 && fb.getText().toString().length()!=0 && res.getText().toString().length()!=0 && gh.getText().toString().length()!=0)
                startActivity(i);

            }
        });



    }
}
