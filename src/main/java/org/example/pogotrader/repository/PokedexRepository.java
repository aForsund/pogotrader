package org.example.pogotrader.repository;

import org.example.pogotrader.model.PokedexEntry;
import org.springframework.data.repository.CrudRepository;

public interface PokedexRepository extends CrudRepository<PokedexEntry, Integer> {

  PokedexEntry findByName(String name);

  PokedexEntry findByNumber(int number);

}