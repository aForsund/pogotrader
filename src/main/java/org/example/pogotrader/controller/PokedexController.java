package org.example.pogotrader.controller;

import org.example.pogotrader.repository.PokedexRepository;

import java.util.HashSet;

import org.example.pogotrader.mapper.ModelMapper;
import org.example.pogotrader.mapper.PokedexEntryDto;
import org.example.pogotrader.model.PokedexEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("api/pokedex")
public class PokedexController {


  private ModelMapper pokemonMapper;
  private PokedexRepository pokedexRepository;

  @Autowired
  public PokedexController(ModelMapper pokemonMapper, PokedexRepository pokedexRepository) {
    this.pokedexRepository = pokedexRepository;
    this.pokemonMapper = pokemonMapper;
  }

  @GetMapping()
  public Iterable<PokedexEntry> findAll() {
    return pokedexRepository.findAll();
  }

  @GetMapping("/number")
  public ResponseEntity<HashSet<PokedexEntryDto>> getByNumber(@RequestParam String number) {

    HashSet<PokedexEntryDto> pokedexEntries = pokemonMapper
        .pokedexEntryToPokedexEntryDto(pokedexRepository.findByNumber(Integer.parseInt(number)));
    for (PokedexEntryDto entry : pokedexEntries) {
      entry.add(linkTo(methodOn(PokedexController.class).getById(entry.getId())).withSelfRel());
    }

    return new ResponseEntity<HashSet<PokedexEntryDto>>(pokedexEntries, HttpStatus.OK);

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

  @GetMapping("/id")
  public ResponseEntity<PokedexEntryDto> getById(@RequestParam int id) {
    return new ResponseEntity<>(pokemonMapper.pokedexEntryToPokedexEntryDto(pokedexRepository.findById(id)),
        HttpStatus.OK);
  }

}
