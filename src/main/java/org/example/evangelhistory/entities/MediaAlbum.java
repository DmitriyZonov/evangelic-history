package org.example.evangelhistory.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "media_album", schema = "evangelical_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 2000)
    private String description;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "mediaAlbum",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY)
    @Builder.Default
    private List<Photo> photos = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    public void addPhoto(Photo photo) {
        photos.add(photo);
        photo.setMediaAlbum(this);
    }
    public void removePhoto(Photo photo) {
        photos.remove(photo);
        photo.setMediaAlbum(null);
    }
}
