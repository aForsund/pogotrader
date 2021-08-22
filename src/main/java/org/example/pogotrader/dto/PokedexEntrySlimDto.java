package org.example.pogotrader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PokedexEntrySlimDto extends RepresentationModel<PokedexEntrySlimDto> {

  @JsonProperty
  private int id;

  @JsonProperty
  private String name;

  @JsonProperty
  private int number;
}
