package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CopyClearSection extends AppCompatActivity {
EditText editText;
Button clearBtn,copyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_clear_section);

        editText=findViewById(R.id.et_input);
        clearBtn=findViewById(R.id.btn_clear);
        copyBtn=findViewById(R.id.btn_copy);


        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value= editText.getText().toString();

                if(value.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Insert Data!!!",Toast.LENGTH_SHORT).show();
                }else{
                    ClipboardManager clipboardManager= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData=ClipData.newPlainText("Data",value);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(),"Copied to clipboard",Toast.LENGTH_SHORT).show();
                }
            }
        });


        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value= editText.getText().toString();

                if(value.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Already Empty!!!",Toast.LENGTH_SHORT).show();
                }else{
                    editText.setText("");

                }
            }
        });
    }
}