package com.github.andrelugomes.countries.repositories;

import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByName(String name);
}
