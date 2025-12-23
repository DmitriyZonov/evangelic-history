package org.example.evangelhistory.utils;

import org.example.evangelhistory.constants.Century;
import org.example.evangelhistory.entities.Hero;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

public class GetHeroesByCentury {
    public static List<List<Hero>> get(List<Hero> heroes) {
        List<List<Hero>> heroLists = new ArrayList<>();
        for (int i = 1; i <= Century.values().length; i++) {
            List<Hero> heroList = new ArrayList<>();
            for (Hero hero : heroes) {
                if (hero.getCentury().getCenturyValue() == i) {
                    heroList.add(hero);
                }
            }
            heroLists.add(heroList);
        }
        return heroLists;
    }
}
