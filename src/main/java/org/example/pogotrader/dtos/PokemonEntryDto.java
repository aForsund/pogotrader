package org.example.pogotrader.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class PokemonEntryDto {

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private Set<TypeDto> typing;

}
