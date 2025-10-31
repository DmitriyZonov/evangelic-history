/* package org.example.evangelhistory.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.evangelhistory.entities.Video;
import org.example.evangelhistory.repositories.VideoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("api/admin/videos")
public class AdminController {
    private final VideoRepository repo;

    private AdminController(VideoRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public ResponseEntity<Video> create(@RequestBody Video v) {
        Video saved = repo.save(v);
        return ResponseEntity.created(URI.create("api/videos/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> update(@PathVariable Long id, @RequestBody Video v) {
        Optional<Video> existing = repo.findById(id);
        if (existing.isEmpty()) return ResponseEntity.notFound().build();
        v.setId(id);
        return ResponseEntity.ok(repo.save(v));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
*/