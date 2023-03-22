package com.example.advancedcoded;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class SwipeableVideosActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipeable_videos);

        final ViewPager2 videosViewPager=findViewById(R.id.videoViewPager);
        List<VideoItem> videoItems=new ArrayList<>();

        VideoItem videoItemCelebration=new VideoItem();
        videoItemCelebration.videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        videoItemCelebration.videoTitle="Big Buck Bunny";
        videoItemCelebration.videoDescription="Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the rabbit ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge.\\n\\nLicensed under the Creative Commons Attribution license\\nhttp://www.bigbuckbunny.org";
        videoItems.add(videoItemCelebration);


        VideoItem videoItemElephantDream=new VideoItem();
        videoItemElephantDream.videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
        videoItemElephantDream.videoTitle="Elephant Dream";
        videoItemElephantDream.videoDescription="The first Blender Open Movie from 2006";
        videoItems.add(videoItemElephantDream);

        VideoItem videoItem3=new VideoItem();

        videoItem3.videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4";
        videoItem3.videoTitle="For Bigger Blazes";
        videoItem3.videoDescription="HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV. For when you want to settle into your Iron Throne to watch the latest episodes. For $35.\nLearn how to use Chromecast with HBO GO and more at google.com/chromecast.";
        videoItems.add(videoItem3);

        VideoItem videoItem4=new VideoItem();

        videoItem4.videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4";
        videoItem4.videoTitle="Tears of Steel";
        videoItem4.videoDescription="Tears of Steel was realized with crowd-funding by users of the open source 3D creation tool Blender. Target was to improve and test a complete open and free pipeline for visual effects in film - and to make a compelling sci-fi film in Amsterdam, the Netherlands.  The film itself, and all raw material used for making it, have been released under the Creatieve Commons 3.0 Attribution license. Visit the tearsofsteel.org website to find out more about this, or to purchase the 4-DVD box with a lot of extras.  (CC) Blender Foundation - http://www.tearsofsteel.org";

        videoItems.add(videoItem4);
        videosViewPager.setAdapter(new VideosAdapter(videoItems));


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