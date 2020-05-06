package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

}