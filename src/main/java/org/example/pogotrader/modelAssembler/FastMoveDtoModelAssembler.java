package org.example.pogotrader.modelAssembler;

import org.example.pogotrader.controller.FastMoveController;
import org.example.pogotrader.dto.FastMoveDto;
import org.example.pogotrader.mapper.FastMoveMapper;
import org.example.pogotrader.model.FastMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class FastMoveDtoModelAssembler implements RepresentationModelAssembler<FastMove, FastMoveDto> {

  @Autowired
  private FastMoveMapper mapper;

  @Override
  public FastMoveDto toModel(FastMove fastMove) {

    // Create DTO
    FastMoveDto fastMoveDTO = mapper.fastMoveToFastMoveDto(fastMove);

    // Add link to self
    Link selfLink = linkTo(methodOn(FastMoveController.class).findById(fastMove.getId())).withSelfRel();
    fastMoveDTO.add(selfLink);

    return fastMoveDTO;
  }
}
