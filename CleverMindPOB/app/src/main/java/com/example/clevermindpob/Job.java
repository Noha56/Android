package com.example.clevermindpob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapter.JobRecyclerViewAdapter;
import Adapter.NewsRecyclerViewAdapter;
import Model.JobRecyclerViewModel;
import Model.NewsRecyclerViewModel;

public class Job extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<JobRecyclerViewModel> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            listItems = new ArrayList<>();


            listItems.add(new JobRecyclerViewModel(getResources().getString(R.string.android_dev),getResources().getString(R.string.years_exp_2),R.drawable.android));
            listItems.add(new JobRecyclerViewModel(getResources().getString(R.string.android_trainee),getResources().getString(R.string.knowledge),R.drawable.android2));
            listItems.add(new JobRecyclerViewModel(getResources().getString(R.string.ios_dev),getResources().getString(R.string.years_exp_4),R.drawable.ioslogo));
            listItems.add(new JobRecyclerViewModel(getResources().getString(R.string.social_media),getResources().getString(R.string.years_exp_2),R.drawable.facebook));

            adapter = new JobRecyclerViewAdapter(this, listItems);
            recyclerView.setAdapter(adapter);
        }
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Job.this,Home.class);
                startActivity(intent);
            }
        });
    }
}