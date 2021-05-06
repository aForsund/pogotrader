package org.example.pogotrader.controller;

import org.example.pogotrader.repository.PokedexRepository;
import org.example.pogotrader.model.PokedexEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {

  private PokedexRepository pokedexRepository;

  public PokedexController(PokedexRepository pokedexRepository) {
    this.pokedexRepository = pokedexRepository;
  }

  @GetMapping("/api/pokedex")
  public Iterable<PokedexEntry> findAll() {
    return pokedexRepository.findAll();
  }

  /*
   * @GetMapping("/api/pokedex/number/{number}") public PokedexEntry
   * findByNumber(int number){
   * 
   * 
   * }
   * 
   * @GetMapping("/api/pokedex/name/{name}") public PokedexEntry getEntry(String
   * name){
   * 
   * 
   * }
   */
}
