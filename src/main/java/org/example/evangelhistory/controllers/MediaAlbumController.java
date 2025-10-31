/* package org.example.evangelhistory.controllers;

import lombok.RequiredArgsConstructor;
import org.example.evangelhistory.entities.MediaAlbum;
import org.example.evangelhistory.entities.Photo;
import org.example.evangelhistory.services.MediaAlbumService;
import org.example.evangelhistory.services.PhotoStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/albums")
@RequiredArgsConstructor
public class MediaAlbumController {
    private MediaAlbumService albumService;
    private PhotoStorageService photoService;

    @GetMapping
    public ResponseEntity<List<MediaAlbum>> getAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @PostMapping
    public ResponseEntity<MediaAlbum> createAlbum(@RequestBody MediaAlbum album) {
        MediaAlbum saved = albumService.createAlbum(album);
        return ResponseEntity.ok(saved);
    }
    @PostMapping("/{albumId}/upload")
    public ResponseEntity<MediaAlbum> uploadToAlbum(
            @PathVariable Long albumId,
            @RequestParam("file")MultipartFile file,
            @RequestParam(value = "caption", required = false) String caption,
            @RequestParam(value = "altText", required = false) String altText
            ) throws IOException {
        Photo photo = photoService.store(file, caption, altText);
        MediaAlbum updated = albumService.addImageToAlbum(albumId, photo);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{albumId}")
    public ResponseEntity<Void> deleteAlbum(Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}
*/