package org.example.evangelhistory.services;

import lombok.RequiredArgsConstructor;
import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.entities.PeriodArticle;
import org.example.evangelhistory.repositories.PeriodArticleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PeriodArticleService {

    private final PeriodArticleRepository repo;

    public List<PeriodArticle> findAll () {
        return repo.findAll();
    }
    public Set<Hero> getAllHeroes(@NotNull Long id) {
        Optional<PeriodArticle> fromDb = repo.findById(id);
        if(fromDb.isPresent()) {
            PeriodArticle periodArticle = fromDb.get();
            return periodArticle.getHeroSet();
        } else {
            throw new NullPointerException("Такой статьи нет");
        }
    }
    public PeriodArticle findById(@NotNull Long id) {
        Optional<PeriodArticle> fromDb = repo.findById(id);
        if(fromDb.isPresent()) {
            return fromDb.get();
        } else {
            throw new NullPointerException("Такой статьи нет");
        }
    }
    public PeriodArticle findByPeriod (@NotNull String period) {
        PeriodArticle articleFromDB = repo.findPeriodArticleByPeriod(period);
        if (articleFromDB != null) {
            return articleFromDB;
        } else {
            throw new NullPointerException("Такой статьи нет");
        }
    }
    public void save (@NotNull PeriodArticle article) {
        repo.save(article);
    }
    public void addPeriod (@NotNull PeriodArticle periodArticle, String period) {
        periodArticle.setPeriod(period);
        repo.save(periodArticle);
    }
    public void deleteById (@NotNull Long id) {
        Optional<PeriodArticle> articleFromDB = repo.findById(id);

        if(articleFromDB.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new NullPointerException("Такой статьи нет");
        }
    }
}
