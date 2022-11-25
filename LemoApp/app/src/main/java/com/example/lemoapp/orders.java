package com.example.lemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapters.FruitsRecyclerViewAdapter;
import Adapters.OrderAdapter;
import Models.FruitsRecyclerViewModel;

public class orders extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<FruitsRecyclerViewModel> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));

            listItems = new ArrayList<>();


            listItems.add(new FruitsRecyclerViewModel(R.drawable.fruits,"ID:1205","30"));
            listItems.add(new FruitsRecyclerViewModel(R.drawable.fruits,"ID:1206","15"));
            listItems.add(new FruitsRecyclerViewModel(R.drawable.fruits,"ID:1207","20"));
            listItems.add(new FruitsRecyclerViewModel(R.drawable.fruits,"ID:1208","30"));


            adapter = new OrderAdapter(this,listItems);
            recyclerView.setAdapter(adapter);


        }

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(orders.this,basket.class);
                startActivity(intent);
            }
        });
    }
}