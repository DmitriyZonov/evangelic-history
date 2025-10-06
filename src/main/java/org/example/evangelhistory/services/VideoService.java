package org.example.evangelhistory.services;

import org.example.evangelhistory.entities.Video;
import org.example.evangelhistory.repositories.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    private final VideoRepository repo;

    public VideoService(VideoRepository repo) {
        this.repo = repo;
    }
    public List<Video> getAllVideos () {
        return repo.findAll();
    }
}
