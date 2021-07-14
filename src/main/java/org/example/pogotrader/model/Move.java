package org.example.pogotrader.model;

//import java.util.HashSet;
//import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.JoinColumn;

//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// "type", "pokedexEntries",

@MappedSuperclass
@JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
    "notEffectiveAgainst", "fastMoves", "chargedMoves", "pokedexRegionEntries", "nextEvolution", "prevEvolution",
    "typing", "region", "move" })
public abstract class Move {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "type_id", referencedColumnName = "id")
  private Type type;

  // @ManyToMany(mappedBy = "moves", cascade = CascadeType.ALL)
  // private Set<PokedexEntry> pokedex = new HashSet<>();

  // @ManyToMany(cascade = CascadeType.ALL)
  // @JoinTable(name = "pokedex_moves")
  // private Set<PokedexEntry> pokedexList = new HashSet<>();

  // @ManyToMany(cascade = CascadeType.ALL)
  // @JoinTable(name = "legacy_moves", joinColumns = { @JoinColumn(name =
  // "move_id") }, inverseJoinColumns = {
  // @JoinColumn(name = "move_set_id") })
  // private Set<MoveSet> legacyMoves = new HashSet<>();

  // @ManyToMany(cascade = CascadeType.ALL)
  // @JoinTable(name = "elite_moves", joinColumns = { @JoinColumn(name =
  // "move_id") }, inverseJoinColumns = {
  // @JoinColumn(name = "move_set_id") })
  // private Set<MoveSet> eliteMoves = new HashSet<>();

  public Move(String name, Type type) {
    this.name = name;
    this.type = type;
  }

  public Move() {

  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public Type getType() {
    return this.type;
  }

  // public void setPokedex(Set<PokedexEntry> pokedexList) {
  // this.pokedex = pokedexList;
  // }

  // public void addPokedexList(PokedexEntry entry) {
  // this.pokedex.add(entry);
  // }

  // public Set<PokedexEntry> getPokedexList() {
  // return this.pokedex;
  // }

  @Override
  public boolean equals(Object compared) {
    if (this == compared) {
      return true;
    }

    if (!(compared instanceof Move)) {
      return false;
    }

    Move comparedMove = (Move) compared;

    if (comparedMove.getName() == null) {
      return false;
    }
    if (comparedMove.getName().equals(this.name)) {
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
