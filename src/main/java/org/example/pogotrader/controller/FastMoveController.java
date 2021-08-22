package org.example.pogotrader.controller;

import org.example.pogotrader.repository.FastMoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.pogotrader.dto.FastMoveDto;
import org.example.pogotrader.model.FastMove;
import org.example.pogotrader.modelAssembler.FastMoveDtoModelAssembler;

@RestController
@RequestMapping("api/fastMove")
public class FastMoveController {

  private FastMoveRepository fastMoveRepository;
  private FastMoveDtoModelAssembler fastMoveAssembler;

  @Autowired
  public FastMoveController(FastMoveRepository fastMoveRepository, FastMoveDtoModelAssembler fastMoveAssembler) {
    this.fastMoveRepository = fastMoveRepository;
    this.fastMoveAssembler = fastMoveAssembler;
  }

  @GetMapping("/")
  public Iterable<FastMove> getAll() {
    return fastMoveRepository.findAll();
  }

  @GetMapping("/name/{name}")
  public Iterable<FastMove> getByName(@PathVariable String name) {
    return fastMoveRepository.findByName(name);
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<FastMoveDto> findById(@PathVariable int id) {
    return new ResponseEntity<>(fastMoveAssembler.toModel(fastMoveRepository.findById(id)), HttpStatus.OK);
  }
}
