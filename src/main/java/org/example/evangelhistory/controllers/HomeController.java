package org.example.evangelhistory.controllers;

import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.services.EventService;
import org.example.evangelhistory.services.HeroService;
import org.example.evangelhistory.services.PhotoStorageService;
import org.example.evangelhistory.utils.GetDateForAnnouncement;
import org.example.evangelhistory.utils.GetHeroesByCentury;
import org.example.evangelhistory.utils.GetHeroesWithVideo;
import org.example.evangelhistory.utils.GetSixRandomPhotoPaths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final HeroService heroService;
    private final EventService eventService;
    private final PhotoStorageService photoStorageService;


    public HomeController (HeroService heroService, EventService eventService, PhotoStorageService photoStorageService) {
        this.heroService = heroService;
        this.eventService = eventService;
        this.photoStorageService = photoStorageService;
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
        GetSixRandomPhotoPaths getSixRandomPhotoPaths = new GetSixRandomPhotoPaths(photoStorageService.getSetOfAllPhotos());

        model.addAttribute("eventList", eventService.getSortedListOfEvents());
        model.addAttribute("dateFormatter", new GetDateForAnnouncement());
        model.addAttribute("photoSet", new ArrayList<>(getSixRandomPhotoPaths.getRandomPhotoPaths()));
        return "events";
    }
    @GetMapping("/index")
    public String toMainPage(Model model) {
        model.addAttribute("eventList", eventService.getSortedListOfEvents());
        model.addAttribute("heroSet", GetHeroesWithVideo.getHeroesWithVideo(heroService.getAllHeroes()));
        return "index";
    }
    @GetMapping("/")
    public String toTitlePage(Model model) {
        model.addAttribute("eventList", eventService.getSortedListOfEvents());
        return "index";
    }
    @GetMapping("/privacy_policy")
    public String toPrivacyPolicyPage() {
        return "privacy_policy";
    }

    @GetMapping("/yandex_23d96a0065d0dcca.html")
    public String forYandexWebMaster() {
        return "yandex_23d96a0065d0dcca.html";
    }
}
