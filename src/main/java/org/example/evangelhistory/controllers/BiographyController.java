package org.example.evangelhistory.controllers;

import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.services.HeroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BiographyController {

private final HeroService heroService;

public BiographyController(HeroService service) {
    this.heroService = service;
}
@GetMapping("/biography/{id}")
public String getHeroBiography(Model model,
                               @PathVariable Long id) {
    Hero hero = heroService.findById(id);
    if (hero == null) {
        return "/error";
    } else {
        model.addAttribute("hero", hero);
        return "/biography";
    }
}
}
