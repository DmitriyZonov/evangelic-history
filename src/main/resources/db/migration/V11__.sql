CREATE TABLE `role`
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE user
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    name                 VARCHAR(255)          NULL,
    password             VARCHAR(255)          NULL,
    date_of_registration datetime              NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    user_id  BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (user_id, roles_id)
);

CREATE TABLE event
(
    event_id      BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NULL,
    date_time     datetime              NULL,
    city          VARCHAR(255)          NULL,
    address       VARCHAR(255)          NULL,
    announcement  VARCHAR(2000)         NULL,
    `description` VARCHAR(2000)         NULL,
    title_image   VARCHAR(255)          NULL,
    CONSTRAINT pk_event PRIMARY KEY (event_id)
);

CREATE TABLE hero
(
    hero_id           BIGINT AUTO_INCREMENT NOT NULL,
    full_name         VARCHAR(255)          NULL,
    small_name        VARCHAR(255)          NULL,
    years_of_life     VARCHAR(255)          NULL,
    biography         VARCHAR(10000)        NULL,
    big_portrait      VARCHAR(255)          NULL,
    small_portrait    VARCHAR(255)          NULL,
    video_link        VARCHAR(255)          NULL,
    is_video          BIT(1)                NOT NULL,
    period_article_id BIGINT                NULL,
    CONSTRAINT pk_hero PRIMARY KEY (hero_id)
);

CREATE TABLE media_album
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NOT NULL,
    `description` VARCHAR(2000)         NULL,
    created_at    datetime              NULL,
    event_id      BIGINT                NULL,
    CONSTRAINT pk_media_album PRIMARY KEY (id)
);

CREATE TABLE photo
(
    photo_id    BIGINT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(255)          NOT NULL,
    `path`      VARCHAR(255)          NULL,
    caption     VARCHAR(500)          NULL,
    alt_text    VARCHAR(255)          NULL,
    width       INT                   NULL,
    length      INT                   NULL,
    uploaded_at datetime              NULL,
    album_id    BIGINT                NULL,
    CONSTRAINT pk_photo PRIMARY KEY (photo_id)
);

ALTER TABLE media_album
    ADD CONSTRAINT uc_media_album_event UNIQUE (event_id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (roles_id) REFERENCES `role` (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE hero
    ADD CONSTRAINT FK_HERO_ON_PERIOD_ARTICLE FOREIGN KEY (period_article_id) REFERENCES period_article (period_article_id);

ALTER TABLE media_album
    ADD CONSTRAINT FK_MEDIA_ALBUM_ON_EVENT FOREIGN KEY (event_id) REFERENCES event (event_id);

ALTER TABLE photo
    ADD CONSTRAINT FK_PHOTO_ON_ALBUM FOREIGN KEY (album_id) REFERENCES media_album (id);

CREATE TABLE event
(
    event_id      BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NULL,
    date_time     datetime              NULL,
    city          VARCHAR(255)          NULL,
    address       VARCHAR(255)          NULL,
    announcement  VARCHAR(2000)         NULL,
    `description` VARCHAR(2000)         NULL,
    title_image   VARCHAR(255)          NULL,
    CONSTRAINT pk_event PRIMARY KEY (event_id)
);

CREATE TABLE hero
(
    hero_id           BIGINT AUTO_INCREMENT NOT NULL,
    full_name         VARCHAR(255)          NULL,
    small_name        VARCHAR(255)          NULL,
    years_of_life     VARCHAR(255)          NULL,
    biography         VARCHAR(10000)        NULL,
    big_portrait      VARCHAR(255)          NULL,
    small_portrait    VARCHAR(255)          NULL,
    video_link        VARCHAR(255)          NULL,
    is_video          BIT(1)                NOT NULL,
    period_article_id BIGINT                NULL,
    CONSTRAINT pk_hero PRIMARY KEY (hero_id)
);

CREATE TABLE media_album
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NOT NULL,
    `description` VARCHAR(2000)         NULL,
    created_at    datetime              NULL,
    event_id      BIGINT                NULL,
    CONSTRAINT pk_media_album PRIMARY KEY (id)
);

CREATE TABLE photo
(
    photo_id    BIGINT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(255)          NOT NULL,
    `path`      VARCHAR(255)          NULL,
    caption     VARCHAR(500)          NULL,
    alt_text    VARCHAR(255)          NULL,
    width       INT                   NULL,
    length      INT                   NULL,
    uploaded_at datetime              NULL,
    album_id    BIGINT                NULL,
    CONSTRAINT pk_photo PRIMARY KEY (photo_id)
);

ALTER TABLE media_album
    ADD CONSTRAINT uc_media_album_event UNIQUE (event_id);

ALTER TABLE hero
    ADD CONSTRAINT FK_HERO_ON_PERIOD_ARTICLE FOREIGN KEY (period_article_id) REFERENCES period_article (period_article_id);

ALTER TABLE media_album
    ADD CONSTRAINT FK_MEDIA_ALBUM_ON_EVENT FOREIGN KEY (event_id) REFERENCES event (event_id);

ALTER TABLE photo
    ADD CONSTRAINT FK_PHOTO_ON_ALBUM FOREIGN KEY (album_id) REFERENCES media_album (id);