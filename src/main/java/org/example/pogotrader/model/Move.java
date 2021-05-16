package org.example.pogotrader.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Move {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private Type type;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_list_moves")
  private Set<PokedexEntry> pokedexList = new HashSet<>();
  /*
   * @ManyToMany(cascade = CascadeType.ALL)
   * 
   * @JoinTable(name = "legacy_moves", joinColumns = { @JoinColumn(name =
   * "move_id") }, inverseJoinColumns = {
   * 
   * @JoinColumn(name = "legacymoves_id") }) private Set<MoveSet> legacyMoves =
   * new HashSet<>();
   * 
   * @ManyToMany(cascade = CascadeType.ALL)
   * 
   * @JoinTable(name = "elite_moves", joinColumns = { @JoinColumn(name =
   * "move_id") }, inverseJoinColumns = {
   * 
   * @JoinColumn(name = "elitemoves_id") }) private Set<MoveSet> eliteMoves = new
   * HashSet<>();
   */
  private double damagePerSecond;
  private double castTime;

  public Long getId() {
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

  public void setDamagePerSecond(double dps) {
    this.damagePerSecond = dps;
  }

  public double getDamagePerSecond() {
    return this.damagePerSecond;
  }

  public void setCastTime(double castTime) {
    this.castTime = castTime;
  }

  public double getCastTime() {
    return this.castTime;
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
