package org.example.evangelhistory.utils;

import org.example.evangelhistory.entities.Hero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetHeroesWithVideo {
    public static Set<Hero> getHeroesWithVideo(List<Hero> heroes) {
       Set<Hero> heroWithVideoSet = new HashSet<>();

       for (Hero hero : heroes) {
           if (hero.isVideo()) {
               heroWithVideoSet.add(hero);
           }
       }
       return heroWithVideoSet;
    }
}
