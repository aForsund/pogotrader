package org.example.pogotrader.repository;

import java.util.HashSet;

import org.example.pogotrader.model.PokedexEntry;
import org.springframework.data.repository.CrudRepository;

public interface PokedexRepository extends CrudRepository<PokedexEntry, Integer> {

  HashSet<PokedexEntry> findByNameIgnoreCase(String name);

  HashSet<PokedexEntry> findByNumber(int number);

  PokedexEntry findById(int number);

  HashSet<PokedexEntry> findAll();

  boolean existsById(int id);

}
