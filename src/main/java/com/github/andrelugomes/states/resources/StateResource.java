package com.github.andrelugomes.states.resources;

import com.github.andrelugomes.states.entities.State;
import com.github.andrelugomes.states.repositories.StateRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StateResource {

  private final StateRepository repository;

  public StateResource(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/states")
  public List<State> states() {return repository.findAll();}

  @GetMapping({"/state_by_id/{id}"})
  public Optional<State> findById(@PathVariable long id){return repository.findById(id);}

  @GetMapping({"/state_by_name/{name}"})
  public List<State> findByName(@PathVariable String name){return repository.findByName(name);}

  @PostMapping({"/new_state"})
  public State createState(@RequestBody State state) { return repository.save(state);  }

  @DeleteMapping("delete_state_by_id/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteStateById(@PathVariable Long id) {
    repository.deleteById(id);
  }
  



}
