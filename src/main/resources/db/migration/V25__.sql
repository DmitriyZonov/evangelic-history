ALTER TABLE period_article
    ADD century_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD part_century_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD period_description VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD period_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD short_article VARCHAR(3000) NULL;

ALTER TABLE period_article
    ADD title_image VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD title_image_description VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD type BIGINT NULL;

ALTER TABLE period_article
    MODIFY short_article VARCHAR(3000) NOT NULL;

ALTER TABLE hero
    ADD video_title VARCHAR(255) NULL;

ALTER TABLE period_article
    DROP COLUMN period;

ALTER TABLE period_article
    DROP COLUMN title;

ALTER TABLE period_article
    ADD century_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD part_century_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD period_description VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD period_title VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD short_article VARCHAR(3000) NULL;

ALTER TABLE period_article
    ADD title_image VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD title_image_description VARCHAR(255) NULL;

ALTER TABLE period_article
    ADD type BIGINT NULL;

ALTER TABLE period_article
    MODIFY short_article VARCHAR(3000) NOT NULL;

ALTER TABLE hero
    ADD video_title VARCHAR(255) NULL;

ALTER TABLE period_article
    DROP COLUMN period;

ALTER TABLE period_article
    DROP COLUMN title;