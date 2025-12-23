CREATE TABLE event
(
    event_id     BIGINT AUTO_INCREMENT NOT NULL,
    title        VARCHAR(255)          NULL,
    date_time    datetime              NULL,
    city         VARCHAR(255)          NULL,
    announcement VARCHAR(255)          NULL,
    title_image  VARCHAR(255)          NULL,
    CONSTRAINT pk_event PRIMARY KEY (event_id)
);

ALTER TABLE media_albums
    ADD event_id BIGINT NULL;

ALTER TABLE media_albums
    ADD CONSTRAINT uc_media_albums_event UNIQUE (event_id);

ALTER TABLE media_albums
    ADD CONSTRAINT FK_MEDIA_ALBUMS_ON_EVENT FOREIGN KEY (event_id) REFERENCES event (event_id);

DROP TABLE article;