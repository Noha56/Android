package com.example.task11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    TextInputEditText editTextEmail,editTextPassword;
    Button btnReg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView loginNow;
    @Override
    public void onStart() {

        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();
        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);
        btnReg=findViewById(R.id.btn_register);
        progressBar=findViewById(R.id.progressBar);
        loginNow=findViewById(R.id.haveAccount);
        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email=String.valueOf(editTextEmail.getText());
                password=String.valueOf(editTextPassword.getText());
                progressBar.setVisibility(View.GONE);
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this,"Email is required!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Password is required!", Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this,"createUserWithEmail:success",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Register.this,"Authentication failed.",Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }
}