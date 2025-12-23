package org.example.evangelhistory.services;

import org.example.evangelhistory.constants.Century;
import org.example.evangelhistory.entities.Hero;
import org.example.evangelhistory.repositories.HeroRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HeroService {
    private final HeroRepository repo;

    public HeroService(HeroRepository repo) {
        this.repo=repo;
    }
    public List<Hero> getAllHeroes () {
        return repo.findAll();
    }
    public Hero findById(@NotNull Long id) {
        Hero hero;
        Optional<Hero> heroFromDB = repo.findById(id);
        if (heroFromDB.isPresent()) {
            hero = heroFromDB.get();
        } else {
            throw new NullPointerException("Герой не найден");
        }
        return hero;
    }
    public Long findHeroIdBySmallName (@NotNull String smallName) {
        Hero heroFromDB = repo.findHeroBySmallName(smallName);
        if(!(heroFromDB == null)) {
            return heroFromDB.getId();
        } else {
            throw new NullPointerException("Герой не найден");
        }
    }
    public Set<Hero> findByCentury(Century century) {
        return repo.findHeroesByCentury(century);
    }
    public void save (@NotNull Hero hero) {
        repo.save(hero);
    }
    public void addBiography (@NotNull Hero hero, String biography){
        hero.setBiography(biography);
        repo.save(hero);
    }
    public void addBigPortrait (@NotNull Hero hero, String portrait){
        hero.setBigPortrait(portrait);
        repo.save(hero);
    }
    public void addSmallPortrait (@NotNull Hero hero, String portrait){
        hero.setSmallPortrait(portrait);
        repo.save(hero);
    }
    public void addSmallName (@NotNull Hero hero, String name){
        hero.setSmallName(name);
        repo.save(hero);
    }
    public void addYearsOfLife (@NotNull Hero hero, String yearsOfLife){
        hero.setYearsOfLife(yearsOfLife);
        repo.save(hero);
    }
    public void deleteById (@NotNull Long id) {
        Optional<Hero> heroFromDB = repo.findById(id);

        if(heroFromDB.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new NullPointerException("Герой не найден");
        }
    }
}
