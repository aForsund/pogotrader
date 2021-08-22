package org.example.pogotrader.controller;

import org.example.pogotrader.repository.PokedexRepository;

import java.util.Set;

import org.example.pogotrader.mapper.PokedexEntryMapper;
import org.example.pogotrader.dto.PokedexEntryDto;
import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.modelAssembler.PokedexEntryDtoModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/pokedex")
public class PokedexController {

  private PokedexEntryDtoModelAssembler pokedexAssembler;
  private PokedexRepository pokedexRepository;

  @Autowired
  public PokedexController(PokedexRepository pokedexRepository, PokedexEntryDtoModelAssembler pokedexAssembler) {
    this.pokedexRepository = pokedexRepository;
    this.pokedexAssembler = pokedexAssembler;
  }

  @GetMapping()
  public Iterable<PokedexEntry> findAll() {
    return pokedexRepository.findAll();
  }

  @GetMapping("/number/{number}")
  public ResponseEntity<Set<PokedexEntryDto>> getByNumber(@PathVariable String number) {
    System.out.println("hi from pokedexController (number)");
    Set<PokedexEntryDto> pokedexEntries = pokedexAssembler
        .toSet(pokedexRepository.findByNumber(Integer.parseInt(number)));

    return new ResponseEntity<Set<PokedexEntryDto>>(pokedexEntries, HttpStatus.OK);

  }

  @GetMapping("/name/{name}")
  public ResponseEntity<Set<PokedexEntryDto>> getByName(@PathVariable(value = "name") String name) {
    return new ResponseEntity<>(pokedexAssembler.toSet(pokedexRepository.findByNameIgnoreCase(name)), HttpStatus.OK);
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<PokedexEntryDto> getById(@PathVariable int id) {
    return new ResponseEntity<>(pokedexAssembler.toModel(pokedexRepository.findById(id)), HttpStatus.OK);
  }

}
