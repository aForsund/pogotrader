package org.example.pogotrader.data;

import java.util.Set;

import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexService {

  @Autowired
  private PokedexRepository pokedexRepository;

  public PokedexService(PokedexRepository pokedexRepository) {
    this.pokedexRepository = pokedexRepository;
  }

  public Set<PokedexEntry> findByName(String name) {
    return pokedexRepository.findByNameIgnoreCase(name);
  }

  public PokedexEntry findById(int id) {
    return pokedexRepository.findById(id);
  }
}
