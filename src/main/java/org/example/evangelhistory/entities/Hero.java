package org.example.evangelhistory.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.evangelhistory.constants.Century;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="hero", schema = "evangelical_history")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hero_id")
    private Long id;
    private String fullName;
    private String smallName;
    private String yearsOfLife;
    @Column(length = 10000)
    private String biography;
    private String bigPortrait;
    private String smallPortrait;
    private boolean isVideo;
    private String videoLink;
    private String videoTitle;
    private Century century;

//    @ManyToMany (mappedBy = "heroes")
//    private Set<Video> videos;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "period_article_id")
    private PeriodArticle periodArticle;
}
