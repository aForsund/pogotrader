package org.example.pogotrader.modelAssembler;

import org.example.pogotrader.controller.RegionController;
import org.example.pogotrader.dto.RegionSlimDto;
import org.example.pogotrader.mapper.RegionMapper;
import org.example.pogotrader.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class RegionSlimDtoModelAssembler implements RepresentationModelAssembler<Region, RegionSlimDto> {

  @Autowired
  private RegionMapper mapper;

  @Override
  public RegionSlimDto toModel(Region region) {

    RegionSlimDto regionDTO = mapper.regionToRegionSlimDto(region);
    Link selfLink = linkTo(methodOn(RegionController.class).findById(region.getId())).withSelfRel();
    regionDTO.add(selfLink);

    return regionDTO;
  }

}
