ALTER TABLE event
    ADD announce_image VARCHAR(255) NULL;

ALTER TABLE media_album
    ADD CONSTRAINT uc_media_album_event UNIQUE (event_id);
