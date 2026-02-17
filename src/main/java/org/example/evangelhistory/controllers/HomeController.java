package org.example.evangelhistory.controllers;

import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.services.EventService;
import org.example.evangelhistory.services.HeroService;
import org.example.evangelhistory.services.PeriodArticleService;
import org.example.evangelhistory.services.PhotoStorageService;
import org.example.evangelhistory.utils.GetDateForAnnouncement;
import org.example.evangelhistory.utils.GetHeroesByCentury;
import org.example.evangelhistory.utils.GetHeroesWithVideo;
import org.example.evangelhistory.utils.GetSixRandomPhoto;
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
    private final PeriodArticleService periodArticleService;


    public HomeController (HeroService heroService, EventService eventService, PhotoStorageService photoStorageService, PeriodArticleService periodArticleService) {
        this.heroService = heroService;
        this.eventService = eventService;
        this.photoStorageService = photoStorageService;
        this.periodArticleService = periodArticleService;
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
    public String toHistoryPage(Model model) {
        model.addAttribute("periodArticleList", periodArticleService.findAll());
        return "history";
    }
    @GetMapping("/events")
    public String toEventsPage(Model model) {
        GetSixRandomPhoto getSixRandomPhotoPaths = new GetSixRandomPhoto(photoStorageService.getSetOfAllPhotos());

        model.addAttribute("eventList", eventService.getSortedListOfEvents());
        model.addAttribute("dateFormatter", new GetDateForAnnouncement());
        model.addAttribute("photoSet", new ArrayList<>(getSixRandomPhotoPaths.getRandomPhoto()));
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
        model.addAttribute("heroSet", GetHeroesWithVideo.getHeroesWithVideo(heroService.getAllHeroes()));
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
