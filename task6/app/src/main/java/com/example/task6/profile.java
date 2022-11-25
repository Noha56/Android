package com.example.task6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Locale;

public class profile extends AppCompatActivity {
    private ImageView imgBack;
    private DrawerLayout drawer;
    private TextView loc;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imgBack=findViewById(R.id.back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, home.class);
                startActivity(intent);
            }
        });

        loc=findViewById(R.id.location);
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check permission
                if(ActivityCompat.checkSelfPermission(profile.this
                , Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
                {
                    //When permission granted
                    getLocation();
                }else{
                    //when permission denied
                    ActivityCompat.requestPermissions(profile.this,
                            new String[] {Manifest.permission.ACCESS_FINE_LOCATION},44);
                }
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
                Toast.makeText(profile.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(profile.this, profile.class);
                startActivity(intent1);
                break;
            case R.id.burger:
                Toast.makeText(this, "Burgers", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(profile.this, burgerActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.snacks:
                Toast.makeText(this, "Snacks", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(profile.this, snacks.class);
                startActivity(intent3);
                finish();

                break;
            case R.id.order:
                Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(profile.this, order.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.location:
                Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(profile.this, location.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.log_out:
                Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(profile.this, MainActivity.class);
                startActivity(intent6);
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
    private void getLocation(){

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(profile.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();

                if(location!= null)
                {
                    try {
                        Geocoder geocoder = new Geocoder(profile.this, Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        loc.setText(""+addresses.get(0).getCountryName()+ " , "+addresses.get(0).getLocality());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
    }
}