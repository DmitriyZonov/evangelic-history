package org.example.evangelhistory.controllers;

import org.example.evangelhistory.constants.Century;
import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.entities.PeriodArticle;
import org.example.evangelhistory.services.HeroService;
import org.example.evangelhistory.services.PeriodArticleService;
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
    private final PeriodArticleService periodArticleService;

    public HomeController (HeroService heroService, PeriodArticleService periodArticleService) {
        this.heroService = heroService;
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
    public String toHistoryPage() {
        return "history";
    }
    @GetMapping("/events")
    public String toEventsPage() {
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