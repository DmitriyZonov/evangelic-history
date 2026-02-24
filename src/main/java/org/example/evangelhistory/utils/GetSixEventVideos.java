package org.example.evangelhistory.utils;

import java.util.HashSet;
import java.util.Set;

public class GetSixEventVideos {

    private final Set<String> videoSet;

    public GetSixEventVideos(Set<String> videoSet) {
        this.videoSet = videoSet;
    }
    public Set<String> get() {
        Set<String> videos = new HashSet<>();
        int counter = 0;
        for (String video : videoSet) {
            counter ++;
            if (counter <= 6) {
                videos.add(video);
            }
        }
        return videos;
    }
}
