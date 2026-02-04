ALTER TABLE period_article
    ADD century_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD period_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD short_article VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD title_image VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD title_image_description VARCHAR(255) NULL;

ALTER TABLE period_article
    MODIFY period_title VARCHAR(255) NULL;

ALTER TABLE period_article
    DROP COLUMN period;

ALTER TABLE period_article
    DROP COLUMN title;

ALTER TABLE period_article
    ADD century_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD period_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD short_article VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD title_image VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD title_image_description VARCHAR(255) NULL;

ALTER TABLE period_article
    MODIFY period_title VARCHAR(255) NOT NULL;

ALTER TABLE period_article
    DROP COLUMN period;

ALTER TABLE period_article
    DROP COLUMN title;