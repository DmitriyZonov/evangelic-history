package org.example.evangelhistory.controllers;

import org.example.evangelhistory.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService =  articleService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("latestArticles", articleService.findLatest(5));
        return "index";
    }
}
