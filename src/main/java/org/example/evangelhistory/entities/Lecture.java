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
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 10000)
    private String content;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Set<Photo> photoSet;
}
