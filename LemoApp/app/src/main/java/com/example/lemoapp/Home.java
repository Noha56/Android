package com.example.lemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Adapters.HomeRecyclerViewAdapter;
import Adapters.HomeViewPagerAdapter;
import Models.HomeRecyclerViewModel;
import Models.HomeViewPagerModel;

public class Home extends AppCompatActivity {
    private ViewPager viewPager;
    private HomeViewPagerAdapter viewPagerAdapter;
    private List<HomeViewPagerModel> models;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HomeRecyclerViewModel> listItems;

    //menu
    private DrawerLayout drawer;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //view pager
        {
            models = new ArrayList<>();
            models.add(new HomeViewPagerModel("SUMMER FRUITS",R.drawable.watermelon));
            models.add(new HomeViewPagerModel("NEW FRUITS",R.drawable.strawberry));
            models.add(new HomeViewPagerModel("WINTER FRUITS",R.drawable.orange));
            models.add(new HomeViewPagerModel("GREEN FRUITS",R.drawable.avocado));

            viewPager = findViewById(R.id.viewPager);
            viewPager.setAdapter(new HomeViewPagerAdapter(this,models));
            //if (!models.get(3).getTitle().equals("GREEN FRUITS"))
                viewPager.setPadding(0, 0, 350, 0);
                

        }

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));

            listItems = new ArrayList<>();


            listItems.add(new HomeRecyclerViewModel("SUMMER FRUITS"));
            listItems.add(new HomeRecyclerViewModel("NEW FRUITS"));
            listItems.add(new HomeRecyclerViewModel("WINTER FRUITS"));
            listItems.add(new HomeRecyclerViewModel("GREEN FRUITS"));

            adapter = new HomeRecyclerViewAdapter(this,listItems);
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
                Toast.makeText(Home.this, "Log out", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, logInActivity.class);
                startActivity(intent1);
                finish();
                break;

        }

        drawer.closeDrawer(GravityCompat.END);

        return true;
    }
}