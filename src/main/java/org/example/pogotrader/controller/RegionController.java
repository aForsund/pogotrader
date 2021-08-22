package org.example.pogotrader.controller;

import org.example.pogotrader.dto.RegionDto;
import org.example.pogotrader.modelAssembler.RegionDtoModelAssembler;
import org.example.pogotrader.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController {

  private RegionRepository regionRepository;
  private RegionDtoModelAssembler regionAssembler;

  @Autowired
  public RegionController(RegionRepository regionRepository, RegionDtoModelAssembler regionAssembler) {
    this.regionRepository = regionRepository;
    this.regionAssembler = regionAssembler;
  }

  @GetMapping("api/region/name/{name}")
  public ResponseEntity<RegionDto> findByName(@PathVariable String name) {
    return new ResponseEntity<>(regionAssembler.toModel(regionRepository.findByNameIgnoreCase(name)), HttpStatus.OK);
  }

  @GetMapping("api/region/id/{id}")
  public ResponseEntity<RegionDto> findById(@PathVariable int id) {
    return new ResponseEntity<>(regionAssembler.toModel(regionRepository.findById(id)), HttpStatus.OK);
  }

}
