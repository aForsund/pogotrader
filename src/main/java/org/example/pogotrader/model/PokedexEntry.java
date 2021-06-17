package org.example.pogotrader.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.CascadeType;

@Entity
public class PokedexEntry {

  @Id
  private int id;
  private int number;
  private int code;
  @OneToOne
  private PokedexEntry nextEvolution;
  @OneToOne
  private PokedexEntry prevEvolution;
  private String name;

  @OneToOne
  private Type typeOne;

  @OneToOne
  private Type typeTwo;

  private String color;
  private int attack;
  private int defense;
  private int health;
  private int combatPower;

  @OneToOne
  private Region region;
  private boolean isLegendary;
  private boolean isMythical;
  private boolean hasMega;
  private boolean isShadow;
  private boolean hasShiny;
  private double height;
  private double weight;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "pokedex_entry_move", joinColumns = {
      @JoinColumn(name = "pokedex_entry_id") }, inverseJoinColumns = { @JoinColumn(name = "fast_move_id") })
  private Set<FastMove> moves = new HashSet<>();

  public PokedexEntry() {
  }

  public PokedexEntry(int number, String name) {
    this.number = number;
    this.name = name;
  }

  public PokedexEntry(int id, int number, String name) {
    this(number, name);
    this.id = id;

  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
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

  public PokedexEntry getPreviousEvolution() {
    return prevEvolution;
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

  public Type getTypeOne() {
    return typeOne;
  }

  public void setTypeOne(Type typeOne) {
    this.typeOne = typeOne;
  }

  public Type getTypeTwo() {
    return typeTwo;
  }

  public void setTypeTwo(Type typeTwo) {
    this.typeTwo = typeTwo;
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
    return this.isLegendary;
  }

  public void setLegendary(boolean legendary) {
    this.isLegendary = legendary;
  }

  public boolean isMythical() {
    return this.isMythical;
  }

  public void setMythical(boolean mythical) {
    this.isMythical = mythical;
  }

  public boolean isMega() {
    return hasMega;
  }

  public void setMega(boolean mega) {
    this.hasMega = mega;
  }

  public boolean isShadow() {
    return this.isShadow;
  }

  public void setShadow(boolean shadow) {
    this.isShadow = shadow;
  }

  public boolean hasShiny() {
    return this.hasShiny;
  }

  public void setShiny(boolean shiny) {
    this.hasShiny = shiny;
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

  public void setMoves(Set<FastMove> moveSet) {
    this.moves = moveSet;
  }

  public void addMove(FastMove move) {
    this.moves.add(move);
  }

  public Set<FastMove> getMoves() {
    return this.moves;
  }

  @Override
  public String toString() {
    return "#" + this.number + " - " + this.name + " " + this.id;
  }

}
