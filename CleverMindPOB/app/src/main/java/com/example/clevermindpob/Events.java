package com.example.clevermindpob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapter.EventRecyclerViewAdapter;
import Adapter.EventViewPagerAdapter;
import Adapter.HomeRecyclerAdapter;
import Adapter.HomeViewPagerAdapter;
import Model.EventRecyclerViewModel;
import Model.EventViewPagerModel;
import Model.HomeRecyclerViewModel;
import Model.HomeViewPagerModel;

public class Events extends AppCompatActivity {
    private ViewPager viewPager;
    private EventViewPagerAdapter viewPagerAdapter;
    private List<EventViewPagerModel> models;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<EventRecyclerViewModel> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        //viewpager
        {
            viewPager = findViewById(R.id.viewPager);

            models = new ArrayList<>();
            models.add(new EventViewPagerModel(getResources().getString(R.string.sunday),
                    getResources().getString(R.string.date_23_1),
                    getResources().getString(R.string.time_11_2)));
            models.add(new EventViewPagerModel(getResources().getString(R.string.sunday),
                    getResources().getString(R.string.date_23_1),
                    getResources().getString(R.string.time_11_2)));
            models.add(new EventViewPagerModel(getResources().getString(R.string.sunday),
                    getResources().getString(R.string.date_23_1),
                    getResources().getString(R.string.time_11_2)));


            viewPagerAdapter = new EventViewPagerAdapter(this, models);
            viewPager = findViewById(R.id.viewPager);
            viewPager.setAdapter(viewPagerAdapter);
            viewPager.setPadding(180, 0, 180, 0);

            viewPager.setCurrentItem(0);
        }

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            listItems = new ArrayList<>();


            listItems.add(new EventRecyclerViewModel(getResources().getString(R.string.education)));
            listItems.add(new EventRecyclerViewModel(getResources().getString(R.string.happy)));
            listItems.add(new EventRecyclerViewModel(getResources().getString(R.string.qa_session)));

            adapter = new EventRecyclerViewAdapter(this,listItems);
            recyclerView.setAdapter(adapter);
        }
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Events.this,Home.class);
                startActivity(intent);
            }
        });


    }
}