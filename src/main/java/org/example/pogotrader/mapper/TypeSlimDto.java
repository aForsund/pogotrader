package org.example.pogotrader.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TypeSlimDto extends RepresentationModel<TypeSlimDto> {

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

  @Override
  public String toString() {
    return "id: " + this.id + ", " + this.name;
  }

  
}
