package org.example.pogotrader.modelAssembler;

import org.example.pogotrader.controller.PokedexController;
import org.example.pogotrader.controller.RegionController;
import org.example.pogotrader.dto.PokedexEntrySlimDto;
import org.example.pogotrader.dto.RegionDto;
import org.example.pogotrader.mapper.RegionMapper;
import org.example.pogotrader.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class RegionDtoModelAssembler implements RepresentationModelAssembler<Region, RegionDto> {

  @Autowired
  private RegionMapper mapper;

  @Override
  public RegionDto toModel(Region region) {

    // Create DTO
    RegionDto regionDTO = mapper.regionToRegionDto(region);

    // Add link to self
    Link selfLink = linkTo(methodOn(RegionController.class).findById(region.getId())).withSelfRel();
    regionDTO.add(selfLink);

    // Add link to pokedex entries
    for (PokedexEntrySlimDto entry : regionDTO.getRegionEntries()) {
      Link selfLinkRegionEntry = linkTo(methodOn(PokedexController.class).getById(entry.getId())).withSelfRel();
      entry.add(selfLinkRegionEntry);
    }

    return regionDTO;
  }

}
