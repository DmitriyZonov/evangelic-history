ALTER TABLE hero
    DROP FOREIGN KEY FKmijsgtrjkws7e75w5wjx3rv4g;

ALTER TABLE hero
    ADD period_article_id BIGINT NULL;

ALTER TABLE period_article
    ADD period_article_id BIGINT AUTO_INCREMENT NULL;

ALTER TABLE hero
    ADD CONSTRAINT FK_HERO_ON_PERIOD_ARTICLE FOREIGN KEY (period_article_id) REFERENCES period_article (period_article_id);

ALTER TABLE period_article
    DROP COLUMN id;

ALTER TABLE hero
    DROP COLUMN periodarticle_id;

ALTER TABLE period_article
    ADD PRIMARY KEY (period_article_id);