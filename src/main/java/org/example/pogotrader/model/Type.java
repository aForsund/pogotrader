package org.example.pogotrader.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Type {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  // Avoid infinite recursion when creating JSON response
  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "weak_to")
  private Set<Type> weakTo = new HashSet<>();

  // Avoid infinite recursion when creating JSON response
  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "strong_against")
  private Set<Type> strongAgainst = new HashSet<>();

  // Avoid infinite recursion when creating JSON response
  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "resistant_to")
  private Set<Type> resistantTo = new HashSet<>();

  // Avoid infinite recursion when creating JSON response
  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "not_very_effective_against")
  private Set<Type> notVeryEffectiveAgainst = new HashSet<>();

  // Avoid infinite recursion when creating JSON response
  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "immune_to")
  private Set<Type> immuneTo = new HashSet<>();

  // Avoid infinite recursion when creating JSON response
  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "not_effective_against")
  private Set<Type> notEffectiveAgainst = new HashSet<>();

  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
  private Set<FastMove> fastMoves = new HashSet<>();

  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves" })
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
  private Set<ChargedMove> chargedMoves = new HashSet<>();

  public Type() {
  }

  public Type(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "Type: " + this.name;
  }

  public Set<Type> getWeakTo() {
    return this.weakTo;
  }

  public void addWeakTo(Type type) {
    this.weakTo.add(type);
  }

  public void addStrongAgainst(Type type) {
    this.strongAgainst.add(type);
  }

  public Set<Type> getStrongAgainst() {
    return this.strongAgainst;
  }

  public void addResistantTo(Type type) {
    this.resistantTo.add(type);
  }

  public Set<Type> getResistantTo() {
    return this.resistantTo;
  }

  public void addNotVeryEffectiveAgainst(Type type) {
    this.notVeryEffectiveAgainst.add(type);
  }

  public Set<Type> getNotVeryEffectiveAgainst() {
    return this.notVeryEffectiveAgainst;
  }

  public void addImmuneTo(Type type) {
    this.immuneTo.add(type);
  }

  public Set<Type> getImmuneTo() {
    return this.immuneTo;
  }

  public void addNotEffectiveAgainst(Type type) {
    this.notEffectiveAgainst.add(type);
  }

  public Set<Type> getNotEffectiveAgainst() {
    return this.notEffectiveAgainst;
  }

  public void addFastMove(FastMove move) {
    this.fastMoves.add(move);
  }

  public Set<FastMove> getFastMoves() {
    return this.fastMoves;
  }

  public void addChargedMove(ChargedMove move) {
    this.chargedMoves.add(move);
  }

  public Set<ChargedMove> getChargedMoves() {
    return this.chargedMoves;
  }

  @Override
  public boolean equals(Object compared) {
    if (this == compared) {
      return true;
    }

    if (!(compared instanceof Type)) {
      return false;
    }

    Type comparedType = (Type) compared;
    if (comparedType.getName().equals(this.name)) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hashCode;
    try {
      hashCode = Integer.parseInt(this.name);

    } catch (NumberFormatException e) {
      hashCode = 0;
    }
    return hashCode;

  }

}
