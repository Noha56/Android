package com.example.advancedcoded;

public class VideoItem {
    public String videoURL,videoTitle,videoDescription;

    private String videoUrl;
    private String preViewUrl;

    public VideoItem(){}
    public VideoItem(String videoUrl,String preViewUrl) {
        this.videoUrl = videoUrl;
        this.preViewUrl = preViewUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getPreViewUrl() {
        return preViewUrl;
    }

    public void setPreViewUrl(String preViewUrl) {
        this.preViewUrl = preViewUrl;
    }
}
