ALTER TABLE period_article
    ADD id BIGINT AUTO_INCREMENT NULL;

ALTER TABLE period_article
    ADD PRIMARY KEY (id);

ALTER TABLE hero
    ADD CONSTRAINT FK_HERO_ON_PERIOD_ARTICLE FOREIGN KEY (period_article_id) REFERENCES period_article (id);