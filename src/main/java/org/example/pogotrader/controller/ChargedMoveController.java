package org.example.pogotrader.controller;

import org.example.pogotrader.model.ChargedMove;
import org.example.pogotrader.repository.ChargedMoveRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChargedMoveController {

  private ChargedMoveRepository chargedMoveRepository;

  public ChargedMoveController(ChargedMoveRepository chargedMoveRepository) {
    this.chargedMoveRepository = chargedMoveRepository;
  }

  @GetMapping("api/chargedMoves")
  public Iterable<ChargedMove> findAll() {
    return chargedMoveRepository.findAll();
  }

  @GetMapping("api/chargedMove")
  public Iterable<ChargedMove> findByName(@RequestParam String name) {
    return chargedMoveRepository.findByName(name);
  }

}
