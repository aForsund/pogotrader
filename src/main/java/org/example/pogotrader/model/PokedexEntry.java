package org.example.pogotrader.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PokedexEntry {

  @Id
  private int id;
  private int number;
  private int code;
  private int nextEvolution;
  private int prevEvolution;
  private String name;
  private String typeOne;
  private String typeTwo;
  private String color;
  private int attack;
  private int defense;
  private int health;
  private int combatPower;
  private int region;
  private boolean legendary;
  private boolean mythical;
  private boolean mega;
  private boolean shadow;
  private boolean shiny;
  private double height;
  private double weight;

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

  public int getNextEvolution() {
    return nextEvolution;
  }

  public void setNextEvolution(int nextEvolution) {
    this.nextEvolution = nextEvolution;
  }

  public int getPrevEvolution() {
    return prevEvolution;
  }

  public void setPrevEvolution(int prevEvolution) {
    this.prevEvolution = prevEvolution;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTypeOne() {
    return typeOne;
  }

  public void setTypeOne(String typeOne) {
    this.typeOne = typeOne;
  }

  public String getTypeTwo() {
    return typeTwo;
  }

  public void setTypeTwo(String typeTwo) {
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

  public int getRegion() {
    return region;
  }

  public void setRegion(int region) {
    this.region = region;
  }

  public boolean isLegendary() {
    return legendary;
  }

  public void setLegendary(boolean legendary) {
    this.legendary = legendary;
  }

  public boolean isMythical() {
    return mythical;
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
    return shadow;
  }

  public void setShadow(boolean shadow) {
    this.shadow = shadow;
  }

  public boolean isShiny() {
    return shiny;
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

  @Override
  public String toString() {
    return "#" + this.number + " - " + this.name + " " + this.id;
  }

}
