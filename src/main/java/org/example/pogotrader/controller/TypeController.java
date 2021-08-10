package org.example.pogotrader.controller;

import org.example.pogotrader.repository.TypeRepository;
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
  private TypeSlimDtoModelAssembler assembler;

  @Autowired
  public TypeController(TypeRepository typeRepository, TypeSlimDtoModelAssembler assembler) {
    this.typeRepository = typeRepository;
    this.assembler = assembler;
  }

  @GetMapping("/api/typings")
  public Iterable<Type> findAll() {
    return typeRepository.findAll();
  }

  @GetMapping("api/type")
  public Type findByName(@RequestParam String name) {
    return typeRepository.findByName(name);
  }

  // @GetMapping("api/type")
  // public Type findById(@RequestParam String id) {
  // return typeRepository.findById(Integer.parseInt(id));
  // }

  @GetMapping("api/type/id/{id}")
  public ResponseEntity<TypeSlimDto> findById(@PathVariable int id) {
    return new ResponseEntity<>(assembler.toModel(typeRepository.findById(id)), HttpStatus.OK);
  }

}
