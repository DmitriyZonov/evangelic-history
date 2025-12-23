ALTER TABLE event
    ADD address VARCHAR(255) NULL;

ALTER TABLE event
    ADD `description` VARCHAR(2000) NULL;

ALTER TABLE event
    MODIFY announcement VARCHAR(2000);