package org.example.evangelhistory.repositories;

import lombok.extern.slf4j.Slf4j;
import org.example.evangelhistory.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {}
