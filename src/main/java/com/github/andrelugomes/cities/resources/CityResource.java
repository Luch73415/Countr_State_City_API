package com.github.andrelugomes.cities.resources;

import com.github.andrelugomes.cities.entities.City;
import com.github.andrelugomes.cities.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CityResource {

  private final CityRepository repository;

  public CityResource(final CityRepository repository) {
    this.repository = repository;
  }

  @GetMapping("cities")
  public Page<City> cities(final Pageable page) {
    return repository.findAll(page);
  }

  @GetMapping({"/city_by_id/{id}"})
  public Optional<City> findById(@PathVariable long id) {
    return repository.findById(id);
  }
  @GetMapping({"/city_by_name/{name}"})
  public List<City> findByName(@PathVariable String name) {
    return repository.findByName(name);
  }
  @DeleteMapping("delete_city_by_id/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCityById(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
