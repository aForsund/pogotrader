package org.example.pogotrader.controller;

import org.example.pogotrader.repository.TypeRepository;
import org.example.pogotrader.model.Type;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeController {

  private TypeRepository typeRepository;

  public TypeController(TypeRepository typeRepository) {
    this.typeRepository = typeRepository;
  }

  @GetMapping("/api/typings")
  public Iterable<Type> findAll() {
    return typeRepository.findAll();
  }

  @GetMapping("api/type")
  public Type findByName(@RequestParam String name) {
    return typeRepository.findByName(name);
  }

}
