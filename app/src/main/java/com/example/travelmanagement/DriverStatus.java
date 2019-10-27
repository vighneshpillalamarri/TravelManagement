package com.example.travelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cardiomood.android.controls.gauge.SpeedometerGauge;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DriverStatus extends AppCompatActivity {
    private SpeedometerGauge speedometer;
    private TextView name,phone,exp;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_status);
        name=findViewById(R.id.textView5);
        phone=findViewById(R.id.textView7);
        exp=findViewById(R.id.textView9);
        // Customize SpeedometerGauge
        speedometer = (SpeedometerGauge) findViewById(R.id.speedometer);
        speedometer.setMaxSpeed(1000);
        speedometer.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                //66hhn 5progress=100;
                return String.valueOf((int) Math.round(progress));
            }
        });
        //speedometer.setMaxSpeed(50);
        speedometer.getLabelConverter().getLabelFor(100,1000);
        speedometer.setMajorTickStep(100);
        speedometer.setMinorTicks(20);
        speedometer.addColoredRange(0, 200, Color.GRAY);
        speedometer.addColoredRange(200, 450, Color.GREEN);
        speedometer.addColoredRange(450, 1000, Color.RED);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //Reference string will be the root node and the username. Under this
        //all the devices and password and other information will be stored.
        databaseReference = firebaseDatabase.getReference("driverDetails");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Driver d=dataSnapshot.getValue(Driver.class);
                name.setText(d.getName());
                phone.setText(Long.toString(d.getPhoneNo()));
                exp.setText(Long.toString (d.getExperience()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference = firebaseDatabase.getReference("driverDetails/alcohol");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long s=(long)dataSnapshot.getValue();
                speedometer.setSpeed(s, 1000, 300);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
            }
        });
    }
}
