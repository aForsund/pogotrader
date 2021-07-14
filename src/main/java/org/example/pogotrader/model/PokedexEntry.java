package org.example.pogotrader.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.CascadeType;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokedexEntry {

  @Id
  private int id;
  private int number;

  // "typing",

  @OneToOne
  @JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
      "notEffectiveAgainst", "fastMoves", "chargedMoves", "type", "pokedexEntries", "pokedexRegionEntries",
      "nextEvolution", "prevEvolution", "region", "move" })
  @JoinTable(name = "pokedex_next_evolution")

  private PokedexEntry nextEvolution;

  @OneToOne
  @JoinTable(name = "pokedex_prev_evolution")
  private PokedexEntry prevEvolution;

  private String name;

  private String color;
  private int attack;
  private int defense;
  private int health;
  private int combatPower;
  private boolean legendary;
  private boolean mythical;
  private boolean mega;
  private boolean shadow;
  private boolean shiny;
  private double height;
  private double weight;

  // Moves
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_fast_move", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "fast_move_id") })
  private Set<FastMove> fastMoves = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_elite_fast_move", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "fast_move_id") })
  private Set<FastMove> eliteFastMoves = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_legacy_fast_move", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "fast_move_id") })
  private Set<FastMove> legacyFastMoves = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_charged_move", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "charged_move_id") })
  private Set<ChargedMove> chargedMoves = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_elite_charged_move", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "charged_move_id") })
  private Set<ChargedMove> eliteChargedMoves = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_legacy_charged_move", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "charged_move_id") })
  private Set<ChargedMove> legacyChargedMoves = new HashSet<>();

  // Typing

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_type", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "type_id") })
  private Set<Type> typing = new HashSet<>();

  // Region
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "region_id", referencedColumnName = "id")
  private Region region;

  // Constructors
  public PokedexEntry() {
  }

  public PokedexEntry(int id) {
    this.id = id;
  }

  // Getters & Setters
  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public PokedexEntry getNextEvolution() {
    return this.nextEvolution;
  }

  public void setNextEvolution(PokedexEntry nextEvolution) {
    this.nextEvolution = nextEvolution;
  }

  public void setPrevEvolution(PokedexEntry prevEvolution) {
    this.prevEvolution = prevEvolution;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Type> getTyping() {
    return this.typing;
  }

  public void addTyping(Type type) {
    this.typing.add(type);
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int hp) {
    this.health = hp;
  }

  public int getCombatPower() {
    return combatPower;
  }

  public void setCombatPower(int maxCP) {
    this.combatPower = maxCP;
  }

  public Region getRegion() {
    return this.region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  public boolean isLegendary() {
    return this.legendary;
  }

  public void setLegendary(boolean legendary) {
    this.legendary = legendary;
  }

  public boolean isMythical() {
    return this.mythical;
  }

  public void setMythical(boolean mythical) {
    this.mythical = mythical;
  }

  public boolean isMega() {
    return mega;
  }

  public void setMega(boolean mega) {
    this.mega = mega;
  }

  public boolean isShadow() {
    return this.shadow;
  }

  public void setShadow(boolean shadow) {
    this.shadow = shadow;
  }

  public boolean hasShiny() {
    return this.shiny;
  }

  public void setShiny(boolean shiny) {
    this.shiny = shiny;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public PokedexEntry getPrevEvolution() {
    return prevEvolution;
  }

  public void seMega(boolean hasMega) {
    this.mega = hasMega;
  }

  public boolean isShiny() {
    return shiny;
  }

  public Set<FastMove> getFastMoves() {
    return fastMoves;
  }

  public void setFastMoves(Set<FastMove> fastMoves) {
    this.fastMoves = fastMoves;
  }

  public Set<FastMove> getEliteFastMoves() {
    return eliteFastMoves;
  }

  public void setEliteFastMoves(Set<FastMove> eliteFastMoves) {
    this.eliteFastMoves = eliteFastMoves;
  }

  public Set<FastMove> getLegacyFastMoves() {
    return legacyFastMoves;
  }

  public void setLegacyFastMoves(Set<FastMove> legacyFastMoves) {
    this.legacyFastMoves = legacyFastMoves;
  }

  public Set<ChargedMove> getChargedMoves() {
    return chargedMoves;
  }

  public void setChargedMoves(Set<ChargedMove> chargedMoves) {
    this.chargedMoves = chargedMoves;
  }

  public Set<ChargedMove> getEliteChargedMoves() {
    return eliteChargedMoves;
  }

  public void setEliteChargedMoves(Set<ChargedMove> eliteChargedMoves) {
    this.eliteChargedMoves = eliteChargedMoves;
  }

  public Set<ChargedMove> getLegacyChargedMoves() {
    return legacyChargedMoves;
  }

  public void setLegacyChargedMoves(Set<ChargedMove> legacyChargedMoves) {
    this.legacyChargedMoves = legacyChargedMoves;
  }

  @Override
  public String toString() {
    return "#" + this.number + " - " + this.name + " " + this.id;
  }

  @Override
  public boolean equals(Object compared) {
    if (this == compared) {
      return true;
    }

    if (!(compared instanceof PokedexEntry)) {
      return false;
    }

    PokedexEntry comparedEntry = (PokedexEntry) compared;
    if (comparedEntry.getId() == this.getId()) {
      return true;
    }

    return false;
  }

  @Override
  public int hashCode() {
    int hashCode;
    try {
      hashCode = Integer.parseInt(this.name) + this.id;

    } catch (NumberFormatException e) {
      hashCode = 0;
    }
    return hashCode;

  }

}
