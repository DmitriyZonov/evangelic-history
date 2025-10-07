package org.example.evangelhistory.services;

import lombok.RequiredArgsConstructor;
import org.example.evangelhistory.configs.MediaProperties;
import org.example.evangelhistory.entities.Photo;
import org.example.evangelhistory.repositories.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoStorageService {

    private final PhotoRepository repo;

    private final MediaProperties mediaProperties;

    public Photo store(MultipartFile file, String caption, String altText) throws IOException {
        String uploadDir = mediaProperties.getUploadDir();
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        if(!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path targetPath = uploadPath.resolve(fileName);

        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        Photo photo = Photo.builder()
                .title(fileName)
                .path("/uploads")
                .caption(caption)
                .altText(altText)
                .uploadedAt(LocalDateTime.now())
                .build();

        return repo.save(photo);
    }

    public List<Photo> getAllPhotos() {
        return repo.findAll();
    }
    public void delete (Long id) throws IOException {
        Photo photo = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        Path path = Paths.get(mediaProperties.getUploadDir()).resolve(photo.getTitle());
        Files.deleteIfExists(path);
        repo.delete(photo);
    }

}
