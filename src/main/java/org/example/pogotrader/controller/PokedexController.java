package org.example.pogotrader.controller;

import org.example.pogotrader.repository.PokedexRepository;

import java.util.HashSet;

import org.example.pogotrader.mapstruct.MapStructMapper;
import org.example.pogotrader.mapstruct.PokedexEntryDto;

import org.example.pogotrader.model.PokedexEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/pokedex")
public class PokedexController {

  private MapStructMapper pokemonMapper;
  private PokedexRepository pokedexRepository;

  @Autowired
  public PokedexController(MapStructMapper pokemonMapper, PokedexRepository pokedexRepository) {
    this.pokedexRepository = pokedexRepository;
    this.pokemonMapper = pokemonMapper;
  }

  @GetMapping()
  public Iterable<PokedexEntry> findAll() {
    return pokedexRepository.findAll();
  }

  @GetMapping("/number")
  public ResponseEntity<HashSet<PokedexEntryDto>> getByNumber(@RequestParam String number) {
    return new ResponseEntity<HashSet<PokedexEntryDto>>(
        pokemonMapper.pokedexEntryToPokedexEntryDto(pokedexRepository.findByNumber(Integer.parseInt(number))),
        HttpStatus.OK);

  }

  @GetMapping("/name")
  public ResponseEntity<HashSet<PokedexEntryDto>> getByName(@PathVariable(value = "name") String name) {
    return new ResponseEntity<>(
        pokemonMapper.pokedexEntryToPokedexEntryDto(pokedexRepository.findByNameIgnoreCase(name)), HttpStatus.OK);

  }

  @GetMapping("/test")
  public ResponseEntity<PokedexEntryDto> getByNumber() {
    return new ResponseEntity<>(pokemonMapper.pokedexEntryToPokedexEntryDto(pokedexRepository.findById(0)),
        HttpStatus.OK);
  }

}
