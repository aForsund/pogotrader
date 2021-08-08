package org.example.pogotrader.mapstruct;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class PokedexEntryDto {

  @JsonProperty("number")
  private int number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private Set<TypeSlimDto> typing;

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
