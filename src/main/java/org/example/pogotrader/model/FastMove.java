package org.example.pogotrader.model;

import javax.persistence.Entity;

@Entity
public class FastMove extends Move {

  private int raidPower;
  private double cooldown;
  private int raidEnergy;

  private int power;
  private int energy;
  private int turns;

  public FastMove() {
  }

  public FastMove(String name, Type type) {
    super(name, type);
  }

  public int getRaidPower() {
    return raidPower;
  }

  public void setRaidPower(int power) {
    this.raidPower = power;
  }

  public double getCooldown() {
    return cooldown;
  }

  public void setCooldown(double pveCooldown) {
    this.cooldown = pveCooldown;
  }

  public int getRaidEnergy() {
    return raidEnergy;
  }

  public void setRaidEnergy(int energy) {
    this.raidEnergy = energy;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public int getEnergy() {
    return energy;
  }

  public void setEnergy(int energy) {
    this.energy = energy;
  }

  public int getTurns() {
    return turns;
  }

  public void setTurns(int turns) {
    this.turns = turns;
  }

  @Override
  public int hashCode() {
    int hashCode;
    try {
      hashCode = Integer.parseInt(this.getName());
    } catch (NumberFormatException e) {
      hashCode = 0;
    }
    return hashCode;
  }
  /*
   * @Override public boolean equals(Object compared) { if (this == compared) {
   * return true; }
   * 
   * if (!(compared instanceof FastMove)) { return false; }
   * 
   * FastMove comparedMove = (FastMove) compared; if
   * (comparedMove.getName().equals(this.getName())) { return true; }
   * 
   * return false; }
   */

}
