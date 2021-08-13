package org.example.pogotrader.controller;

import org.example.pogotrader.repository.TypeRepository;
import org.example.pogotrader.dto.TypeDto;
import org.example.pogotrader.modelAssembler.TypeDtoModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeController {

  private TypeRepository typeRepository;
  private TypeDtoModelAssembler typeAssembler;

  @Autowired
  public TypeController(TypeRepository typeRepository, TypeDtoModelAssembler typeAssembler) {
    this.typeRepository = typeRepository;
    this.typeAssembler = typeAssembler;
  }

  // @GetMapping("/api/type/")
  // public ResponseEntity<Set<TypeDto>> findAll() {
  // return new
  // ResponseEntity<Set<TypeDto>>(typeAssembler.toCollectionModel(typeRepository.findAll()),
  // HttpStatus.OK);

  // }

  @GetMapping("api/type/name/{name}")
  public ResponseEntity<TypeDto> findByName(@PathVariable String name) {
    return new ResponseEntity<>(typeAssembler.toModel(typeRepository.findByNameIgnoreCase(name)), HttpStatus.OK);
  }

  @GetMapping("api/type/id/{id}")
  public ResponseEntity<TypeDto> findById(@PathVariable int id) {
    return new ResponseEntity<>(typeAssembler.toModel(typeRepository.findById(id)), HttpStatus.OK);
  }

}
