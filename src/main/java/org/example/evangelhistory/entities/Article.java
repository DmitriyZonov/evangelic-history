//package org.example.evangelhistory.entities;
//
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//
//@Entity
//@Getter
//@Setter
//@RequiredArgsConstructor
//public class Article implements Comparable<Article>{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    @Column(nullable = false, unique = true, length = 150)
//    private String slug;
//
//    @Column(nullable = false)
//    private String title;
//
//    @Column(length = 10000)
//    private String content;
//
//    @Column(length = 500)
//    private String excerpt;
//
//    private boolean published;
//
//    private LocalDateTime publishedAt;
//
//    private String metaTitle;
//    private String metaDescription;
//
//    @Override
//    public int compareTo(Article article) {
//        return getPublishedAt().compareTo(article.getPublishedAt());
//    }
//}
