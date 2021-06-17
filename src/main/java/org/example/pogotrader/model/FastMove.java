package org.example.pogotrader.model;

import javax.persistence.Entity;

@Entity
public class FastMove extends Move {

  private int pvePower;
  private double pveCooldown;
  private int pveEnergy;

  private int pvpDamage;
  private int pvpEnergy;
  private int pvpTurns;

  public FastMove() {
  }

  public FastMove(String name, Type type) {
    super(name, type);
  }

  public int getPvePower() {
    return pvePower;
  }

  public void setPvePower(int pvePower) {
    this.pvePower = pvePower;
  }

  public double getPveCooldown() {
    return pveCooldown;
  }

  public void setPveCooldown(double pveCooldown) {
    this.pveCooldown = pveCooldown;
  }

  public int getPveEnergy() {
    return pveEnergy;
  }

  public void setPveEnergy(int pveEnergy) {
    this.pveEnergy = pveEnergy;
  }

  public int getPvpDamage() {
    return pvpDamage;
  }

  public void setPvpDamage(int pvpDamage) {
    this.pvpDamage = pvpDamage;
  }

  public int getPvpEnergy() {
    return pvpEnergy;
  }

  public void setPvpEnergy(int pvpEnergy) {
    this.pvpEnergy = pvpEnergy;
  }

  public int getPvpTurns() {
    return pvpTurns;
  }

  public void setPvpTurns(int pvpTurns) {
    this.pvpTurns = pvpTurns;
  }

}
