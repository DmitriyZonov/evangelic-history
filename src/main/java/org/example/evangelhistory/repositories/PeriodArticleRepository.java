package org.example.evangelhistory.repositories;

import org.example.evangelhistory.entities.PeriodArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodArticleRepository extends JpaRepository<PeriodArticle, Long> {
    PeriodArticle findPeriodArticleByPeriod (String period);
}
