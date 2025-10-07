package org.example.evangelhistory.repositories;

import org.example.evangelhistory.entities.MediaAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaAlbumRepository extends JpaRepository<MediaAlbum, Long> {
}
