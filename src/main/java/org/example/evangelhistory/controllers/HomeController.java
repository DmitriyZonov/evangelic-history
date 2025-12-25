package org.example.evangelhistory.controllers;

import org.example.evangelhistory.constants.Century;
import org.example.evangelhistory.entities.Event;
import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.entities.PeriodArticle;
import org.example.evangelhistory.services.EventService;
import org.example.evangelhistory.services.HeroService;
import org.example.evangelhistory.services.PeriodArticleService;
import org.example.evangelhistory.utils.GetDateForAnnouncement;
import org.example.evangelhistory.utils.GetHeroesByCentury;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    private final HeroService heroService;
    private final EventService eventService;

    public HomeController (HeroService heroService, EventService eventService) {
        this.heroService = heroService;
        this.eventService = eventService;
    }

    @GetMapping("/about")
    public String toAboutUsPage() {
        return "about";
    }
    @GetMapping("/biographies")
    public String toBiographyPage(Model model) {
        List<Hero> heroes = heroService.getAllHeroes();
        List<List<Hero>> heroLists = GetHeroesByCentury.get(heroes);
        model.addAttribute("sortedListOfHeroesLists", heroLists);
        return "biographies";
    }
    @GetMapping("/history")
    public String toHistoryPage() {
        return "history";
    }
    @GetMapping("/events")
    public String toEventsPage(Model model) {
        List<Event> eventList = eventService.getSortedListOfEvents();
        model.addAttribute("eventList", eventList);
        model.addAttribute("dateFormatter", new GetDateForAnnouncement());
        return "events";
    }
    @GetMapping("/index")
    public String toMainPage() {
        return "index";
    }
    @GetMapping("/privacy_policy")
    public String toPrivacyPolicyPage() {
        return "privacy_policy";
    }
}