package com.github.andrelugomes.countries.resources;

import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.countries.repositories.CountryRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryResource {

  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/countries")
  public List<Country> countries() {

    return repository.findAll();
  }

  @GetMapping({"/country_by_id/{id}"})
  public Optional<Country> findById(@PathVariable long id) {
    return repository.findById(id);
  }

  @GetMapping({"/country_by_name/{name}"})
  public List<Country> findByName(@PathVariable String name) {
    return repository.findByName(name);
  }

  @PostMapping({"/new_country"})
  public Country createCountry(@RequestBody Country country) {
    return repository.save(country);
  }

  @DeleteMapping("delete_country_by_id/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCountryById(@PathVariable Long id) {
    repository.deleteById(id);
  }
}