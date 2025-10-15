package org.example.evangelhistory.services;

import lombok.RequiredArgsConstructor;
import org.example.evangelhistory.entities.MediaAlbum;
import org.example.evangelhistory.entities.Photo;
import org.example.evangelhistory.repositories.MediaAlbumRepository;
import org.example.evangelhistory.repositories.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaAlbumService {

    private final MediaAlbumRepository albumRepo;
    private final PhotoRepository photoRepo;

    public List<MediaAlbum> getAllAlbums() {
        return albumRepo.findAll();
    }

    public MediaAlbum getAlbum(Long id) {
        return albumRepo.findById(id).orElseThrow(() -> new RuntimeException("Альбом не найден"));
    }

    public MediaAlbum createAlbum(MediaAlbum album) {
        album.setCreatedAt(java.time.LocalDateTime.now());
        return albumRepo.save(album);
    }

    public MediaAlbum addImageToAlbum (Long albumId, Photo photo){
        MediaAlbum album = getAlbum(albumId);
        album.addPhoto(photo);
        return albumRepo.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepo.deleteById(id);
    }

}
