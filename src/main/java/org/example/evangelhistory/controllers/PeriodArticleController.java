package org.example.evangelhistory.controllers;

import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.entities.PeriodArticle;
import org.example.evangelhistory.services.PeriodArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PeriodArticleController {

    private final PeriodArticleService periodArticleService;

    public PeriodArticleController (PeriodArticleService periodArticleService) {
        this.periodArticleService = periodArticleService;
    }

    @GetMapping("/history_article/{id}")
    public String getPeriodArticle(Model model,
                                   @PathVariable Long id) {
        PeriodArticle periodArticle = periodArticleService.findById(id);
        model.addAttribute("periodArticle", periodArticle);
        return "/history_article";
    }
}
