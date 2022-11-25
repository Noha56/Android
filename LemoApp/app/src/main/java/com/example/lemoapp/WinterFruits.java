package com.example.lemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Adapters.FruitsRecyclerViewAdapter;
import Models.FruitsRecyclerViewModel;

public class WinterFruits extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<FruitsRecyclerViewModel> listItems;

    //menu
    private DrawerLayout drawer;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter_fruits);

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));

            listItems = new ArrayList<>();


            listItems.add(new FruitsRecyclerViewModel(R.drawable.strawberry,"STRAWBERRY","3"));
            listItems.add(new FruitsRecyclerViewModel(R.drawable.bananas,"BANANAS","1.5"));
            listItems.add(new FruitsRecyclerViewModel(R.drawable.apple,"APPLE","2"));
            listItems.add(new FruitsRecyclerViewModel(R.drawable.orange,"ORANGE","3"));


            adapter = new FruitsRecyclerViewAdapter(this,listItems);
            recyclerView.setAdapter(adapter);
        }

        //menu
        {
            drawer = findViewById(R.id.drawer);
            findViewById(R.id.menu_icon).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawer.openDrawer(GravityCompat.END);
                }
            });

            navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    checkItemSelected(item);

                    return false;
                }
            });


        }

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WinterFruits.this,Home.class);
                startActivity(intent);
            }
        });
    }
    public boolean checkItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.account:
                Toast.makeText(this,"Account", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Account.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.basket:
                Toast.makeText(this,"Basket", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, basket.class);
                startActivity(intent3);
                finish();

                break;
            case R.id.orders:
                Toast.makeText(this,"Orders", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, orders.class);
                startActivity(intent4);
                finish();
                break;

            case R.id.logout:
                Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, logInActivity.class);
                startActivity(intent1);
                finish();
                break;

        }

        drawer.closeDrawer(GravityCompat.END);

        return true;
    }
}