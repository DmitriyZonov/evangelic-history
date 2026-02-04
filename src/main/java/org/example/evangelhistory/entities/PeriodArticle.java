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
@Table(name="period_article", schema = "evangelical_history")
public class PeriodArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="period_article_id")
    private Long id;
    private Long type;
    private String periodTitle;
    private String periodDescription;
    private String centuryTitle;
    private String partCenturyTitle;
    private String titleImage;
    private String titleImageDescription;
    @Column(nullable = false, length = 3000)
    private String shortArticle;
    @Column(nullable = false, length = 10000)
    private String article;
    private String image;

    @OneToMany(mappedBy = "periodArticle", fetch = FetchType.LAZY)
    private Set<Hero> heroSet;
}