package com.example.task6;

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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class burgerActivity extends AppCompatActivity {
    private ImageView imgBack;
    private DrawerLayout drawer;
    int [] background={R.drawable.item_orange,R.drawable.item_yellow,R.drawable.item_green,R.drawable.item_orange};
    String [] items_names ={"Cheese\nBurger\n5JD","Beef\nBurger\n6JD","Mash\nBurger\n3JD","Ber\nBurger\n4JD"} ;
    String [] meals={"Meal\n6JD","Meal\n7JD","Meal\n4JD","Meal\n6JD"};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        recyclerView=findViewById(R.id.recyclerView);
        snackAdapter snackAdapter=new snackAdapter(this,items_names,meals,background);
        recyclerView.setAdapter(snackAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        imgBack=findViewById(R.id.back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(burgerActivity.this, home.class);
                startActivity(intent);
            }
        });

        drawer = findViewById(R.id.drawer);
        findViewById(R.id.menu_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.END);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                checkItemSelected(item);
                return false;
            }
        });

    }
    public boolean checkItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(burgerActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(burgerActivity.this, profile.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.burger:
                Toast.makeText(this, "Burgers", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(burgerActivity.this, burgerActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.snacks:
                Toast.makeText(this, "Snacks", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(burgerActivity.this, snacks.class);
                startActivity(intent3);
                finish();

                break;
            case R.id.order:
                Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(burgerActivity.this, order.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.location:
                Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(burgerActivity.this, location.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.log_out:
                Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(burgerActivity.this, MainActivity.class);
                startActivity(intent6);
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}