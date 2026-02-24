package org.example.evangelhistory.services;

import org.example.evangelhistory.entities.Event;
import org.example.evangelhistory.repositories.EventRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository repo;

    public EventService(EventRepository repository) {
        this.repo = repository;
    }

    public List<Event> getSortedListOfEvents() {
        List<Event> allEvents = repo.findAll();
        allEvents.sort(Comparator.comparing(Event::getDateTime));
        return allEvents;
    }
    public Set<String> getAllVideos() {
        Set<String> videos = new HashSet<>();
        List<Event> events = repo.findAll();
        for (Event event : events) {
            if (event.getVideoLink() != null) {
                videos.add(event.getVideoLink());
            }
        }
        return videos;
    }
    public Event findById(@NotNull Long id) {
        Optional<Event> eventFromDB = repo.findById(id);
        if (eventFromDB.isPresent()) {
            return eventFromDB.get();
        } else {
            throw new NullPointerException("Мероприятие не найдено");
        }
    }
    public Event findByDate (LocalDateTime localDateTime) {
        Event eventFromDB = repo.findEventByDateTime(localDateTime);
        if(eventFromDB != null) {
            return eventFromDB;
        } else  {
            throw new NullPointerException("Мероприятие не найдено");
        }
    }
    public void save (@NotNull Event event) {
        repo.save(event);
    }

    public void deleteById(@NotNull Long id) {
        Optional<Event> eventFromDB = repo.findById(id);
        if (eventFromDB.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new NullPointerException("Мероприятие не найдено");
        }
    }
}
