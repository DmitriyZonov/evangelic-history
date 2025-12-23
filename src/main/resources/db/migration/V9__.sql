ALTER TABLE hero
    ADD period_article_id BIGINT NULL;

ALTER TABLE hero
    ADD CONSTRAINT FK_HERO_ON_PERIOD_ARTICLE FOREIGN KEY (period_article_id) REFERENCES period_article (period_article_id);

ALTER TABLE period_article
    DROP COLUMN column_name;