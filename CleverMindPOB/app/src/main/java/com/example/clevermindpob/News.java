package com.example.clevermindpob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapter.HomeRecyclerAdapter;
import Adapter.NewsRecyclerViewAdapter;
import Model.HomeRecyclerViewModel;
import Model.NewsRecyclerViewModel;

public class News extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<NewsRecyclerViewModel> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            listItems = new ArrayList<>();


            listItems.add(new NewsRecyclerViewModel(getResources().getString(R.string.google_news),R.drawable.google));
            listItems.add(new NewsRecyclerViewModel(getResources().getString(R.string.android_news),R.drawable.android  ));
            listItems.add(new NewsRecyclerViewModel(getResources().getString(R.string.ios_news),R.drawable.ioslogo));


            adapter = new NewsRecyclerViewAdapter(this, listItems);
            recyclerView.setAdapter(adapter);
        }
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String body="Download this App";
                String sub="https://play.google.com/";
                intent.putExtra(Intent.EXTRA_TEXT,body);
                intent.putExtra(Intent.EXTRA_TEXT,sub);
                startActivity(Intent.createChooser(intent,"Share using"));
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(News.this,Home.class);
                startActivity(intent);
            }
        });
    }
}