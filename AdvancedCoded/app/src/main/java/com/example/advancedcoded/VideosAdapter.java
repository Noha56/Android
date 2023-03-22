package com.example.advancedcoded;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {
     private List<VideoItem> videoItemList;

     public VideosAdapter(List<VideoItem> videoItemList) {
          this.videoItemList = videoItemList;
     }

     @NonNull
     @Override
     public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          return new VideoViewHolder(
                  LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_video,
                          parent,
                          false
                  )
          );
     }

     @Override
     public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
          holder.setVideoData(videoItemList.get(position));
     }

     @Override
     public int getItemCount() {
          return videoItemList.size();
     }

     static class VideoViewHolder extends RecyclerView.ViewHolder{

          VideoView videoView;
          TextView textViewTitle,textViewDescription;
          ProgressBar videoProgressBar;

          public VideoViewHolder(@NonNull View itemView) {
               super(itemView);

               videoView=itemView.findViewById(R.id.videoView);
               textViewDescription=itemView.findViewById(R.id.textVideoDescription);
               textViewTitle=itemView.findViewById(R.id.textVideoTitle);
               videoProgressBar=itemView.findViewById(R.id.videoProgressBar);

          }
          void setVideoData(VideoItem videoItem){
            textViewTitle.setText(videoItem.videoTitle);
            textViewDescription.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                 @Override
                 public void onPrepared(MediaPlayer mediaPlayer) {
                      videoProgressBar.setVisibility(View.GONE);
                      mediaPlayer.start();
                      float videoRatio= mediaPlayer.getVideoWidth()/(float)mediaPlayer.getVideoHeight();
                      float screenRatio= videoView.getWidth()/(float)videoView.getHeight();
                      float scale=videoRatio/screenRatio;
                      if(scale>=1f){
                           videoView.setScaleX(scale);
                      }else{
                           videoView.setScaleY(1f/scale);
                      }

                 }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                 @Override
                 public void onCompletion(MediaPlayer mediaPlayer) {
                      mediaPlayer.start();
                 }
            });
          }
     }
}
