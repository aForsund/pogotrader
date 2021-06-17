package org.example.pogotrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FastMove extends Move {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int pvePower;
  private double pveCooldown;
  private int pveEnergy;

  private int pvpDamage;
  private int pvpEnergy;
  private int pvpTurns;

  public FastMove() {
    super();
  }

  public int getPvePower() {
    return pvePower;
  }

  public int getId() {
    return this.id;
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
