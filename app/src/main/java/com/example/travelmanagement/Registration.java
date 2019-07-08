package com.example.travelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void show(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Registration Successfull");
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"OK Button selected "+which,Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}

