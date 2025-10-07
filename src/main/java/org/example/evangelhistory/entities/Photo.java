package org.example.evangelhistory.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "photos", indexes = {
        @Index(name = "idx_photos_title", columnList = "title")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Photo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    private String path;
    @Column(length = 500)
    private String caption;
    private String altText;
    private Integer width;
    private Integer length;
    private LocalDateTime uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private MediaAlbum mediaAlbum;

    public String getFullUrl() {
        return path.endsWith("/") ? path + title : path + "/" + title;
    }
}
