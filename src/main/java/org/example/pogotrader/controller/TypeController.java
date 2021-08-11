package org.example.pogotrader.controller;

import org.example.pogotrader.repository.TypeRepository;
import org.example.pogotrader.mapper.TypeDto;
import org.example.pogotrader.mapper.TypeDtoModelAssembler;
import org.example.pogotrader.mapper.TypeSlimDto;
import org.example.pogotrader.mapper.TypeSlimDtoModelAssembler;
import org.example.pogotrader.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeController {

  private TypeRepository typeRepository;
  private TypeSlimDtoModelAssembler typeSlimAssembler;
  private TypeDtoModelAssembler typeAssembler;

  @Autowired
  public TypeController(TypeRepository typeRepository, TypeSlimDtoModelAssembler typeSlimAssembler, TypeDtoModelAssembler typeAssembler) {
    this.typeRepository = typeRepository;
    this.typeSlimAssembler = typeSlimAssembler;
    this.typeAssembler = typeAssembler;
  }

  @GetMapping("/api/typings")
  public Iterable<Type> findAll() {
    return typeRepository.findAll();
  }

  @GetMapping("api/type/name/{name}")
  public ResponseEntity<TypeDto> findByName(@PathVariable String name) {
    return new ResponseEntity<>(typeAssembler.toModel(typeRepository.findByNameIgnoreCase(name)), HttpStatus.OK);
  }

  // @GetMapping("api/type")
  // public Type findById(@RequestParam String id) {
  // return typeRepository.findById(Integer.parseInt(id));
  // }

  @GetMapping("api/type/id/{id}")
  public ResponseEntity<TypeDto> findById(@PathVariable int id) {
    return new ResponseEntity<>(typeAssembler.toModel(typeRepository.findById(id)), HttpStatus.OK);
  }

}
