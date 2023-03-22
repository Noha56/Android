package com.example.task11;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
      TextInputEditText editTextEmail,editTextPassword;
      Button btnLogin;
      FirebaseAuth mAuth;
      ProgressBar progressBar;
      TextView registerNow;
      FirebaseUser user;

      @Override
      public void onStart() {

          super.onStart();
           user=mAuth.getCurrentUser();
          if(user!=null){
              Intent intent=new Intent(getApplicationContext(),MainActivity.class);
              startActivity(intent);
              finish();
          }
      }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);

        mAuth=FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.progressBar);
        registerNow=findViewById(R.id.registerNow);
        registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        progressBar.setVisibility(View.VISIBLE);
                        String email,password;
                        email=editTextEmail.getText().toString();
                        password=editTextPassword.getText().toString();
                        progressBar.setVisibility(View.GONE);
                        if(TextUtils.isEmpty(email)){
                            Toast.makeText(Login.this,"Email is required!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(TextUtils.isEmpty(password)){
                            Toast.makeText(Login.this, "Password is required!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if(task.isSuccessful()){
                                    Toast.makeText(Login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                }else{
                                    Toast.makeText(Login.this, "Failed!", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                }
        );

    }

}