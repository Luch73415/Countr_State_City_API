package com.github.andrelugomes.states.repositories;

import com.github.andrelugomes.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByName(String name);
}
