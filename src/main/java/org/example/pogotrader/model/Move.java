package org.example.pogotrader.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Move {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private Type type;

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
}
