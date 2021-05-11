package org.example.pogotrader.model;

import javax.persistence.Entity;

@Entity
public class FastMove extends Move {

  private double energyPerSecond;

  public FastMove() {
  }

  public void setEnergyPerSecond(double number) {
    this.energyPerSecond = number;
  }

  public double getEnergyPerSecond() {
    return energyPerSecond;
  }

}
