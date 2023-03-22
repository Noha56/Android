package com.example.advancedcoded;

import static com.example.advancedcoded.VideoAdapter.*;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private ArrayList<DataSetLink> videoItems;
    private Context context;

    public VideoAdapter(ArrayList<DataSetLink> videoItems, Context context) {
        this.videoItems = videoItems;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoViewHolder holder, int position) {
       DataSetLink current=videoItems.get(position);

         try{

             holder.webView.loadUrl(current.getLink());
             holder.fullScreenBtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                  Intent i=new Intent(context,VideoFullScreen.class);
                  i.putExtra("link",current.getLink());
                  context.startActivity(i);
                 }
             });

         }catch (Exception e){
             Toast.makeText(context, "Error connection", Toast.LENGTH_SHORT).show();
         }
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        WebView webView;
        Button fullScreenBtn;

        public VideoViewHolder(@NonNull View view) {
            super(view);
            webView = view.findViewById(R.id.video_view);
            fullScreenBtn = view.findViewById(R.id.fullScreen);

            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }

    }
}
