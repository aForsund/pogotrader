package org.example.pogotrader.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Move {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private Type type;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_moves")
  private Set<PokedexEntry> pokedexList = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "legacy_moves", joinColumns = { @JoinColumn(name = "move_id") }, inverseJoinColumns = {

      @JoinColumn(name = "legacymoves_id") })
  private Set<MoveSet> legacyMoves = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "elite_moves", joinColumns = { @JoinColumn(name = "move_id") }, inverseJoinColumns = {
      @JoinColumn(name = "elitemoves_id") })
  private Set<MoveSet> eliteMoves = new HashSet<>();

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

  public void setPokedexList(Set<PokedexEntry> pokedexList) {
    this.pokedexList = pokedexList;
  }

  public void addPokedexList(PokedexEntry entry) {
    this.pokedexList.add(entry);
  }

  public Set<PokedexEntry> getPokedexList() {
    return this.pokedexList;
  }

}
