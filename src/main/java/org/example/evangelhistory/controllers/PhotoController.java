/*package org.example.evangelhistory.controllers;

import lombok.RequiredArgsConstructor;
import org.example.evangelhistory.entities.Photo;
import org.example.evangelhistory.services.PhotoStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/images")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoStorageService service;

    @PostMapping("/upload")
    public ResponseEntity<Photo> uploadPhoto(
            @RequestParam("file")MultipartFile file,
            @RequestParam(value = "caption", required = false) String caption,
            @RequestParam(value = "altText", required = false) String altText) {
        try {
            Photo saved = service.store(file, caption, altText);
            return ResponseEntity.ok(saved);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Photo>> getAll() {
        return ResponseEntity.ok(service.getAllPhotos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
} */
