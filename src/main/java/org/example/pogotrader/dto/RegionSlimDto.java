package org.example.pogotrader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Getter
@Setter
@Data
public class RegionSlimDto extends RepresentationModel<RegionSlimDto> {

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;
}
