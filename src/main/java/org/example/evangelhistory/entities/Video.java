package org.example.evangelhistory.entities;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String platform;
    private String videoId;

    @ManyToMany
    @JoinTable(name = "video_hero",
            joinColumns = @JoinColumn (name = "video_id"),
            inverseJoinColumns = @JoinColumn (name = "hero_id"))
    private Set<Hero> heroes;
}
