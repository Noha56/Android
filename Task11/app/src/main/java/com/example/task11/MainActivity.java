package com.example.task11;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

private DrawerLayout drawerLayout;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth= FirebaseAuth.getInstance();

        user=auth.getCurrentUser();


        drawerLayout=findViewById(R.id.drawer_layout);
        findViewById(R.id.menu_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
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
        updateNavHeader();
    }
    public void updateNavHeader(){
        NavigationView navigationView=findViewById(R.id.nav_view);
        View headerView=navigationView.getHeaderView(0);
        TextView email=headerView.findViewById(R.id.user_details);

        email.setText(user.getEmail());
    }

    public boolean checkItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.nav_home:
                i=new Intent(getApplicationContext(),Home.class);
                startActivity(i);
                finish();
                break;
            case R.id.nav_calculator:
                i=new Intent(getApplicationContext(),Calculator.class);
                startActivity(i);
                finish();
                break;
            case R.id.nav_video:
                i=new Intent(getApplicationContext(),ViedioActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.nav_exit:
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}