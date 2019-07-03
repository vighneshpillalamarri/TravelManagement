package com.example.travelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
    protected void onClick(View view)
    {
        CustomDialogClass cdd=new CustomDialogClass(this);
        cdd.show();
    }
}

