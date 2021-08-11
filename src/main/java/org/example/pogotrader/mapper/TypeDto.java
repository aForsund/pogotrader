package org.example.pogotrader.mapper;

import org.example.pogotrader.model.Type;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

public class TypeDto extends RepresentationModel<TypeDto> {

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("weakTo")
  private HashSet<TypeSlimDto> weakTo;

  @JsonProperty("strongAgainst")
  private Set<TypeSlimDto> strongAgainst;

  @JsonProperty("resistantTo")
  private Set<TypeSlimDto> resistantTo;

  @JsonProperty("notVeryEffectiveAgainst")
  private Set<TypeSlimDto> notVeryEffectiveAgainst;

  @JsonProperty("immuneTo")
  private Set<TypeSlimDto> immuneTo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HashSet<TypeSlimDto> getWeakTo() {
    return weakTo;
  }

  public void setWeakTo(HashSet<TypeSlimDto> weakTo) {
    this.weakTo = weakTo;
  }

  public void addWeakTo(TypeSlimDto weakTo) {
    this.weakTo.add(weakTo);
  }



  public Set<TypeSlimDto> getStrongAgainst() {
    return strongAgainst;
  }

  public void setStrongAgainst(Set<TypeSlimDto> strongAgainst) {
    this.strongAgainst = strongAgainst;
  
  }

  public Set<TypeSlimDto> getResistantTo() {
    return resistantTo;
  }

  public void setResistantTo(Set<TypeSlimDto> resistantTo) {
    this.resistantTo = resistantTo;
  }

  public Set<TypeSlimDto> getNotVeryEffectiveAgainst() {
    return notVeryEffectiveAgainst;
  }

  public void setNotVeryEffectiveAgainst(Set<TypeSlimDto> notVeryEffectiveAgainst) {
    this.notVeryEffectiveAgainst = notVeryEffectiveAgainst;
  }

  public Set<TypeSlimDto> getImmuneTo() {
    return immuneTo;
  }

  public void setImmuneTo(Set<TypeSlimDto> immuneTo) {
    this.immuneTo = immuneTo;
  }

}
