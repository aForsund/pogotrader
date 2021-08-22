package org.example.pogotrader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class FastMoveSlimDto extends RepresentationModel<FastMoveSlimDto> {

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

}
