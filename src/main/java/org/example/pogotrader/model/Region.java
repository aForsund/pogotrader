package org.example.pogotrader.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {

  @Id
  private int number;
  private String name;

  private ArrayList<PokedexEntry> entries;

  public Region(int number, String name) {
    this.entries = new ArrayList<>();
    this.number = number;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void addPokedexEntry(PokedexEntry pokedexEntry) {
    this.entries.add(pokedexEntry);
  }

}
