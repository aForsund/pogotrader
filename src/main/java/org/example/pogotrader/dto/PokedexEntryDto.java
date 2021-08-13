package org.example.pogotrader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Data
public class PokedexEntryDto extends RepresentationModel<PokedexEntryDto> {

  @JsonProperty("id")
  private int id;

  @JsonProperty("number")
  private int number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("typing")
  private Set<TypeSlimDto> typing;

  @JsonProperty("region")
  private RegionSlimDto region;

}
