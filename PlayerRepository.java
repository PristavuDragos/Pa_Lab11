package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Player;


public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
