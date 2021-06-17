package org.example.pogotrader.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import javax.persistence.Id;

@MappedSuperclass
public abstract class Move {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private Type type;

  @ManyToMany(mappedBy = "moves")
  private Set<PokedexEntry> pokedex = new HashSet<>();

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

  public void setPokedex(Set<PokedexEntry> pokedexList) {
    this.pokedex = pokedexList;
  }

  public void addPokedexList(PokedexEntry entry) {
    this.pokedex.add(entry);
  }

  public Set<PokedexEntry> getPokedexList() {
    return this.pokedex;
  }

}
