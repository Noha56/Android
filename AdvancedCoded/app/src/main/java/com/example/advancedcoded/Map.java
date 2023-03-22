package com.example.advancedcoded;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.navigation.NavigationView;


public class Map extends AppCompatActivity implements OnMapReadyCallback{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation);
        menuIcon=findViewById(R.id.menu_icon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                checkItemSelected(item);
                return false;
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
    public  boolean checkItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.map:
                i=new Intent(getApplicationContext(),Map.class);
                startActivity(i);
                finish();
                break;
            case R.id.multiVideos:
                i=new Intent(getApplicationContext(),MultiVideoActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.swipePage:
                i=new Intent(getApplicationContext(),SwipeableVideosActivity.class);
                startActivity(i);
                finish();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}