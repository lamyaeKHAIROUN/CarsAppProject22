package com.example.carsappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    private EditText emailReset;
    private Button btnReset;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        emailReset=findViewById(R.id.inputEmailReset);
        btnReset=findViewById(R.id.btnReset);
        progressBar=findViewById(R.id.progressBarReset);
        progressBar.setVisibility(View.INVISIBLE);
        mAuth = FirebaseAuth.getInstance();
        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetPassword();
            }


        });

    }

    private void resetPassword() {

        String smail=emailReset.getText().toString().trim();
        if(smail.isEmpty()){
            emailReset.setError("Email is required!");
            emailReset.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(smail).matches()){
            emailReset.setError("Please provide a valid email");
            emailReset.requestFocus();
            return;
        }

        mAuth.sendPasswordResetEmail(smail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ResetPassword.this,"Check your email to reset password!",Toast.LENGTH_SHORT).show();

                }

                else Toast.makeText(ResetPassword.this,"Failed to reset password! Try again!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}