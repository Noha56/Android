package com.example.clevermindpob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Adapter.HomeRecyclerAdapter;
import Adapter.HomeViewPagerAdapter;
import Model.HomeRecyclerViewModel;
import Model.HomeViewPagerModel;
import Model.TrainingCenterModel;

public class Home extends AppCompatActivity {
    //menu
    private DrawerLayout drawer;
    private NavigationView navigationView;

    //recycler view
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HomeRecyclerViewModel> listItems;

    private ViewPager viewPager;
    private HomeViewPagerAdapter viewPagerAdapter;
    private List<HomeViewPagerModel> models;

    ImageView bell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //menu
        {
            drawer = findViewById(R.id.drawer);
            findViewById(R.id.menu_icon).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawer.openDrawer(GravityCompat.START);
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

        //recycler view
        {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            listItems = new ArrayList<>();


            listItems.add(new HomeRecyclerViewModel(getResources().getString(R.string.ANDROID), getResources().getString(R.string.SUNTHU), getResources().getString(R.string.time101), getResources().getString(R.string.ATTENDNOW), R.drawable.android, R.drawable.right));
            listItems.add(new HomeRecyclerViewModel(getResources().getString(R.string.ios), getResources().getString(R.string.SATTUS), getResources().getString(R.string.time112), getResources().getString(R.string.ATTENDNOW), R.drawable.ioslogo, R.drawable.right));
            listItems.add(new HomeRecyclerViewModel(getResources().getString(R.string.qa), getResources().getString(R.string.MONTHU), getResources().getString(R.string.time91), getResources().getString(R.string.ATTENDNOW), R.drawable.qa, R.drawable.right));



            adapter = new HomeRecyclerAdapter(this, listItems);
            recyclerView.setAdapter(adapter);
        }

        //notification



        {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                NotificationChannel channel=new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager=getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }

            bell = findViewById(R.id.notification);
            bell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Home.this, "My Notification");
                    builder.setContentTitle("Clever Mind POB");
                    builder.setContentText("Don't forget to attend the class today!");
                    builder.setSmallIcon(R.drawable.android);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Home.this);
                    managerCompat.notify(1, builder.build());

                    Toast.makeText(Home.this,"Check notification",Toast.LENGTH_SHORT).show();

                }
            });
        }


        //view pager

        {
            models = new ArrayList<>();
            models.add(new HomeViewPagerModel(R.drawable.android,  getResources().getString(R.string.android_web)));
            models.add(new HomeViewPagerModel(R.drawable.google,  getResources().getString(R.string.google_up)));
            models.add(new HomeViewPagerModel(R.drawable.ioslogo,  getResources().getString(R.string.ios_up)));

            viewPagerAdapter = new HomeViewPagerAdapter(models, this);
            viewPager = findViewById(R.id.viewPager);
            viewPager.setAdapter(viewPagerAdapter);
            viewPager.setPadding(180, 0, 180, 0);

            viewPager.setCurrentItem(0);

           /* findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            });
            findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                }
            });*/
        }
    }
    public boolean checkItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(Home.this, getResources().getString(R.string.profile), Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Profile.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.attend:
                Toast.makeText(this, getResources().getString(R.string.attend), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Attend.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.event:
                Toast.makeText(this, getResources().getString(R.string.latest_events), Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Events.class);
                startActivity(intent3);
                finish();

                break;
            case R.id.jobs:
                Toast.makeText(this, getResources().getString(R.string.job), Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Job.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.setting:
                Toast.makeText(this, getResources().getString(R.string.SETTINGS), Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, Setting.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.payment:
                Toast.makeText(this, getResources().getString(R.string.PAYMENT), Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, Payment.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.policy:
                Toast.makeText(this, getResources().getString(R.string.PRIVACYPOLICY), Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this, Policy.class);
                startActivity(intent7);
                finish();
                break;
            case R.id.logout:
                Toast.makeText(this,getResources().getString(R.string.log_out) , Toast.LENGTH_SHORT).show();
                Intent intent8 = new Intent(this,MainActivity.class);
                startActivity(intent8);
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}