package org.example.evangelhistory.services;

import lombok.RequiredArgsConstructor;
import org.example.evangelhistory.entities.MediaAlbum;
import org.example.evangelhistory.entities.Photo;
import org.example.evangelhistory.repositories.MediaAlbumRepository;
import org.example.evangelhistory.repositories.PhotoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaAlbumService {

    private final MediaAlbumRepository albumRepo;

    public List<MediaAlbum> getAllAlbums() {
        return albumRepo.findAll();
    }

    public MediaAlbum getAlbum(Long id) {
        Optional<MediaAlbum> albumFromDB = albumRepo.findById(id);
        if (albumFromDB.isPresent()) {
           return albumFromDB.get();
        } else {
            throw new NullPointerException("Альбом не найден");
        }
    }
    public MediaAlbum findByTitle(String title) {
        MediaAlbum albumFromDB = albumRepo.findMediaAlbumByTitle(title);
        if (albumFromDB != null) {
            return albumFromDB;
        } else {
            throw new NullPointerException("Альбом не найден");
        }
    }
    public void save (MediaAlbum album) {
        albumRepo.save(album);
    }

    public void addPhoto (@NotNull Long id, Photo photo){
        Optional<MediaAlbum> albumFromDB = albumRepo.findById(id);
        if (albumFromDB.isPresent()) {
            albumFromDB.get().getPhotos().add(photo);
        } else {
            throw new NullPointerException("Альбом не найден");
        }
    }

    public void deleteById(@NotNull Long id) {
        Optional<MediaAlbum> albumFromDB = albumRepo.findById(id);
        if (albumFromDB.isPresent()) {
            albumRepo.deleteById(id);
        } else {
            throw new NullPointerException("Альбом не найден");
        }
    }

}
