package org.example.evangelhistory.repositories;

import org.example.evangelhistory.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findEventByDateTime(LocalDateTime dateTime);
}
