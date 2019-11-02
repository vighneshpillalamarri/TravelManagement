package com.example.travelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void show(View view)
    {
        final EditText email,pwd,rpwd;
        Button reg=findViewById(R.id.register);
        email=findViewById(R.id.Email);
        pwd=findViewById(R.id.password);
        rpwd=findViewById(R.id.re_enterPassword);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e,pw,rpw;
                e=email.getText().toString();
                pw=pwd.getText().toString();
                rpw=rpwd.getText().toString();
                if (e.isEmpty()) {
                    email.setError("Provide your Email first!");
                    email.requestFocus();
                } else if (pw.isEmpty()) {
                    pwd.setError("Enter Password!");
                    pwd.requestFocus();
                } else if(rpw.isEmpty()){
                    rpwd.setError("Re-enter Password");
                    rpwd.requestFocus();
                }
                else if (e.isEmpty() && pw.isEmpty()) {
                    Toast.makeText(Registration.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!rpw.equals(pw)) {
                    Toast.makeText(Registration.this, "Passwords are not matching!", Toast.LENGTH_SHORT).show();
                }else if(!e.isEmpty()&&!pw.isEmpty()&&rpw.equals(pw)){
                    firebaseAuth.createUserWithEmailAndPassword(e,pw).addOnCompleteListener(Registration.this, new OnCompleteListener <AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(Registration.this.getApplicationContext(),
                                        "SignUp unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Registration.this, Login.class));
                            }
                        }
                    });
                }
            }
        });
    }
}

