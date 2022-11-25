package com.example.task6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class confirm extends AppCompatActivity {
    private DrawerLayout drawer;
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        imgBack=findViewById(R.id.back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirm.this, home.class);
                startActivity(intent);
            }
        });

        drawer=findViewById(R.id.drawer);
        findViewById(R.id.menu_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.END);
            }
        });


        NavigationView navigationView=findViewById(R.id.nav_view);
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
                Toast.makeText(confirm.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(confirm.this,profile.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.burger:
                Toast.makeText(this, "Burgers", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(confirm.this,burgerActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.snacks:
                Toast.makeText(this, "Snacks", Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(confirm.this,snacks.class);
                startActivity(intent3);
                finish();

                break;
            case R.id.order:
                Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
                Intent intent4=new Intent(confirm.this,order.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.location:
                Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show();
                Intent intent5=new Intent(confirm.this,location.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.log_out:
                Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
                Intent intent6=new Intent(confirm.this,MainActivity.class);
                startActivity(intent6);
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}