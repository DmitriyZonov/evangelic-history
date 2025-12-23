package org.example.evangelhistory.repositories;

import org.example.evangelhistory.constants.Century;
import org.example.evangelhistory.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Security;
import java.util.Set;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    Hero findHeroBySmallName(String smallName);
    Set<Hero> findHeroesByCentury(Century century);
}
