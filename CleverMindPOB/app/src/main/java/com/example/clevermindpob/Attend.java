package com.example.clevermindpob;

import static com.example.clevermindpob.Setting.flag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.AttendRecyclerViewAdapter;
import Adapter.HomeRecyclerAdapter;
import Model.HomeRecyclerViewModel;

public class Attend extends AppCompatActivity {
    //recycler view
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HomeRecyclerViewModel> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend);

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            listItems = new ArrayList<>();


            listItems.add(new HomeRecyclerViewModel(getResources().getString(R.string.ANDROID), getResources().getString(R.string.SUNTHU), getResources().getString(R.string.time101), getResources().getString(R.string.ATTENDNOW), R.drawable.android, R.drawable.cancel));
            listItems.add(new HomeRecyclerViewModel(getResources().getString(R.string.ios), getResources().getString(R.string.SATTUS), getResources().getString(R.string.time112), getResources().getString(R.string.ATTENDNOW), R.drawable.ioslogo, R.drawable.cancel));
            listItems.add(new HomeRecyclerViewModel(getResources().getString(R.string.qa), getResources().getString(R.string.MONTHU), getResources().getString(R.string.time91), getResources().getString(R.string.ATTENDNOW), R.drawable.qa, R.drawable.cancel));



            adapter = new AttendRecyclerViewAdapter(this, listItems);
            recyclerView.setAdapter(adapter);
        }

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Attend.this,Home.class);
                startActivity(intent);
            }
        });

        TextView desc=findViewById(R.id.desc);
        String text=getResources().getString(R.string.attend_title);
        //ATTENDED (COURSES) AND (TRAINING SESSION)
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(getResources().getColor(R.color.dark_blue));
        ForegroundColorSpan fcsBlue2 = new ForegroundColorSpan(getResources().getColor(R.color.dark_blue));

        if(!flag) {
            ss.setSpan(fcsBlue, 9, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(fcsBlue2, 21, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        desc.setText(ss);

    }
}