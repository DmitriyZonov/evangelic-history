//package org.example.evangelhistory.services;
//
//import org.example.evangelhistory.entities.Article;
//import org.example.evangelhistory.repositories.ArticleRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class ArticleService {
//
//    private final ArticleRepository repo;
//
//    public ArticleService(ArticleRepository repo) {
//        this.repo = repo;
//    }
//
//    public List<Article> findLatest(int count) {
//        List<Article> articles = repo.findAll();
//        int countOfArticles = articles.size();
//        Collections.sort(articles);
//        return articles.subList(countOfArticles-1-count, articles.size());
//    }
//}
