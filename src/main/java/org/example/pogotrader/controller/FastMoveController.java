package org.example.pogotrader.controller;

import org.example.pogotrader.repository.FastMoveRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.pogotrader.model.FastMove;

@RestController
public class FastMoveController {

  private FastMoveRepository fastMoveRepository;

  public FastMoveController(FastMoveRepository fastMoveRepository) {
    this.fastMoveRepository = fastMoveRepository;
  }

  @GetMapping("/api/fastMoves")
  public Iterable<FastMove> findAll() {
    return fastMoveRepository.findAll();
  }

  @GetMapping("/api/fastMove")
  public FastMove findByName(@RequestParam String name) {
    return fastMoveRepository.findByName(name);
  }
}
