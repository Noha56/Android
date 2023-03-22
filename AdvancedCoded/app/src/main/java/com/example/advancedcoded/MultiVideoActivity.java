package com.example.advancedcoded;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.google.android.material.navigation.NavigationView;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class MultiVideoActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    private RecyclerView recyclerView;
    private VideoAdapter adapter;
    private ArrayList<DataSetLink> videoItems = new ArrayList<>();
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_video);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataSetLink link1 = new DataSetLink("https://www.youtube.com/watch?v=hmAua85CxYU&ab_channel=%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D8%B5%D8%A8%D8%AD%D9%8A%D9%88%D8%B9%D8%A8%D8%AF%D8%A7%D9%84%D8%B1%D8%AD%D9%85%D9%86%D9%85%D8%B3%D8%B9%D8%AF");
        videoItems.add(link1);

        DataSetLink link2 = new DataSetLink("https://www.youtube.com/watch?v=4KzFe50RQkQ&ab_channel=EphemeralRift");
        videoItems.add(link2);

        DataSetLink link3 = new DataSetLink("https://www.youtube.com/watch?v=q76bMs-NwRk&ab_channel=TheRelaxedGuy");
        videoItems.add(link3);
        DataSetLink link4 = new DataSetLink("https://youtu.be/9nVSYkQoV5I");
        videoItems.add(link4);
        DataSetLink link5 = new DataSetLink("https://www.youtube.com/watch?v=1s-WLmproNM&ab_channel=ElzeroWebSchool");
        videoItems.add(link5);

        adapter = new VideoAdapter(videoItems, this);
        recyclerView.setAdapter(adapter);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation);
        menuIcon = findViewById(R.id.menu_icon);

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


    public boolean checkItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.map:
                i = new Intent(getApplicationContext(), Map.class);
                startActivity(i);
                finish();
                break;
            case R.id.multiVideos:
                i = new Intent(getApplicationContext(), MultiVideoActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.swipePage:
                i = new Intent(getApplicationContext(), SwipeableVideosActivity.class);
                startActivity(i);
                finish();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}