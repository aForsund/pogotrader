package org.example.pogotrader.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

public class PokedexEntryDto extends RepresentationModel<PokedexEntryDto>{

  @JsonProperty("id")
  private int id;

  @JsonProperty("number")
  private int number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private Set<TypeSlimDto> typing;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }
  
  public void setNumber(int number) {
    this.number = number;
  }

  public int getNumber() {
    return this.number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setTyping(Set<TypeSlimDto> typing) {
    this.typing = typing;
  }

  public Set<TypeSlimDto> getTyping() {
    return this.typing;
  }

}
