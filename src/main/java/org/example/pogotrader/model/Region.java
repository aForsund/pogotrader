package org.example.pogotrader.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {

  @Id
  private int id;
  private String name;

  public Region() {
  }

  public void setId(int number) {
    this.id = number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return name;
  }
}
