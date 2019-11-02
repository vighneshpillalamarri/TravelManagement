package com.example.travelmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void a(View view)
    {
        Intent i=new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }
    public void b(View view)
    {
        Intent i=new Intent(getApplicationContext(), Registration.class);
        startActivity(i);
    }

}
