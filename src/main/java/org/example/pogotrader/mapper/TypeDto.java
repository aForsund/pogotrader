package org.example.pogotrader.mapper;

import org.example.pogotrader.model.Type;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TypeDto extends RepresentationModel<TypeDto> {
  
  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("weakTo")
  private Set<TypeSlimDto> weakTo;

  @JsonProperty("strongAgainst")
  private Set<TypeSlimDto> strongAgainst;

  @JsonProperty("resistantTo")
  private Set<TypeSlimDto> resistantTo;

  @JsonProperty("notVeryEffectiveAgainst")
  private Set<TypeSlimDto> notVeryEffectiveAgainst;

  @JsonProperty("immuneTo")
  private Set<TypeSlimDto> immuneTo;

}
