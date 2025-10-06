package org.example.evangelhistory.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Hero {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column (length = 10000)
    private String biography;

    @ManyToMany (mappedBy = "heroes")
    private Set<Video> videos;
}
