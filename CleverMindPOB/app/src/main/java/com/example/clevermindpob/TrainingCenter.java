package com.example.clevermindpob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import Adapter.EventRecyclerViewAdapter;
import Adapter.TrainingRecyclerViewAdapter;
import Model.EventRecyclerViewModel;
import Model.TrainingCenterModel;

public class TrainingCenter extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<TrainingCenterModel> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_center);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TrainingCenter.this,Home.class);
                startActivity(intent);
            }
        });





        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            listItems = new ArrayList<>();


            listItems.add(new TrainingCenterModel(getResources().getString(R.string.ANDROID),
                    getResources().getString(R.string.SUNTHU), getResources().getString(R.string.time101)
                    , getResources().getString(R.string.android_course_info),
                    getResources().getString(R.string.price_android),
                    R.drawable.android
                    ));

            listItems.add(new TrainingCenterModel(getResources().getString(R.string.ios),
                    getResources().getString(R.string.SUNTHU), getResources().getString(R.string.time101)
                    , getResources().getString(R.string.ios_course_info),
                    getResources().getString(R.string.price_android),
                    R.drawable.ioslogo
            ));

            listItems.add(new TrainingCenterModel(getResources().getString(R.string.qa),
                    getResources().getString(R.string.SUNTHU), getResources().getString(R.string.time101)
                    , getResources().getString(R.string.qa_course_info),
                    getResources().getString(R.string.price_android),
                    R.drawable.qa
            ));


           // adapter = new TrainingRecyclerViewAdapter(this,listItems);
            //recyclerView.setAdapter(adapter);

            recyclerView.setAdapter(new TrainingRecyclerViewAdapter(this,listItems));



        }
    }

}