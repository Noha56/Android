package com.example.lemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class logInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in2);

         findViewById(R.id.forget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });
         findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(logInActivity.this,Home.class);
                 startActivity(i);
             }
         });
         findViewById(R.id.signUp).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(logInActivity.this,SignUp.class);
                 startActivity(i);
             }
         });

    }
    private void openDialog() {
        DialogClass dialog=new DialogClass();
        dialog.show(getSupportFragmentManager(),"");}

}