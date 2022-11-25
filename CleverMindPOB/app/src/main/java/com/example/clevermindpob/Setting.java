package com.example.clevermindpob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.Locale;

public class Setting extends AppCompatActivity {
    static boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocal();
        setContentView(R.layout.activity_setting);


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Setting.this,Home.class);
                startActivity(intent);
            }
        });
    }
    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
         boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.english: {// Check which radio button was clicked
                if (checked) {
                    setLocal("en");
                    recreate();
                }
            }
              break;
        case R.id.arabic: {
            if (checked) {
                setLocal("ar");
                recreate();
                flag=true;
            }
        }
            break;
        // }

    }
}

    private void setLocal(String lang) {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);

        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }
    public void loadLocal()
    {
        SharedPreferences preferences=getSharedPreferences("Settings",MODE_PRIVATE);
        String language=preferences.getString("My_lang","");
        setLocal(language);

    }

    }
