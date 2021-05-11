package org.example.pogotrader.model;

import javax.persistence.Entity;

@Entity
public class ChargedMove extends Move {

  private int bars;
  private int energyDrain;

  public ChargedMove() {
  }

  public void setBars(int bars) {
    this.bars = bars;
  }

  public void setEnergyDrain(int energyDrain) {
    this.energyDrain = energyDrain;
  }

  public int getBars() {
    return this.bars;
  }

  public int getEnergyDrain() {
    return this.energyDrain;
  }

}
