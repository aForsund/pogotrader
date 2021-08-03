
package org.example.pogotrader.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({ "weakTo", "strongAgainst", "resistantTo", "notVeryEffectiveAgainst", "immuneTo",
    "notEffectiveAgainst", "fastMoves", "chargedMoves", "type", "pokedexEntries", "pokedexRegionEntries",
    "nextEvolution", "prevEvolution", "typing", "region", "move" })
public class Effect {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private double chance;
  private boolean selfAttack;
  private boolean selfDefense;
  private boolean opponentAttack;
  private boolean opponentDefense;
  private int modifier;

  @OneToOne(mappedBy = "effect", cascade = CascadeType.ALL)
  private ChargedMove move;

  public Effect() {
    this.selfAttack = false;
    this.selfDefense = false;
    this.opponentAttack = false;
    this.opponentDefense = false;
  }

  public Effect(double chance, boolean selfAtk, boolean selfDef, boolean oppAtk, boolean oppDef, int modifier) {
    this.chance = chance;
    this.selfAttack = selfAtk;
    this.selfDefense = selfDef;
    this.opponentAttack = oppAtk;
    this.opponentDefense = oppDef;
    this.modifier = modifier;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public void setChance(double chance) {
    this.chance = chance;
  }

  public double getChance() {
    return this.chance;
  }

  public void setSelfAttack(boolean value) {
    this.selfAttack = value;
  }

  public boolean getSelfAttack() {
    return this.selfAttack;
  }

  public void setSelfDefense(boolean value) {
    this.selfDefense = value;
  }

  public boolean getSelfDefense() {
    return this.selfDefense;
  }

  public void setOpponentAttack(boolean value) {
    this.opponentAttack = value;
  }

  public boolean getOpponentAttack() {
    return this.opponentAttack;
  }

  public void setOpponentDefense(boolean value) {
    this.opponentDefense = value;
  }

  public boolean getOpponentDefense() {
    return this.opponentDefense;
  }

  public void setModifier(int modifier) {
    this.modifier = modifier;
  }

  public int getModifier() {
    return this.modifier;
  }

}
