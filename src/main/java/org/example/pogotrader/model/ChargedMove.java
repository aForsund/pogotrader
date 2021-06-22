
package org.example.pogotrader.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class ChargedMove extends Move {

  private int power;
  private double damageWindow;
  private double cooldown;
  private int bars;

  private int damage;
  private int energy;

  @OneToOne(mappedBy = "move", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Effect effect;

  public ChargedMove() {

  }

  public ChargedMove(String name, Type type) {
    super(name, type);
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public double getDamageWindow() {
    return damageWindow;
  }

  public void setDamageWindow(double damageWindow) {
    this.damageWindow = damageWindow;
  }

  public double getCooldown() {
    return cooldown;
  }

  public void setCooldown(double cooldown) {
    this.cooldown = cooldown;
  }

  public int getBars() {
    return bars;
  }

  public void setBars(int bars) {
    this.bars = bars;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getEnergy() {
    return energy;
  }

  public void setEnergy(int energy) {
    this.energy = energy;
  }

  public Effect getEffect() {
    return effect;
  }

  public void setEffect(Effect effect) {
    this.effect = effect;
  }

}
