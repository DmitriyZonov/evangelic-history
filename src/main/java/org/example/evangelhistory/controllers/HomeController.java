package org.example.evangelhistory.controllers;

import org.example.evangelhistory.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService =  articleService;
    }
    @GetMapping("/about")
    public String toAboutUsPage() {
        return "about";
    }
    @GetMapping("/biographies")
    public String toBiographyPage() {
        return "biographies";
    }
    @GetMapping("/history")
    public String toHistoryPage() {
        return "history";
    }
    @GetMapping("/gallery")
    public String toGalleryPage() {
        return "gallery";
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