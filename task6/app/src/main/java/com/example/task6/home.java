package com.example.task6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
public class home extends AppCompatActivity {
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        findViewById(R.id.burger).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, burgerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.chicken).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(home.this, snacks.class);
                startActivity(intent1);
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

    public boolean  checkItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            Intent intent1=new Intent(home.this,profile.class);
            startActivity(intent1);
            break;
            case R.id.burger:
                Toast.makeText(this, "Burgers", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(home.this,burgerActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.snacks:
                Toast.makeText(this, "Snacks", Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(home.this,snacks.class);
                startActivity(intent3);
                finish();

                break;
            case R.id.order:
                Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
                Intent intent4=new Intent(home.this,order.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.location:
                Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show();
                Intent intent5=new Intent(home.this,location.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.log_out:
                Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
                Intent intent6=new Intent(home.this,MainActivity.class);
                startActivity(intent6);
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.END);
        return true;
    }


}