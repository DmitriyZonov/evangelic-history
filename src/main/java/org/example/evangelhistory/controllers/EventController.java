package org.example.evangelhistory.controllers;

import org.example.evangelhistory.entities.Event;
import org.example.evangelhistory.services.EventService;
import org.example.evangelhistory.utils.GetDateForAnnouncement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.format.DateTimeFormatter;

@Controller
public class EventController {

    private final EventService service;

    public EventController (EventService service) {
        this.service = service;
    }
    @GetMapping("event/{id}")
    public String getEvent (@PathVariable Long id,
                            Model model) {
        Event event = service.findById(id);

        model.addAttribute("event", event);
        model.addAttribute("dateFormatter", new GetDateForAnnouncement());
        return "/event";
    }
}
