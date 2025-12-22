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
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String smallName;
    private String yearsOfLife;
    @Column(length = 10000)
    private String biography;
    private String bigPortrait;
    private String smallPortrait;
    private String videoLink;
    private boolean isVideo;

    @ManyToMany (mappedBy = "heroes")
    private Set<Video> videos;
}
